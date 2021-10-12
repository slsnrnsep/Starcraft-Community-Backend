package com.mini.miniproject.model;

import com.mini.miniproject.dto.PostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Post extends Timestamped {
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

    @OneToMany(mappedBy = "post")
    private final List<Heart> hearts = new ArrayList<>();

    @Column(columnDefinition = "integer default 0")
    private int heartCount;
    //file관련 컬럼하나

    //제목,내용,카테고리작성자는 따로 userdetails에서


    public Post(PostDto reqdto, String username, String content) {
        this.userNick = username;
        this.title = reqdto.getTitle();
        this.content = content;
        this.categori = reqdto.getCategori();
    }

    public Post(PostDto reqdto,String userNick) {
        this.userNick = userNick;
        this.title = reqdto.getTitle();
        this.content = reqdto.getContent();
        this.categori = reqdto.getCategori();
    }

    public Post(String title,String userNick,String content) {
        this.userNick = userNick;
        this.title = title;
        this.content = content;
    }
    public Post(PostDto reqdto) {
        this.userNick = reqdto.getUserNick();
        this.title = reqdto.getTitle();
        this.content = reqdto.getContent();
        this.categori = reqdto.getCategori();
    }
    public void update(PostDto reqDto) {
        this.title = reqDto.getTitle();
        this.userNick = reqDto.getUserNick();
        this.content = reqDto.getContent();
        this.categori = reqDto.getCategori();
    }
    public void addComment(Comment comment) {
        this.commentList.add(comment);
        return;
    }


    public void addHeart(Heart heart) {
        this.hearts.add(heart);
        this.heartCount += 1;
    }

    public void deleteHeart(Heart heart) {
        this.hearts.remove(heart);
        this.heartCount -= 1;
    }
}
