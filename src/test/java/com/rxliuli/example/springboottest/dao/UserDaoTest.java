package com.rxliuli.example.springboottest.dao;

import com.rxliuli.example.springboottest.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@code @SpringBootTest} 和 {@code @RunWith(SpringRunner.class)} 是必须的，这里貌似一直有人误会需要使用 {@code @RunWith(SpringJUnit4ClassRunner.class)}，但其实并不需要了
 * 下面的 {@code @Transactional} 和 {@code @Rollback}则是开启事务控制以及自动回滚
 *
 * @author rxliuli
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@Rollback
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void get() {
        int id = 1;
        User result = userDao.get(id);
        //断言 id 和 get id 相同
        assertThat(result)
                .extracting(User::getId)
                .contains(id);
    }

    @Test
    public void listForAll() {
        List<User> userList = userDao.listForAll();
        //断言不为空
        assertThat(userList)
                .isNotEmpty();
    }

    @Test
    public void deleteById() {
        int result = userDao.deleteById(1);
        assertThat(result)
                .isGreaterThan(0);
    }
}