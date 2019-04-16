package com.lidegui.littledrawer.dao;

import com.lidegui.littledrawer.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 19:49 2019/4/12
 */
public interface UserDao {

    /**
     * 插入用户记录
     * @param user 用户数据
     * @return 插入用户记录的条数
     */
    int insert(User user);

    /**
     * 删除用户记录
     * @param id 用户的id
     * @return 删除用户记录的条数
     */
    int deleteById(Integer id);

    /**
     * 更新用户记录
     * @param user 用户数据
     * @return 更新用户记录的条数
     */
    int updateById(User user);

    /**
     * 查询用户记录
     * @param id 用户id
     * @return 用户记录或null
     */
    User findUserById(Integer id);

    User findUserByToken(String token);

    /**
     * 查询用户信息（不包括敏感信息）
     * @param id
     * @return
     */
    User findUserInfoById(Integer id);

    /**
     * 查询用户记录
     * @param username 用户名
     * @return
     */
    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    List<User> findAll();
}
