package com.wmm.wheresmymoney.controller.user;

import com.wmm.wheresmymoney.dto.userDto.UserCreateDTO;
import com.wmm.wheresmymoney.dto.userDto.UserResponseDTO;
import com.wmm.wheresmymoney.mapper.user.UserMapper;
import com.wmm.wheresmymoney.model.User;
import com.wmm.wheresmymoney.response.ApiResponse;
import com.wmm.wheresmymoney.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDTO>> createUser(@RequestBody UserCreateDTO userDto){
            User saveUser = userService.createUser(userDto);
            UserResponseDTO userResponse = UserMapper.toResponseDTO(saveUser);

            ApiResponse<UserResponseDTO> response = new ApiResponse<>("Usuário criado com sucesso!", userResponse);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(response);
    }
}
