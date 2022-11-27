package com.sa.forgot_password.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findAllByName(String userName);
}
