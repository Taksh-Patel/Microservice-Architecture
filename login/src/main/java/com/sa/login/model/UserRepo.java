package com.sa.login.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findAllByName(String userName);
}
