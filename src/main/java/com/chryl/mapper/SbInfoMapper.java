package com.chryl.mapper;

import com.chryl.po.SbInfo;
import com.chryl.po.SbInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SbInfoMapper {
    long countByExample(SbInfoExample example);

    int deleteByExample(SbInfoExample example);

    int deleteByPrimaryKey(String sbId);

    int insert(SbInfo record);

    int insertSelective(SbInfo record);

    List<SbInfo> selectByExample(SbInfoExample example);

    SbInfo selectByPrimaryKey(String sbId);

    int updateByExampleSelective(@Param("record") SbInfo record, @Param("example") SbInfoExample example);

    int updateByExample(@Param("record") SbInfo record, @Param("example") SbInfoExample example);

    int updateByPrimaryKeySelective(SbInfo record);

    int updateByPrimaryKey(SbInfo record);


    //#############
    List<SbInfo> queryAll(@Param("startIndex") Integer startIndex, @Param("skip") Integer skip);
}