package com.test.webflux.service;

import com.power.common.model.CommonResult;
import com.test.webflux.enums.ErrorCodeEnum;
import com.test.webflux.model.UserInfo;
import com.test.webflux.repository.UserInfoRepository;
import com.test.webflux.util.ResultUtil;
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

    public Mono<UserInfo> save(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    public Mono<CommonResult> insert(UserInfo userInfo){
        return userInfoRepository.save(userInfo)
                .map(result -> ResultUtil.success(""))
                .defaultIfEmpty(ResultUtil.error(ErrorCodeEnum.UNKNOWN_ERROR));
    }

    /**
     * 更新
     * @param userInfo
     * @return
     */
    public Mono<CommonResult> update(UserInfo userInfo){
        return userInfoRepository.findById(userInfo.getId())
                .flatMap(existingUser ->{
                            existingUser.setUsername(userInfo.getUsername());
                            return userInfoRepository.save(existingUser);
                        })
                .map(updateUser -> ResultUtil.success(""))
                .defaultIfEmpty(ResultUtil.error(ErrorCodeEnum.NOT_FIND_RESULT));
    }

    public Mono<Void> delete(Long id) {
        return userInfoRepository.deleteById(id);
    }

    public Mono<CommonResult> deleteById(Long id) {
        return userInfoRepository.findById(id)
                .flatMap(existingUser ->
                        userInfoRepository.delete(existingUser)
                                .then(Mono.just(ResultUtil.success(""))))
                .defaultIfEmpty(ResultUtil.error(ErrorCodeEnum.NOT_FIND_RESULT));
    }

    public Mono<UserInfo> getUser(Long id) {
        return userInfoRepository.findById(id);
    }


    public Mono<CommonResult> getUserById(Long id) {
        return userInfoRepository.findById(id).map(result -> ResultUtil.success(result))
                .defaultIfEmpty(ResultUtil.error(ErrorCodeEnum.NOT_FIND_RESULT));
    }

    public Flux<UserInfo> listUser() {
        return userInfoRepository.findAll();
    }

    /**
     * 公共api结果返回
     *
     * @return
     */
    public Flux<CommonResult<UserInfo>> listAllUser() {
        return userInfoRepository.findAll().map(userInfo -> ResultUtil.success(userInfo));
    }
}
