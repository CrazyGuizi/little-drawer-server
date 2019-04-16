package com.lidegui.littledrawer.service.impl;

import com.lidegui.littledrawer.bean.User;
import com.lidegui.littledrawer.dao.UserDao;
import com.lidegui.littledrawer.dto.BaseResponse;
import com.lidegui.littledrawer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 22:24 2019/4/12
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao mUserDao;

    @Override
    public User findUserById(int id) {
        return mUserDao.findUserById(id);
    }

    @Override
    public User findUserByToken(String token) {
        return mUserDao.findUserByToken(token);
    }

    @Override
    public User register(User user) {
        // 用户不存在
        if (isUserExit(user.getUsername()) == null) {
            int insert = mUserDao.insert(user);
            if (insert > 0) {
                // 不直接返回该用户是避免这个用户本身就少数据
                return mUserDao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
            }
        }

        return null;
    }

    @Override
    public User login(String u, String p) {
        return mUserDao.findUserByUsernameAndPassword(u, p);
    }

    @Override
    public User isUserExit(String username) {
        return mUserDao.findUserByUsername(username);
    }

    @Override
    public User updateUser(User user) {
        int count = mUserDao.updateById(user);
        if (count > 0) {
            return mUserDao.findUserById(user.getId());
        }

        return null;
    }

    @Override
    public int deleteUser(int id) {
        return mUserDao.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return mUserDao.findAll();
    }
}
