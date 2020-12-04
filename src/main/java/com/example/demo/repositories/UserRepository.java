package com.example.demo.repositories;

import com.example.demo.domains.UserDTO;

import org.springframework.stereotype.Repository;
//스프링 AOP 이게 로그데이터(백엔드 핵심)를 찍게하는거거든
@Repository
public interface UserRepository {
    public int insert(UserDTO user);
    public UserDTO login(UserDTO user);
	public UserDTO selectById(String userid);
	public int update(UserDTO user);
	public int delete(UserDTO user);

}
