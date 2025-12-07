package com.wmm.wheresmymoney.mapper.user;

import com.wmm.wheresmymoney.dto.userDto.UserCreateDTO;
import com.wmm.wheresmymoney.dto.userDto.UserResponseDTO;
import com.wmm.wheresmymoney.model.User;

public class UserMapper {

    public static User toEntity(UserCreateDTO userDto){
        User user = new User();
        user.setNome(userDto.getNome());
        user.setEmail(userDto.getEmail());
        return user;
    }

    public static UserResponseDTO toResponseDTO(User user){
        return new UserResponseDTO(
                user
        );
    }
}
