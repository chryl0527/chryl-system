package com.chryl.service.model;

import com.chryl.po.SbInfo;

import java.io.Serializable;

/**
 * Created By Chr on 2019/5/28.
 */
public class SbProtModel extends SbInfo implements Serializable {

    private static final long serialVersionUID = 3748605785125424683L;
    private Integer protocolId;//protocolId
    private String protocolType;//protocolType

    public Integer getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Integer protocolId) {
        this.protocolId = protocolId;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }
}
