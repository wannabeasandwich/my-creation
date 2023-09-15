package jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 用于测试JDBC获取数据库链接是否通畅的案例
 */
public class TestConnection {
    public static void main(String[] args) throws Exception {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取和数据库的连接
        //2.1指定URL,确定要连接哪个数据库
        String url = "jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
        //2.2指定使用的用户名
        String username = "root";
        //2.3指定使用的密码
        String password = "root";
        //2.4调用 DriverManager 类的 getConnection() 方法建立到数据库的连接
        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("链接成功!!!");
    }
}
