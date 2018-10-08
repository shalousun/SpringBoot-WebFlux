package com.test.webflux.component;

import com.test.webflux.model.User;
import com.test.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author yu 2018/9/30.
 */
@Component
public class DataInit implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {

        userService.setUser("1", new User("carlos", 18));
        userService.setUser("2", new User("lisa", 19));
        userService.setUser("3", new User("mike", 17));
        userService.setUser("4", new User("tom", 16));
        userService.setUser("5", new User("amy", 15));

    }
}
