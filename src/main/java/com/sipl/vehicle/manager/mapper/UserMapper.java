package com.sipl.vehicle.manager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sipl.vehicle.manager.dto.UserDto;
import com.sipl.vehicle.manager.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User mapUserDtoToUser(UserDto userDto);

	UserDto mapUserToUserDto(User user);

}
