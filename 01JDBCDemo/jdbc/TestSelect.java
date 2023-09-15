package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 用于测试JDBC查询记录
 */
public class TestSelect {
    private static Connection conn = null;
    private static PreparedStatement ps = null;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding=utf8&serverTimeZone=Asia/Shanghai";
        String user = "root";
        String pwd = "root";
        conn = DriverManager.getConnection(url, user, pwd);
        System.out.println("连接成功~~");
        //1定义sql语句
        String sql = "SELECT id, name FROM location";
        //2创建PreparedStatement实例,并接受sql语句作为参数
        ps = conn.prepareStatement(sql);
        //3通过PreparedStatement调用executeQuery()方法执行查询操作
        ResultSet rs = ps.executeQuery();
        //4.遍历结果集
        while (rs.next()) {//while循环一次,迭代一行
            //获取当前行中列名为id的列的值,类型是int
            int id = rs.getInt("id");
            //获取当前行中列名为name的列的值,类型是String
            String name = rs.getString("name");
            System.out.println(id + "\t" + name);//'\t'是Tab键
        }
        //5.释放资源(后获取的先释放)
        rs.close();
        ps.close();
        conn.close();
    }
}
