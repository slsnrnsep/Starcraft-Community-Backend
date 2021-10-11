package com.mini.miniproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Post {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String userNick;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false) // 테란 : 0 저그 : 1 프로토스 2
    private Long categori;

    @OneToMany
    private List<Comment> commentList;

    //file관련 컬럼하나

    public Post(PostDto reqDto) // 제목,내용,카테고리작성자는 따로 userdetails에서
    {

    }
}
