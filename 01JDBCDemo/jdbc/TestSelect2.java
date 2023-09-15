package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 用于测试JDBC的SQL注入问题
 */
public class TestSelect2 {
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
        int lId = 2;
        String lName = "' OR '1'='1";
        String sql = "SELECT id, name FROM location WHERE id = " + lId + " AND name = '" + lName + "'";
        //变量名.sout 直接输出变量值
        //变量名.soutv 输出变量名+变量值
        System.out.println("sql = " + sql);
        //2.创建PreparedStatement实例,并接受sql语句作为参数
        ps = conn.prepareStatement(sql);
        //3.通过PreparedStatement调用executeQuery()方法执行查询操作
        rs = ps.executeQuery();
        //4.判断结果
        System.out.println(rs.next() == true ? "记录存在!" : "记录不存在!");
        //5.释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}
