package com.wmm.wheresmymoney.service;

import com.wmm.wheresmymoney.dto.userDto.UserCreateDTO;
import com.wmm.wheresmymoney.model.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {

    User createUser(UserCreateDTO userCreateDTO);
}
