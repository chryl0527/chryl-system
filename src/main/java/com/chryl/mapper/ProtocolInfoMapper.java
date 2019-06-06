package com.chryl.mapper;

import com.chryl.po.ProtocolInfo;
import com.chryl.po.ProtocolInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProtocolInfoMapper {
    long countByExample(ProtocolInfoExample example);

    int deleteByExample(ProtocolInfoExample example);

    int deleteByPrimaryKey(Integer protocolId);

    int insert(ProtocolInfo record);

    int insertSelective(ProtocolInfo record);

    List<ProtocolInfo> selectByExample(ProtocolInfoExample example);

    ProtocolInfo selectByPrimaryKey(Integer protocolId);

    int updateByExampleSelective(@Param("record") ProtocolInfo record, @Param("example") ProtocolInfoExample example);

    int updateByExample(@Param("record") ProtocolInfo record, @Param("example") ProtocolInfoExample example);

    int updateByPrimaryKeySelective(ProtocolInfo record);

    int updateByPrimaryKey(ProtocolInfo record);
}