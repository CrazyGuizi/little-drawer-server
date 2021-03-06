package com.lidegui.littledrawer.web;

import com.alibaba.fastjson.JSON;
import com.lidegui.littledrawer.bean.User;
import com.lidegui.littledrawer.dto.BaseResponse;
import com.lidegui.littledrawer.service.UserService;
import com.lidegui.littledrawer.util.Constant;
import com.lidegui.littledrawer.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: lidegui
 * @Date:Created in 22:46 2019/4/12
 */

@RestController
@RequestMapping(Constant.API_USER)
public class UserController {

    @Autowired
    private UserService mUserService;

    /**
     * 验证用户是否存在
     * @param reqMap
     * @return
     */
    @RequestMapping(value = Constant.API_USER_VALIDATE_USERNAME, method = RequestMethod.POST)
    public BaseResponse validateUsername(@RequestBody Map<String,Object> reqMap) {
        String username = reqMap.get("username").toString();
        if (!Util.isEmpty(username)) {
            User user = mUserService.isUserExit(username);
            if (user != null) {
                // 返回想要结果就可以了，不暴露数据
                return BaseResponse.generateSuccess("用户存在", null);
            }
        }

        return BaseResponse.generateFail("用户不存在");
    }

    @RequestMapping(value = Constant.API_USER_LOGIN, method = RequestMethod.POST)
    public BaseResponse login(@RequestBody User u) {
        User user = mUserService.login(u.getUsername(), u.getPassword());
        if (user != null) {
            // 更新token
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user = mUserService.updateUser(user);
            if (user != null) {
                return BaseResponse.generateSuccess("登录成功", user);
            }
        }

        return BaseResponse.generateFail("账号密码出错");
    }


    @RequestMapping(value = Constant.API_USER_REGISTER, method = RequestMethod.POST)
    public BaseResponse register(@RequestBody User user) {
        user.setIconUrl(Util.getIconRandom());
        String token = UUID.randomUUID().toString();
        user.setToken(token);
        User register = mUserService.register(user);
        if (register != null) {
            return BaseResponse.generateSuccess("注册成功", register);
        }

        return BaseResponse.generateSuccess("注册失败", user);
    }

    @RequestMapping(value = Constant.API_USER_UPDATE_USER, method = RequestMethod.POST)
    public BaseResponse updateUser(@RequestBody User u) {
        User user = mUserService.updateUser(u);
        if (user != null) {
            return BaseResponse.generateSuccess("更新成功", user);
        }

        return BaseResponse.generateFail("更新失败");
    }

    @RequestMapping(value = Constant.API_USER_GET_ALL_USERS, method = RequestMethod.GET)
    public BaseResponse getAllUser() {
        List<User> allUsers = mUserService.getAllUsers();
        if (allUsers != null) {
            return BaseResponse.generateSuccess(allUsers);
        }
        return BaseResponse.generateFail("获取失败");
    }

    @RequestMapping(value = Constant.API_USER_DELETE_USER, method = RequestMethod.POST)
    public BaseResponse deleteUser(@RequestBody Map<String, Object> map) {
        if (!Util.isEmpty(map.get("id").toString())) {
            int id = Integer.parseInt(map.get("id").toString());
            int result = mUserService.deleteUser(id);
            if (result > 0) {
                return BaseResponse.generateSuccess("删除成功", null);
            }
        }

        return BaseResponse.DEFAULT_FAIL;
    }

}
