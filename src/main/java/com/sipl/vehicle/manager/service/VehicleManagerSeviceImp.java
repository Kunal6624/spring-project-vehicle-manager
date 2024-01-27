package com.sipl.vehicle.manager.service;

import java.security.Key;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sipl.vehicle.manager.dao.UserRepository;
import com.sipl.vehicle.manager.dao.VehicleRepository;
import com.sipl.vehicle.manager.dto.UserDto;
import com.sipl.vehicle.manager.dto.VehicleDto;
import com.sipl.vehicle.manager.exception.ResourceNotFoundException;
import com.sipl.vehicle.manager.mapper.UserMapper;
import com.sipl.vehicle.manager.mapper.VehicleMapper;
import com.sipl.vehicle.manager.model.ExportPdf;
import com.sipl.vehicle.manager.model.User;
import com.sipl.vehicle.manager.model.Vehicle;
import com.sipl.vehicle.manager.payload.ApiResponse;
import com.sipl.vehicle.manager.util.EncryptionUtil;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class VehicleManagerSeviceImp implements VehicleManagerService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VehicleMapper vehicleMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpServletResponse response;

	@Override
	public ApiResponse<VehicleDto> getAllVehicle(int pageNumber, int pageSize) {
		try {
			Page<Vehicle> vehicles = vehicleRepository.findAll(PageRequest.of(pageNumber, pageSize));
			System.out.println(vehicles);
			Page<VehicleDto> vehicleDtoPage = vehicleMapper.mapVehiclePageToVehilceDtoPage(vehicles);
			return new ApiResponse<VehicleDto>(null, null, vehicleDtoPage, null, "Vehicle List Page", HttpStatus.OK,
					false);
		} catch (Exception e) {
			return new ApiResponse<VehicleDto>(null, null, null, null, "Internal Server Error", HttpStatus.NOT_FOUND,
					true);
		}
	}

	@Override
	public ApiResponse<VehicleDto> addVehicle(VehicleDto theVehicleDto) {
		try {
			Vehicle theVehicle = vehicleMapper.mapVehicleDtoToVehicle(theVehicleDto);
			VehicleDto vehicleDto = vehicleMapper.mapVehicleToVehicleDto(vehicleRepository.save(theVehicle));
			return new ApiResponse<VehicleDto>(vehicleDto, null, null, null, "Vehicle added successfully",
					HttpStatus.OK, false);
		} catch (Exception e) {
			return new ApiResponse<VehicleDto>(null, null, null, null, "Internal Server Error", HttpStatus.NOT_FOUND,
					true);
		}
	}

	@Override
	public ApiResponse<VehicleDto> getVehicleById(int Id) {
		try {
			Vehicle theVehicle = vehicleRepository.findById(Id)
					.orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id", Id));

			VehicleDto theVehicleDto = vehicleMapper.mapVehicleToVehicleDto(theVehicle);
			return new ApiResponse<VehicleDto>(theVehicleDto, null, null, null, null, null, false);
			// return new ApiResponse<VehicleDto>(theVehicleDto, null, null, "Vehicle Data",
			// HttpStatus.OK, false);
		} catch (ResourceNotFoundException re) {
			return new ApiResponse<VehicleDto>(null, null, null, null, re.getMessage(), HttpStatus.NOT_FOUND, true);
		} catch (Exception e) {
			return new ApiResponse<VehicleDto>(null, null, null, null, "Internal Server Error", HttpStatus.NOT_FOUND,
					true);
		}
	}

	@Override
	public ApiResponse<VehicleDto> updateVehicle(VehicleDto vehicleDto, int Id) {

		try {
			// Check whether the employee exist in DB
			Vehicle existingVehicle = vehicleRepository.findById(Id)
					.orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id", Id));

			existingVehicle.setBrand(vehicleDto.getBrand());
			existingVehicle.setOwnerName(vehicleDto.getOwnerName());
			existingVehicle.setVehicleRegistrationNumber(vehicleDto.getVehicleRegistrationNumber());
			existingVehicle.setRegistrationExpires(vehicleDto.getRegistrationExpires());
			existingVehicle.setCreatedBy(vehicleDto.getCreatedBy());
			existingVehicle.setModifiedBy(vehicleDto.getModifiedBy());

			VehicleDto vehicleDtoObj = vehicleMapper.mapVehicleToVehicleDto(vehicleRepository.save(existingVehicle));
			return new ApiResponse<VehicleDto>(vehicleDtoObj, null, null, null, "Vehicle Updated successfully",
					HttpStatus.OK, false);
		} catch (ResourceNotFoundException re) {
			return new ApiResponse<VehicleDto>(null, null, null, null, re.getMessage(), HttpStatus.NOT_FOUND, true);
		} catch (Exception e) {
			return new ApiResponse<VehicleDto>(null, null, null, null, "Internal Server Error", HttpStatus.NOT_FOUND,
					true);
		}
	}

	@Override
	public ApiResponse<VehicleDto> deleteVehicle(int id) {
		try {
			vehicleRepository.deleteById(id);
			return new ApiResponse<VehicleDto>(null, null, null, null, "Vehicle Deleted successfully", HttpStatus.OK,
					false);
		} catch (Exception e) {
			return new ApiResponse<VehicleDto>(null, null, null, null, "Internal Server Error", HttpStatus.NOT_FOUND,
					true);
		}
	}

	@Override
	public ApiResponse<VehicleDto> getVehicleByRestTemplate(int Id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			Vehicle templateData = restTemplate
					.exchange("http://localhost:8082/api/v1/vehicle/" + Id, HttpMethod.GET, entity, Vehicle.class)
					.getBody();
			VehicleDto vehicleDtoObj = vehicleMapper.mapVehicleToVehicleDto(templateData);
			return new ApiResponse<VehicleDto>(vehicleDtoObj, null, null, null, "Rest Template data fetch successfully",
					HttpStatus.OK, false);
		} catch (Exception e) {
			return new ApiResponse<VehicleDto>(null, null, null, null, "Internal Server Error", HttpStatus.NOT_FOUND,
					true);

		}
	}

	@Override
	public void exportDataToPDF() {
		try {
			response.setContentType("application/pdf");
			String headerkey = "Content-Disposition";
			String headervalue = "attachment; filename=Vehicle-list" + ".pdf";
			response.setHeader(headerkey, headervalue);

			// Get List Of Vehicles
			List<Vehicle> vehicleList = vehicleRepository.findAll();

			ExportPdf pdfGenerator = new ExportPdf();
			pdfGenerator.generatePdf(vehicleList, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public ApiResponse<UserDto> registerUser(UserDto userDto) {
		try {
			User userObj = userMapper.mapUserDtoToUser(userDto);

			Key secreatKey = EncryptionUtil.getKey();
			String encodedPassword = EncryptionUtil.encryptPassword(userObj.getPassword(), secreatKey);
			System.out.println("secreatKey   " + secreatKey);
			System.out.println("encodedPassword   " + encodedPassword);
			userObj.setPassword(encodedPassword);
			UserDto userData = userMapper.mapUserToUserDto(userRepository.save(userObj));
			return new ApiResponse<UserDto>(userData, null, null, null, "user register successfully", HttpStatus.OK,
					false);
		} catch (Exception e) {
			return new ApiResponse<UserDto>(null, null, null, null, "Internal Server Error", HttpStatus.NOT_FOUND,
					true);

		}
	}

	@Override
	public ApiResponse<UserDto> auntenticateUser(UserDto userDto) {
		try {
			User userObj = userMapper.mapUserDtoToUser(userDto);

			// check user is exist
			User existingUser = userRepository.findByEmail(userDto.getEmail())
					.orElseThrow(() -> new ResourceNotFoundException("User", "Email", userDto.getEmail()));

			Key secreatKey = EncryptionUtil.getKey();
			// decrypt user password
			String decodedPassword = EncryptionUtil.decryptPassword(existingUser.getPassword(), secreatKey);
			System.out.println("secreatKey   " + secreatKey);
			System.out.println("decodedPassword   " + decodedPassword);

			if (decodedPassword.equals(userDto.getPassword())) {
				return new ApiResponse<UserDto>(null, null, null, null, "user aunthenticated sucessfully",
						HttpStatus.OK, false);
			} else {
				return new ApiResponse<UserDto>(null, null, null, null, "unauthorised credentials", HttpStatus.OK,
						false);
			}
		} catch (ResourceNotFoundException re) {
			return new ApiResponse<UserDto>(null, null, null, null, re.getMessage(), HttpStatus.NOT_FOUND, true);
		} catch (Exception e) {
			System.out.println("Exception e" + e);
			return new ApiResponse<UserDto>(null, null, null, null, "Internal Server Error", HttpStatus.NOT_FOUND,
					true);

		}
	}
}
