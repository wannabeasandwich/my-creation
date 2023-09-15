package cn.tedu.service.impl;

import cn.tedu.dao.UserDao;
import cn.tedu.dao.impl.UserDaoImpl;
import cn.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service //标记当前类属于业务层,交给Spring容器管理
public class UserServiceImpl implements UserService {
    @Value("${user.username}") //给name属性注入值
    private String name;
    @Value("${user.age}") //给age属性注入值
    private Integer age;

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 声明要使用的属性,如果该对象已经交给Spring容器管理,
     * 则直接在属性上使用@Autowired注解,即可获取Spring容器管理的该对象
     */
    @Autowired //自动注入
    private UserDao userDao;

    @Override
    public void save() {
        //userDao = new UserDaoImpl();
        userDao.save();
    }
}
