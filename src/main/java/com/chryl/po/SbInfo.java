package com.chryl.po;

import java.io.Serializable;

public class SbInfo implements Serializable {
    /**
     * 设备唯一id
     */
    private String sbId;
    /**
     * 所属用户
     */
    private String userId;
    /**
     * 设备名字
     */
    private String sbName;
    /**
     * 设备类型
     */
    private String sbType;
    /**
     * 设备描述
     */
    private String sbDescription;

    /**
     * 设备协议id
     */
    private Integer sbProtocolId;

    private static final long serialVersionUID = 1L;

    public String getSbId() {
        return sbId;
    }

    public void setSbId(String sbId) {
        this.sbId = sbId == null ? null : sbId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName == null ? null : sbName.trim();
    }

    public String getSbType() {
        return sbType;
    }

    public void setSbType(String sbType) {
        this.sbType = sbType == null ? null : sbType.trim();
    }

    public String getSbDescription() {
        return sbDescription;
    }

    public void setSbDescription(String sbDescription) {
        this.sbDescription = sbDescription == null ? null : sbDescription.trim();
    }

    public Integer getSbProtocolId() {
        return sbProtocolId;
    }

    public void setSbProtocolId(Integer sbProtocolId) {
        this.sbProtocolId = sbProtocolId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sbId=").append(sbId);
        sb.append(", userId=").append(userId);
        sb.append(", sbName=").append(sbName);
        sb.append(", sbType=").append(sbType);
        sb.append(", sbDescription=").append(sbDescription);
        sb.append(", sbProtocolId=").append(sbProtocolId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}