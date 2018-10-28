package com.test.webflux.service;

import com.test.webflux.model.UserInfo;
import com.test.webflux.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author yu 2018/10/28.
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public Mono<UserInfo> save(UserInfo userInfo){
        return userInfoRepository.save(userInfo);
    }

    public Mono<Void> delete(Long id){
        return userInfoRepository.deleteById(id);
    }

    public Mono<UserInfo> getUser(Long id){
        return userInfoRepository.findById(id);
    }

    public Flux<UserInfo> listUser(){
        return userInfoRepository.findAll();
    }
}
