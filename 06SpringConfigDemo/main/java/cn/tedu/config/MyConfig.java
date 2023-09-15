package cn.tedu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Configuration标识当前类是配置类
 * 当SpringBoot容器启动时,会自动加载当前类的内容
 * 用于替代Spring的配置文件
 */
@Configuration
public class MyConfig {
    static {
        System.out.println("配置类被自动加载了...");
    }
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /**
     * @Bean用于标识当前方法返回的结果,是要交给Spring容器管理的,
     * 并且在Spring容器中,该实例的id就是当前的方法名getConnection
     */
    @Bean
    public Connection getConnection() throws Exception {
        System.out.println("配置类@Bean给容器中添加组件了...");
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
}
