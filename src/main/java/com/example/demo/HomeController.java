package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        System.out.println("====서버가 시작됨====");
        return "index";
    }
    @GetMapping("/move/{dir}/{page}")
    public String move(@PathVariable String dir, @PathVariable String page){
        System.out.println("이동하려는 디렉토리: " + dir);
        System.out.println("이동하려는 파일명: " + page);
        return String.format("%s/%s", dir, page);
    }
}
