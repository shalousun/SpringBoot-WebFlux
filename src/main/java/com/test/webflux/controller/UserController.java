package com.test.webflux.controller;

import com.test.webflux.model.User;
import com.test.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 用户操作
 * @author yu 2018/9/30.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 根据uid获取用户
     * @param uid 用户id
     * @return
     */
    @GetMapping("/{uid}")
    public Mono<User> getUser(@PathVariable String  uid) {
        return userService.findUserById(uid);
    }

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("list")
    public Flux<User> getUserList(){
        return userService.findUserList();
    }

}
