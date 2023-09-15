package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 用于测试JDBC通过PreparedStatement解决SQL注入问题
 */
public class TestSelect3 {
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding=utf8&serverTimeZone=Asia/Shanghai";
        String user = "root";
        String pwd = "root";
        conn = DriverManager.getConnection(url, user, pwd);
        System.out.println("连接成功~~");
        //1.定义sql语句
        //JDBC中使用?占位符,占位SQL中的参数值位,以此来固定SQL语句的骨架
        String sql = "SELECT id, name FROM location WHERE id = ? AND name = ?";
        //2.创建PreparedStatement实例,并接受sql语句作为参数
        ps = conn.prepareStatement(sql);
        //3.为SQL骨架传入参数
        ps.setInt(1,2);//给第一个问号传入int类型参数,值为2
        ps.setString(2, "上海");//给第二个问号传入String类参数,值为上海
        //ps.setString(2, "' OR '1'='1");
        //4.通过PreparedStatement调用executeQuery()方法执行查询操作
        rs = ps.executeQuery();
        //5.遍历结果集
        System.out.println(rs.next() == true ? "记录存在!" : "记录不存在!");
        //6.释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}
