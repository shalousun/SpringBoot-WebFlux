package com.test.webflux.model;

/**
 * @author yu 2018/9/30.
 */
public class User{


    /**
     * 用户名
     */
    private String username;

    /**
     * 年龄
     */
    private Integer age;


    public User(){}


    public User(String username,Integer age){
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
