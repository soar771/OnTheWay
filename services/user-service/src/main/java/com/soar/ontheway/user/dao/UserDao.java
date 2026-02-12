package com.soar.ontheway.user.dao;

import com.soar.ontheway.user.entity.po.UserPo;
import com.soar.ontheway.user.entity.vo.UserRegisterRequestVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public UserPo queryUserByUsername(String username);

    int insertUser(@Param("user") UserRegisterRequestVo req);
}
