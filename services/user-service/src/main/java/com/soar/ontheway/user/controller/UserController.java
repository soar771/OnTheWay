package com.soar.ontheway.user.controller;

import com.soar.ontheway.user.entity.vo.UserRegisterRequestVo;
import com.soar.ontheway.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.soar.ontheway.common.response.ResponseVo;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/login")
    @ResponseBody
    public ResponseVo login(String username, String password) {
        ResponseVo responseVo = new ResponseVo();
        try{
            String jwt = userService.login(username, password);
            responseVo.setSuccess(true);
            responseVo.setCode(200);
            if(jwt.isEmpty()) {
                responseVo.setMessage("用户名或密码错误");
                return responseVo;
            }
            responseVo.setData(jwt);
            return responseVo;
        } catch (Exception e) {
            responseVo.setSuccess(false);
            responseVo.setCode(500);
            responseVo.setMessage("");
            return responseVo;
        }
    }

    @RequestMapping("/logout")
    public void logout(String token) {
        userService.logout(token);
    }

    @RequestMapping("/register")
    @ResponseBody
    public ResponseVo register(UserRegisterRequestVo req) {
        ResponseVo responseVo = new ResponseVo();
        try {
            String msg = userService.register(req);
            responseVo.setSuccess(true);
            responseVo.setCode(200);
            responseVo.setMessage(msg);
            return responseVo;
        } catch (Exception e) {
            log.error("user register error : {}", e.getMessage());
            responseVo.setSuccess(false);
            responseVo.setCode(500);
            responseVo.setMessage(e.getMessage());
            return responseVo;
        }
    }
}
