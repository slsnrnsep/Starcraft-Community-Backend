package com.mini.miniproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
public class UserDto {
    private String id;
    private String password;
    private String passwordconfirm;
    private String userNick;
}
