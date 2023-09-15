package cn.tedu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

@SpringBootTest
public class TestJDBC {
    @Autowired
    private DataSource dataSource;

    @Test
    public void testAdd() throws Exception {
        //1.获取连接
        Connection conn = dataSource.getConnection();
        //2.创建PreparedStatement对象(基于该对象发送sql)
        String sql = "INSERT INTO class (name, floor, teacher_id) VALUES (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        //3.为sql骨架插入具体的参数值
        ps.setString(1, "3年5班");
        ps.setInt(2, 3);
        ps.setInt(3, 99);
        //4.发送sql
        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "新增成功" : "新增失败");
        //5.处理结果(一般都是查询操作处理结果)
        //6.释放资源
        ps.close();
        conn.close();
    }

    /**
     * 查询class表中的指定id的一条记录
     *
     * @throws Exception
     */
    @Test
    public void testQuery() throws Exception {
        //1.获取连接
        Connection conn = dataSource.getConnection();
        //2.创建Statement(基于此对象发送sql)
        String sql = "SELECT id, name, floor, teacher_id FROM class WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 22);
        //3.发送sql
        ResultSet rs = ps.executeQuery();
        //4.处理结果
        while (rs.next()) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", rs.getInt("id"));
            map.put("name", rs.getString("name"));
            map.put("floor", rs.getInt("floor"));
            map.put("teacher_id", rs.getInt("teacher_id"));
            System.out.println(map);
        }
        //5.释放资源
        rs.close();
        ps.close();
        conn.close(); //将连接归还到连接池中
    }
}
