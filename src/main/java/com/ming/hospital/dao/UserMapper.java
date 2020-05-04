package com.ming.hospital.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ming.hospital.pojo.Appointment;
import com.ming.hospital.pojo.User;
import com.ming.hospital.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface UserMapper extends BaseMapper<User> {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long uid);

    int iinsert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}