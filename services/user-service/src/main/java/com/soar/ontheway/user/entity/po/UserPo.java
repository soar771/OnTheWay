package com.soar.ontheway.user.entity.po;

import lombok.Data;

@Data
//@TableName("user")
public class UserPo {
    private int id;
    private String username;
    private String password;
    private int idType;
    private String idCardNumber;
    private int userType;
    private String phone;
    private String mail;
}
