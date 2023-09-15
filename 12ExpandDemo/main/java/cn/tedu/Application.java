package cn.tedu;

import cn.tedu.mapper.ArticlesMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        ArticlesMapper bean = context.getBean(ArticlesMapper.class);
        System.out.println(bean);
    }
}
