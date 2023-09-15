package cn.tedu;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class TestHikariCP {
    /**
     * 创建数据源对象
     * 可以通过该对象获取操作连接池的权限,
     * 可以利用该对象从连接池中获取连接,或者归还连接
     */
    @Autowired
    private DataSource source;

    @Test
    public void testConnection() throws SQLException {
        //从连接池中获取一个连接
        Connection conn = source.getConnection();
        System.out.println("conn = " + conn);
        //归还连接,不是关闭连接
        conn.close();
    }

}
