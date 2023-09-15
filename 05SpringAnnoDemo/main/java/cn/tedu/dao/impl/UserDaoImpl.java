package cn.tedu.dao.impl;


import cn.tedu.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * 将UserDaoImpl交给Spring容器管理,直接在类上添加@Component注解即可
 * 相当于在Spring的application.xml配置文件中,添加如下内容:
 * <bean id="userDao" class="cn.tedu.dao.impl.UserDaoImpl"/>
 */
@Repository //标记当前类属于dao层,交给Spring容器管理
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save运行了~");
    }
}
