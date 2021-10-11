package com.mini.miniproject.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDto {
    private String content;
    private String userNick;
    private Long postId;
}
