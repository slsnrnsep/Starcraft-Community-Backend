package com.mini.miniproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    private String title;
    private String content;
    private String userNick;
    private String filePath;
    private Long categori;
    //파일관련된거
}
