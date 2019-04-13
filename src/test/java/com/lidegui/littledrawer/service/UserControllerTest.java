package com.lidegui.littledrawer.service;

import com.alibaba.fastjson.JSON;
import com.lidegui.littledrawer.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author: lidegui
 * @Date:Created in 13:22 2019/4/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {


    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private UserService mUserService;

    private MockMvc mvc;
    private MockHttpSession session;

    @Before
    public void setupMockMvc() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
        session = new MockHttpSession();
    }

    @Test
    public void addUser() throws Exception {
        String json = "{\"id\":7,\"nickName\":\"土小贵\",\"username\":\"15327436296\",\"password\":\"1012610779\",\"token\":\"little-drawer-lidegui\",\"iconUrl\":\"http://pic.52112.com/180205/18020526/a9yPQozt0g.jpg\"}";
        User user = new User();
        user.setUsername("ldg123");
        mvc.perform(MockMvcRequestBuilders.get("/api/user/validateUsername")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
                .content(JSON.toJSONString(user)))
                .andDo(MockMvcResultHandlers.print());
    }
}
