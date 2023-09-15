package jdbc;

import java.sql.*;

/**
 * 用于测试JDBC的事务处理
 */
public class TestTransaction {
    private static Connection conn = null;
    private static PreparedStatement ps = null;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding=utf8&serverTimeZone=Asia/Shanghai";
        String user = "root";
        String pwd = "root";
        conn = DriverManager.getConnection(url, user, pwd);
        System.out.println("连接成功~~");
        //1.开启手动提交事务(默认是自动提交事务)
        conn.setAutoCommit(false);//关闭自动提交事务,开始手动提交模式
        try {//CTRL+ALT+T 快速生成代码体
            //2.定义多条SQL语句
            String sql1 = "UPDATE location SET name = '青岛' WHERE id = 8";//CTRL+D 快速复制当前行到下一行
            String sql2 = "UPDATE location SET name = '大冶' WHERE id = 7";
            //3.执行SQL,如果SQL语句定义有误,执行时,会抛出SQLException
            ps = conn.prepareStatement(sql1);
            ps.executeUpdate();
            System.out.println("第一条记录更新成功啦!");
            ps = conn.prepareStatement(sql2);
            ps.executeUpdate();
            System.out.println("第二条记录更新成功啦!");
            //4.提交事务
            conn.commit();
        } catch (SQLException throwables) {
            //5.回滚事务
            System.out.println("更新失败!");
            conn.rollback();
        }
        //6.释放资源
        ps.close();
        conn.close();
    }
}
