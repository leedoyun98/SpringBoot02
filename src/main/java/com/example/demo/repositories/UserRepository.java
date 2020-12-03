package com.example.demo.repositories;

import com.example.demo.domains.UserDto;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    public int insert(UserDto user);
   
}
