package com.chryl.controller.Vo;

/**
 * Created By Chr on 2019/5/29.
 */
public class SbProtVo {
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
     * 协议类型
     */
    private String protocolType;

    public String getSbId() {
        return sbId;
    }

    public void setSbId(String sbId) {
        this.sbId = sbId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName;
    }

    public String getSbType() {
        return sbType;
    }

    public void setSbType(String sbType) {
        this.sbType = sbType;
    }

    public String getSbDescription() {
        return sbDescription;
    }

    public void setSbDescription(String sbDescription) {
        this.sbDescription = sbDescription;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }


    public static void main(String args[]) {
        int ExpireMinite = 1440;//min
        long ExpireFreshTime = System.currentTimeMillis();//
        //redis =   1440*60

        System.out.println(ExpireFreshTime);//1559206494968
        long x = System.currentTimeMillis() - (ExpireMinite / 2);
        System.out.println(x);//1559206494248


        // After the expiration time has passed half, Auto refresh
        if ((System.currentTimeMillis() - 1559206494968L) > ExpireMinite * 60 * 1000 / 2) {
            //重新设置user过期刷新时间
//            xxlUser.setExpireFreshTime(System.currentTimeMillis());
            //重新写入redis(userName,userInfo)
//            SsoLoginStore.put(storeKey, xxlUser);

        }
        System.out.println(System.currentTimeMillis() - 1559206494968L);
        System.out.println(System.currentTimeMillis()-43200000);
    }
}
