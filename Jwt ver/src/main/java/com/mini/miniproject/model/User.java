package com.mini.miniproject.model;

import com.mini.miniproject.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class User {
    @Id
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique = true)
    private String userNick;

    @OneToMany(mappedBy = "user")
    private final List<Heart> hearts = new ArrayList<>();

    public void addHeart(Heart heart) {
        this.hearts.add(heart);
    }

    public void deleteHeart(Heart heart) {
        this.hearts.remove(heart);
    }

    public User(UserDto reqDto)
    {
        this.id = reqDto.getId();
        this.password = reqDto.getPassword();
        this.userNick = reqDto.getUserNick();
    }
}
