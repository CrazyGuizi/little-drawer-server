package com.lidegui.littledrawer.service;

import com.lidegui.littledrawer.bean.User;
import com.lidegui.littledrawer.dto.BaseResponse;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 22:21 2019/4/12
 *
 * 用户服务类
 */
public interface UserService {
    public User findUserById(int id);

    public User findUserByToken(String token);

    public User register(User user);

    public User login(String u, String p);

    public User isUserExit(String username);

    public User updateUser(User user);

    public int deleteUser(int id);

    public List<User> getAllUsers();
}
