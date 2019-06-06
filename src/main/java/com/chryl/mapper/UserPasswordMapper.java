package com.chryl.mapper;

import com.chryl.po.UserPassword;
import com.chryl.po.UserPasswordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPasswordMapper {
    long countByExample(UserPasswordExample example);

    int deleteByExample(UserPasswordExample example);

    int deleteByPrimaryKey(String userId);

    int insert(UserPassword record);

    int insertSelective(UserPassword record);

    List<UserPassword> selectByExample(UserPasswordExample example);

    UserPassword selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") UserPassword record, @Param("example") UserPasswordExample example);

    int updateByExample(@Param("record") UserPassword record, @Param("example") UserPasswordExample example);

    int updateByPrimaryKeySelective(UserPassword record);

    int updateByPrimaryKey(UserPassword record);
}