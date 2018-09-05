package com.rxliuli.example.springboottest.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author rxliuli
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@Rollback
public class UserControllerUnitTest {
    @Autowired
    private UserController userController;
    /**
     * 用于测试 API 的模拟请求对象
     */
    private MockMvc mockMvc;

    @Before
    public void before() {
        //模拟一个 Mvc 测试环境，获取一个 MockMvc 实例
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .build();
    }

    @Test
    public void testGet() throws Exception {
        //测试能够正常获取
        Integer id = 1;
        mockMvc.perform(
                //发起 get 请求
                get("/user/" + id)
        )
                //断言请求的状态是成功的(200)
                .andExpect(status().isOk())
                //断言返回对象的 id 和请求的 id 相同
                .andExpect(jsonPath("$.id").value(id));
    }

    @Test
    public void listForAll() throws Exception {
        //测试正常获取
        mockMvc.perform(
                //发起 post 请求
                post("/user/listForAll")
        )
                //断言请求状态
                .andExpect(status().isOk())
                //断言返回结果是数组
                .andExpect(jsonPath("$").isArray())
                //断言返回数组不是空的
                .andExpect(jsonPath("$").isNotEmpty());
    }
}