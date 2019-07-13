package com.chryl.service.model.sso;

/**
 * sso配置类
 * <p>
 * Created By Chr on 2019/7/13.
 */
public class SsoConf {

    //redis sso 过期时间
    public static final int REDIS_EXPIRE_MINUTE = 1440 * 5;//1440 minite, 24 hour:5天
    //cookie sso 过期时间
    public static final int COOKIE_EXPIRE_SECOND = 60 * 60 * 24 * 5;//1440 minite, 24 hour:5天
    //sso redisKey前缀:sso_redis#userId
    public static final String SSO_REDIS_KEY_PREFIX = "sso_redis";
    //sso cookieName:sso_cookie#userId
    public static final String SSO_COOKIE_NAME = "sso_cookie";
}
