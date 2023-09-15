package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 用于测试JDBC修改记录
 */
public class TestUpdate {
    private static Connection conn = null;
    private static PreparedStatement ps = null;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding=utf8&serverTimeZone=Asia/Shanghai";
        String user = "root";
        String pwd = "root";
        conn = DriverManager.getConnection(url, user, pwd);
        System.out.println("连接成功~~");
        //1.获取PreparedStatement的实例
        //1.1定义sql语句
        String sql = "UPDATE location SET name = '无尽之海' WHERE id = 5";
        //1.2创建PreparedStatement实例,并接受sql语句作为参数
        ps = conn.prepareStatement(sql);
        //1.3通过PreparedStatement调用executeUpdate()方法执行修改操作
        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "修改" + rows + "条记录成功!" : "修改失败!!!");
        //2.释放资源
        ps.close();
        conn.close();
    }
}
