package com.soar.ontheway.user.entity.vo;

import lombok.Data;

@Data
public class UserRegisterRequestVo {
    private String username;
    private String password;
    private int idType;
    private String idCardNumber;
    private int userType;
    private String phone;
    private String mail;
}
