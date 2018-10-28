package com.test.webflux.repository;

import com.test.webflux.model.UserInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author yu 2018/10/28.
 */
public interface UserInfoRepository extends ReactiveMongoRepository<UserInfo,Long> {
}
