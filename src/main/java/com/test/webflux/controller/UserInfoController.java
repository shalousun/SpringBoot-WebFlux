package com.test.webflux.controller;

import com.power.common.model.CommonResult;
import com.test.webflux.model.UserInfo;
import com.test.webflux.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author yu 2018/10/28.
 */
@RestController
@RequestMapping("userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 保存
     * @param userInfo
     * @return
     */
    @PostMapping("save")
    public Mono<UserInfo> save(@RequestBody UserInfo userInfo){
       return userInfoService.save(userInfo);
    }

    @PostMapping("insert")
    public Mono<CommonResult> insert(@RequestBody UserInfo userInfo){
        return userInfoService.insert(userInfo);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("delete/{id}")
    public Mono<Void> delete(@PathVariable Long id){
        return userInfoService.delete(id);
    }

    @GetMapping("deleteById/{id}")
    public Mono<CommonResult> deleteById(@PathVariable Long id){
        return userInfoService.deleteById(id);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping("get/{id}")
    public Mono<UserInfo> getUser(@PathVariable Long id){
        return userInfoService.getUser(id);
    }

    @GetMapping("getById/{id}")
    public Mono<CommonResult> getById(@PathVariable Long id){
        return userInfoService.getUserById(id);
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @GetMapping("list")
    public Flux<UserInfo> listUser(){
        return userInfoService.listUser();
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @GetMapping("listUser")
    public Flux<CommonResult<UserInfo>> listAllUser(){
        return userInfoService.listAllUser();
    }
}
