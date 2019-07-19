package com.chryl.service.impl;

import com.chryl.service.SsoService;
import com.chryl.service.model.UserModel;
import com.chryl.service.model.sso.SsoConf;
import com.chryl.service.model.sso.SsoUser;
import com.chryl.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * sso
 * <p>
 * Created By Chr on 2019/7/13.
 */
@Service
public class SsoServiceImpl implements SsoService {

    //    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void doSso(HttpServletRequest request, HttpServletResponse response, UserModel userModel) {
        //存入redis
        SsoUser ssoUser = new SsoUser();
        ssoUser.setUserId(userModel.getUserId());
        ssoUser.setUserName(userModel.getUserName());
        ssoUser.setExpireMinute(SsoConf.REDIS_EXPIRE_MINUTE);
        ssoUser.setExpireFreshTime(System.currentTimeMillis());
        //key:sso#userId,value:ssoUser,timeOut:5天
        redisTemplate.opsForValue().set(
                redisKey(ssoUser.getUserId()), ssoUser, SsoConf.REDIS_EXPIRE_MINUTE, TimeUnit.MINUTES
        );
        //存入cookie
        //cookieName:sso_cookie,cookieValue:sso_cookie#userId,timeOut:5天
        String cookieValue = cookieValue(ssoUser.getUserId());
        /**
         * cookieValue需要进行加密,不能直接使用userId进行存储和查询
         */
        CookieUtil.setCookie(request, response,
                SsoConf.SSO_COOKIE_NAME,//cookieName
                cookieValue,//cookieValue
                SsoConf.COOKIE_EXPIRE_SECOND);
    }

    @Override
    public SsoUser loginCheck(HttpServletRequest request, HttpServletResponse response, String cookieValue) {
        //cookieValue:sso_cookie#userId
        //userId
        String ssoUserId = splitInfix(cookieValue);
        //sso_redis#userId
        String redisKey = redisKey(ssoUserId);
        SsoUser ssoUser = (SsoUser) redisTemplate.opsForValue().get(redisKey);

        if (ssoUser != null) {
            //剩余过期时间
            Long expire = redisTemplate.getExpire(redisKey);//秒
            long minuteExpire = expire / 60;//分
            //过期时间过半刷新
            if (ssoUser.getExpireMinute() / 2 > minuteExpire) {
                //更新redis缓存
                redisTemplate.opsForValue().set(
                        redisKey(ssoUser.getUserId()), ssoUser, SsoConf.REDIS_EXPIRE_MINUTE, TimeUnit.MINUTES
                );
                //更新cookie
                cookieValue = cookieValue(ssoUser.getUserId());
                CookieUtil.setCookie(request, response,
                        SsoConf.SSO_COOKIE_NAME,//cookieName
                        cookieValue,//cookieValue
                        SsoConf.COOKIE_EXPIRE_SECOND);
            }
            return ssoUser;
        }
        return null;
    }


    /**
     * @param userId userId
     * @return redisKey
     */
    private static String redisKey(String userId) {
        return SsoConf.SSO_REDIS_KEY_PREFIX.concat("#").concat(userId);
    }

    /**
     * @param userId userId
     * @return cookieValue
     */
    private static String cookieValue(String userId) {
        return SsoConf.SSO_COOKIE_NAME.concat("#").concat(userId);
    }

    /**
     * @param cookieValue
     * @return userId
     */
    private static String splitInfix(String cookieValue) {
        return cookieValue.split("#")[1];

    }

    public static void main(String args[]) {
        String s = "abc";
        String s1 = redisKey(s);
        System.out.println(s1);

        System.out.println("+++++++++++++");
        String s2 = splitInfix("sso_cookie#as98b3d8ub23d");
        System.out.println(s2);
    }
}
