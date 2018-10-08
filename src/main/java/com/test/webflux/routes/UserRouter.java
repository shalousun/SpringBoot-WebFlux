package com.test.webflux.routes;

import com.test.webflux.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author yu 2018/9/30.
 */
public class UserRouter {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> routersFunction(UserHandler userHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/api/users"), userHandler::getUserList)
                .and(RouterFunctions.route(RequestPredicates.GET("/api/user/{userId}"), userHandler::getUser));
    }
}
