package com.example.demo.impls;

import com.example.demo.domains.UserDTO;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired UserRepository userRepository;
    @Autowired UserDTO user;
    @Override
    public int join(UserDTO user) {
        return userRepository.insert(user);
    }

    @Override
    public UserDTO login(UserDTO user) {
        return userRepository.login(user);
    }


    @Override
    public UserDTO findById(String userid) {
        // TODO Auto-generated method stub
        return userRepository.selectById(userid);
    }

    @Override
    public int update(UserDTO user) {
        // TODO Auto-generated method stub
        return userRepository.update(user);
    }

    @Override
    public int remove(UserDTO user) {
        // TODO Auto-generated method stub
        return userRepository.delete(user);
    }
    
}