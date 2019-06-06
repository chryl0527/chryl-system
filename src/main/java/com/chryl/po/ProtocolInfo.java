package com.chryl.po;

import java.io.Serializable;

public class ProtocolInfo implements Serializable {
    /**
     * 协议唯一id
     */
    private Integer protocolId;
    /**
     * 协议类型
     */
    private String protocolType;

    private static final long serialVersionUID = 1L;

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
        this.protocolType = protocolType == null ? null : protocolType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", protocolId=").append(protocolId);
        sb.append(", protocolType=").append(protocolType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}