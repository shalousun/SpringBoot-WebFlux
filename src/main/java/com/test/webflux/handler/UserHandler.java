package com.test.webflux.handler;

import com.test.webflux.model.User;
import com.test.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author yu 2018/9/30.
 */

@Component
public class UserHandler {

    @Autowired
    UserService userService;

    public Mono<ServerResponse> getUser(ServerRequest request) {
        String userId = request.pathVariable("uid");
        Mono<User> userMono = userService.findUserById(userId);
        return ServerResponse.ok().body(userMono,User.class);
    }

    public Mono<ServerResponse> getUserList(ServerRequest request) { //Lambda 匿名参数
        Flux<User> userFlux = userService.findUserList();
        //userFlux.subscribe(user -> log.info(user.toString()));
        return ServerResponse.ok().body(userFlux, User.class);
    }


}
