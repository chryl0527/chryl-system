package com.chryl.service.impl;

import com.chryl.mapper.ProtocolInfoMapper;
import com.chryl.mapper.SbInfoMapper;
import com.chryl.po.*;
import com.chryl.response.error.EnumError;
import com.chryl.response.error.ResponseException;
import com.chryl.service.SbProtService;
import com.chryl.service.model.SbProtModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By Chr on 2019/5/28.
 */
@Service
public class SbProtServiceImpl implements SbProtService {

    @Autowired
    private SbInfoMapper sbInfoMapper;
    @Autowired
    private ProtocolInfoMapper protocolInfoMapper;

    @Override
    public void insetSb(SbProtModel sbProtModel) throws ResponseException {
        if (sbProtModel == null) {
            throw new ResponseException(EnumError.PARAMETER_VALIDATION_ERROR);
        }
        if (StringUtils.isEmpty((sbProtModel.getSbName()))
                || sbProtModel.getSbType() == null //
                || sbProtModel.getSbProtocolId() == null //sb:应该检验设备的协议类
                || sbProtModel.getUserId() == null) {
            throw new ResponseException(EnumError.PARAMETER_VALIDATION_ERROR);
        }

        SbInfoExample example = new SbInfoExample();
        SbInfoExample.Criteria criteria = example.createCriteria();
        criteria.andSbIdEqualTo(sbProtModel.getSbId());
        List<SbInfo> users = sbInfoMapper.selectByExample(example);

        if (users.size() != 0) {
//            return ReturnResult.create("设备id已存在");
            throw new ResponseException(EnumError.SB__EXISTS);

        }

        SbInfo sbInfo = convertSbInfoFromModel(sbProtModel);
        sbInfoMapper.insertSelective(sbInfo);

//        ProtocolInfo protocolInfo = convertProtInfoFromModel(sbProtModel);
//        protocolInfoMapper.insertSelective(protocolInfo);
        return;
    }

    @Override
    public List<SbProtModel> queryAll(Integer startIndex, Integer skip) {

        List<SbInfo> sbInfos = sbInfoMapper.queryAll(startIndex, skip);
        List<SbProtModel> sbProtModels = sbInfos.stream().map(sbInfo -> {
            ProtocolInfo protocolInfo = protocolInfoMapper.selectByPrimaryKey(sbInfo.getSbProtocolId());
            return convertSbProtModelFromDataObj(sbInfo, protocolInfo);
        }).collect(Collectors.toList());

        return sbProtModels;

    }

    @Override
    public void deleteOneSb(String sbId) throws ResponseException {
        if (sbId == null) {
            throw new ResponseException(EnumError.PARAMETER_VALIDATION_ERROR);
        }
        int i = sbInfoMapper.deleteByPrimaryKey(sbId);
        if (i == 1) {
            return;
        }
        throw new ResponseException(EnumError.SB__DELETE_CANCLE);

    }

    @Override
    public void updateOneSb(String sbId, String sbName, String sbType, String sbDescription, Integer sbProtocolId) throws ResponseException {
        if (StringUtils.isEmpty(sbId) //
                || (StringUtils.isAllEmpty(sbName, sbType, sbDescription) && sbProtocolId == null)) {
            throw new ResponseException(EnumError.PARAMETER_VALIDATION_ERROR);
        }
        SbInfo sbInfo = new SbInfo();
        sbInfo.setSbId(sbId);
        sbInfo.setSbName(sbName);
        sbInfo.setSbType(sbType);
        sbInfo.setSbProtocolId(sbProtocolId);
        sbInfo.setSbDescription(sbDescription);
        int i = sbInfoMapper.updateByPrimaryKeySelective(sbInfo);
        if (i == 1) {
            return;
        }
        throw new ResponseException(EnumError.SB__UPDATE_CANCLE);
    }

    private SbProtModel convertSbProtModelFromDataObj(SbInfo sbInfo, ProtocolInfo protocolInfo) {

        if (sbInfo == null | protocolInfo == null) {
            return null;
        }
        SbProtModel protModel = new SbProtModel();
        BeanUtils.copyProperties(sbInfo, protModel);
        BeanUtils.copyProperties(protocolInfo, protModel);

        return protModel;
    }

    private SbInfo convertSbInfoFromModel(SbProtModel protModel) {

        if (protModel == null) {
            return null;
        }
        SbInfo sbInfo = new SbInfo();
        BeanUtils.copyProperties(protModel, sbInfo);

        return sbInfo;
    }

    private ProtocolInfo convertProtInfoFromModel(SbProtModel protModel) {
        if (protModel == null) {
            return null;
        }
        ProtocolInfo protocolInfo = new ProtocolInfo();
        BeanUtils.copyProperties(protModel, protocolInfo);

        return protocolInfo;
    }
}
