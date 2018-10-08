package com.test.webflux.service;

import com.test.webflux.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yu 2018/9/30.
 */
@Service
public class UserService {

    private Map<String, User> userMap = new ConcurrentHashMap<>();


    public void setUser(String userId, User user) {
        userMap.put(userId, user);
    }

    public Mono<User> findUserById(String userId) {
        User user = userMap.getOrDefault(userId, new User("nick", 18));
        return Mono.just(user);
    }

    public Flux<User> findUserList() {
        List<User> userList = new ArrayList<>();
        Set<Map.Entry<String, User>> entries = userMap.entrySet();
        entries.stream().forEach(entry -> userList.add(entry.getValue()));
        return Flux.fromStream(userList.stream());
    }

}
