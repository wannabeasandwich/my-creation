package cn.tedu;

import cn.tedu.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.sql.*;

@SpringBootTest
class TestYml {
    @Value("${user.username}")
    private String name;
    @Value("${user.age}")
    private Integer age;
    @Autowired
    private Person person;
    @Autowired
    private ApplicationContext ioc;

    @Test
    void testUser() {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }

    @Test
    void testPerson() {
        System.out.println(person);
    }

    @Test
    void testConfig() throws SQLException {
        Connection conn = (Connection) ioc.getBean("getConnection");
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM location");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println(id + " : " + name);
        }
        rs.close();
        ps.close();
        conn.close();
    }
}
