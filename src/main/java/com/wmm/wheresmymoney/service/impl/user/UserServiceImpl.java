package com.wmm.wheresmymoney.service.impl.user;

import com.wmm.wheresmymoney.dto.userDto.UserCreateDTO;
import com.wmm.wheresmymoney.mapper.user.UserMapper;
import com.wmm.wheresmymoney.model.User;
import com.wmm.wheresmymoney.repository.user.UserRepository;
import com.wmm.wheresmymoney.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(
            UserRepository userRepository
    ){
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserCreateDTO userCreateDTO){
        if(userRepository.existsByEmail(userCreateDTO.getEmail())){
            log.info("Email já utilizado em outro cadastro: {} ", userCreateDTO.getEmail());
            throw new RuntimeException("Email already exists");
        }



        User user = UserMapper.toEntity(userCreateDTO);
        return userRepository.save(user);
    }
}
