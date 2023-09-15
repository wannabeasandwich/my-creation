package cn.tedu;

import cn.tedu.mapper.ArticlesMapper;
import cn.tedu.mapper.UserMapper;
import cn.tedu.pojo.Articles;
import cn.tedu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        List<User> list = userMapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void test02() {
        User user = new User();
        user.setUsername("王五");
        user.setPassword("123");
        user.setName("wangwu");
        userMapper.save(user);
    }
    @Test
    public void test03() {
        User user = new User();
        user.setId(3);
        userMapper.delete(user);
    }
    @Test
    public void test04() {
        User user = userMapper.findById(1).get();
        System.out.println(user);
    }
}
