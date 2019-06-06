package com.chryl.service.impl;

import com.chryl.mapper.ProtocolInfoMapper;
import com.chryl.mapper.SbInfoMapper;
import com.chryl.mapper.UserInfoMapper;
import com.chryl.mapper.UserPasswordMapper;
import com.chryl.service.CurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created By Chr on 2019/5/29.
 */
@Service
public class CurrentServiceImpl implements CurrentService {

    @Autowired
    private SbInfoMapper sbInfoMapper;
    @Autowired
    private ProtocolInfoMapper protocolInfoMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserPasswordMapper userPasswordMapper;

    //线程池
    ExecutorService executorService = Executors.newFixedThreadPool(2);



}
