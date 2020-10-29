package com.study.uploadfiles.model.mapper;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.study.uploadfiles.model.dto.UserDTO;
import com.study.uploadfiles.model.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);

    default String instantToString(Instant instant){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss").withZone(ZoneId.systemDefault());

        return formatter.format(instant);

    }

    default List<UserDTO> toListDTO(List<User> users){

        if(users == null){
            return new ArrayList<UserDTO>();
        }
        
        return users.stream().map(this::toDTO).collect(Collectors.toList());
    }
    
}
