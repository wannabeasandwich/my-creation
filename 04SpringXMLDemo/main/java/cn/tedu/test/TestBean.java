package cn.tedu.test;

import cn.tedu.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试Spring的IOC的功能
 */
public class TestBean {
    public static void main(String[] args) {
        User user = new User();
        System.out.println("new方式:" + user);
        //1.加载配置文件(application.xml)
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("application.xml");
        //2.通过application.xml中声明的id,获取Spring管理的对象
        User user1 = (User) ac.getBean("user1");
        System.out.println("Spring容器管理方式:" + user1);
        User user2 = new User("一群猪", 18);
        System.out.println("new对象之构造器方式注入:" + user2);
        User user3 = new User();
        user3.setName("两群猪");
        user3.setAge(20);
        System.out.println("new对象之set方式注入:" + user3);
        User user4 = (User) ac.getBean("user4");
        System.out.println("Spring容器之set方式注入:" + user4);
        User user5 = (User) ac.getBean("user5");
        System.out.println("Spring容器之构造器方式注入:" + user5);
    }
}
