package com.wmm.wheresmymoney.dto.userDto;

import com.wmm.wheresmymoney.model.User;
import lombok.Data;

@Data
public class UserCreateDTO {

    private String nome;
    private String email;

    public User toEntity(){
        User user = new User();
        user.setNome(this.nome);
        user.setEmail(this.email);
        return user;
    }

}
