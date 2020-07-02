package com.test.webflux.controller;

import com.power.common.model.CommonResult;
import com.test.webflux.model.UserInfo;
import com.test.webflux.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 用户详情操作
 * @author yu 2018/10/28.
 */
@RestController
@RequestMapping("userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 保存用户信息详情
     * @param userInfo
     * @return
     */
    @PostMapping("save")
    public Mono<UserInfo> save(@RequestBody UserInfo userInfo){
       return userInfoService.save(userInfo);
    }

    /**
     * 插入用户信息详情
     * @param userInfo
     * @return
     */
    @PostMapping("insert")
    public Mono<CommonResult> insert(@RequestBody UserInfo userInfo){
        return userInfoService.insert(userInfo);
    }

    /**
     * 根据id删除
     * @param id 用户id
     * @return
     */
    @GetMapping("delete/{id}")
    public Mono<Void> delete(@PathVariable Long id){
        return userInfoService.delete(id);
    }

    /**
     * 先查找在删除
     * @param id 用户详情id
     * @return
     */
    @GetMapping("deleteById/{id}")
    public Mono<CommonResult> deleteById(@PathVariable Long id){
        return userInfoService.deleteById(id);
    }

    /**
     * 查询
     * @param id 用户详情id
     * @return
     */
    @GetMapping("get/{id}")
    public Mono<UserInfo> getUser(@PathVariable Long id){
        return userInfoService.getUser(id);
    }

    /**
     * 根据id查询
     * @param id id
     * @return
     */
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
