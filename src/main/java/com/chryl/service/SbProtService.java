package com.chryl.service;

import com.chryl.response.error.ResponseException;
import com.chryl.service.model.SbProtModel;

import java.util.List;

/**
 * Created By Chr on 2019/5/28.
 */
public interface SbProtService {
    /**
     * 新增设备
     *
     * @param sbProtocolModel
     * @throws ResponseException
     */
    void insetSb(SbProtModel sbProtocolModel) throws ResponseException;

    /**
     * 查询所有设备
     *
     * @param startIndex
     * @param skip
     * @return
     */
    List<SbProtModel> queryAll(Integer startIndex, Integer skip);

    /**
     * 删除设备
     *
     * @param sbId
     * @throws ResponseException
     */
    void deleteOneSb(String sbId) throws ResponseException;

    /**
     * 更新设备
     *
     * @param sbId
     * @param sbName
     * @param sbType
     * @param sbDescription
     * @param sbProtocolId
     * @throws ResponseException
     */
    void updateOneSb(String sbId, String sbName, String sbType, String sbDescription, Integer sbProtocolId) throws ResponseException;

    /**
     * 批量增加设备
     *
     * @return
     */
    int insertSbs();

    /**
     * 批量删除
     *
     * @param strSbIdArray
     */
    void deleteSbs(String[] strSbIdArray) throws ResponseException;
}
