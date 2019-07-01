package com.chryl.service;

import com.chryl.response.error.ResponseException;
import com.chryl.service.model.SbProtModel;

import java.util.List;

/**
 * Created By Chr on 2019/5/28.
 */
public interface SbProtService {
    void insetSb(SbProtModel sbProtocolModel) throws ResponseException;

    List<SbProtModel> queryAll(Integer startIndex, Integer skip);

    void deleteOneSb(String sbId) throws ResponseException;

    void updateOneSb(String sbId,String sbName, String sbType, String sbDescription, Integer sbProtocolId) throws ResponseException;

    int insertSbs();
}
