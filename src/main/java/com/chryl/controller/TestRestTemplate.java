package com.chryl.controller;

import com.chryl.mapper.UserInfoMapper;
import com.chryl.po.UserInfo;
import com.chryl.response.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created By Chr on 2019/7/27.
 */
@RestController
@RequestMapping("/rest")
public class TestRestTemplate {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @PostMapping("/testm")
    public ReturnResult show11(@RequestParam("id") String id,
                               @RequestParam("name") String name) {
        System.out.println(id);
        UserInfo userInfo = userInfoMapper.selectByUserName(name);

        return ReturnResult.create(userInfo);
    }

    @GetMapping("/testp")
    public ReturnResult show22(@RequestParam String name,
                               @RequestParam Integer age,
                               @RequestParam String clazz) {
        System.out.println(name + "-" + age + "-" + clazz);
        UserInfo userInfo = userInfoMapper.selectByUserName(name);
        return ReturnResult.create(userInfo);
    }
}
