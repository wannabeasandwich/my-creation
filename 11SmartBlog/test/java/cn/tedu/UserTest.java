package cn.tedu;

import cn.tedu.dao.TagDao;
import cn.tedu.dao.UserDao;
import cn.tedu.pojo.Tag;
import cn.tedu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("老安");
        user.setPassword("123456");
        user.setNickname("安总");
        user.setMobile("13261712222");
        user.setStatus(1);
        user.setCreatedTime(new Date());
        user.setModifiedTime(new Date());
        int rows = userDao.insert(user);
        System.out.println(rows > 0 ? "成功!" : "失败!");
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1);
        user.setUsername("伟浪");
        user.setPassword("555555");
        user.setNickname("浪浪");
        user.setMobile("8008208820");
        user.setStatus(1);
        int rows = userDao.update(user);
        System.out.println(rows > 0 ? "成功!" : "失败!");
    }

    @Test
    public void updateByIds() {
        Integer[] ids = {1, 3, 5, 7, 9};
        Integer status = 0;
        int rows = userDao.updateByIds(status, ids);
        System.out.println(rows > 0 ? "成功!" : "失败!");
    }

    @Test
    public void list() {
        String beginTime = "2022-08-05 11:00:00";
        String endTime = "2022-08-10 11:00:00";
        List<User> users = userDao.list(null, null);
        for (User user : users) {
            String username = user.getUsername();
            Date createdTime = user.getCreatedTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = sdf.format(createdTime);
            System.out.println(username + " : " + date);
        }
    }
}
