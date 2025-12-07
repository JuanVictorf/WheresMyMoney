package com.wmm.wheresmymoney.repository.user;

import com.wmm.wheresmymoney.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
}
