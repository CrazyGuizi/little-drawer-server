package com.lidegui.littledrawer.bean;

import java.io.Serializable;

/**
 * @Author: lidegui
 * @Date:Created in 19:41 2019/4/12
 */
public class User implements Serializable {

    private Integer id;
    private String  nickName;
    private String  username;
    private String  password;
    private String  iconUrl;
    private String  token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
