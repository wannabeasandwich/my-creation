package cn.tedu.csmall.stock.webapi;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 如果当前项目是dubbo的生产者，需要添加这个注解，否则无法调用该项目的方法
@EnableDubbo
public class CsmallStockWebapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsmallStockWebapiApplication.class, args);
    }

}
