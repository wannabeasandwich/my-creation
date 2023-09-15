package cn.tedu.csmall.sso.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// MyBatis框架扫描mapper接口包的注解
@MapperScan("cn.tedu.csmall.sso.mapper")
public class MyBatisConfiguration {
}
