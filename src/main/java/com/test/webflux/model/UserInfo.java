package com.test.webflux.model;

import org.springframework.data.annotation.Id;

/**
 * @author yu 2018/10/28.
 */
public class UserInfo {

    /**
     * 用户id
     */
    @Id
    private Long id;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 密码
     */
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
