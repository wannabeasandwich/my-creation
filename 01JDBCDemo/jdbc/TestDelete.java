package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * 用于测试JDBC删除记录
 */
public class TestDelete {
    private static Connection conn = null;
    private static PreparedStatement ps = null;

    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        //第一种连接方式(推荐的方式)
        //String url = "jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding=utf8&serverTimeZone=Asia/Shanghai";
        //String user = "root";
        //String pwd = "root";
        //conn = DriverManager.getConnection(url, user, pwd);
        //第二种连接方式
        //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding=utf8&serverTimeZone=Asia/Shanghai&user&user=root&password=root");
        //第三种连接方式
        Properties info = new Properties();//相当于是一个Map
        info.setProperty("user", "root");
        info.setProperty("password", "root");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding=utf8&serverTimeZone=Asia",info);
        System.out.println("连接成功~~");
        //1.获取PreparedStatement的实例
        //1.1定义sql语句
        String sql = "DELETE FROM location WHERE id = 18";
        //1.2创建PreparedStatement实例,并接受sql语句作为参数
        ps = conn.prepareStatement(sql);
        //1.3通过PreparedStatement调用executeUpdate()方法执行删除操作
        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "删除" + rows + "条记录成功!" : "删除失败!!!");
        //2.释放资源
        ps.close();
        conn.close();
    }
}
