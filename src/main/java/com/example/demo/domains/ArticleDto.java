package com.example.demo.domains;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Lazy;
import lombok.Data;


@Component @Data  @Lazy
public class ArticleDto {
    private String artNum, writerId, title, content, regDate, count ;
    

}
