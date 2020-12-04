package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.domains.UserDTO;
import com.example.demo.services.UserService;
import com.example.demo.utils.Printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
    @Autowired UserService userService;
    @Autowired Printer printer;
    @PostMapping("/users")
    public Map<?,?> join(@RequestBody UserDTO user){
        printer.accept("===서버시작===");
        var map = new HashMap<>();
        printer.accept("ID: " + user.getUserid());
        printer.accept("PW: " + user.getPassword());
        printer.accept("NAME: " + user.getName());
        int result = userService.join(user);
        if(result == 1){
            map.put("message", "SUCCESS");
        }
        return map;
    }

    @PostMapping("/users/login")
    public Map<?,?> login(@RequestBody UserDTO user){
        printer.accept("===login 들어옴===");
        var map = new HashMap<>();
        UserDTO result = userService.login(user);
        if(result != null){
            map.put("message", "SUCCESS");
            map.put("loginUser", result);
        }else{
            map.put("message", "FAILURE");
            map.put("loginUser", null);
        }
        return map;
    }
    @GetMapping("/users/{userid}")
    public Map<?,?> mypage(@PathVariable String userid) {

        printer.accept("마이페이지에서 넘어온 아이디:"+userid);
        var map = new HashMap<>();
        UserDTO user = userService.findById(userid);

        if(user != null){   
            map.put("message", "SUCCESS");
            map.put("loginUser", user);
    } else{
            map.put("message", "FAILURE");
            map.put("loginUser", null);
    }
        
        return map;
    }
    @PutMapping("/users")
    public Map<?,?> update(@RequestBody UserDTO user){
        printer.accept("수정페이지에서 넘어본 비번"+user.getPassword());
        var map = new HashMap<>();
        int result = userService.update(user);
        printer.accept("성공여부"+result);
        if(result == 1){
           
            map.put("message", "SUCCESS");

        }else{
   
            map.put("message", "FAILURE");
        }
        return map;
    }
    @DeleteMapping("/users")
    public Map<?,?> remove(@RequestBody UserDTO user){
        printer.accept("회원탈퇴로 넘어온 아이디"+user.getUserid());
        var map = new HashMap<>();
        int result = userService.remove(user);
        if(result == 1){
            map.put("messege", "SUCCESS");
        }else{
            map.put("message", "FAILURE");
        }

        return map;
    }
    
}
