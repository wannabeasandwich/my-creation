package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * SpringBoot的主启动类
 * 该类是在创建SpringBoot项目时,自动根据用户填写的项目信息创建出来的
 * 该类所在的包路径很重要,整个项目默认会自动扫描主启动类所在的包
 * 运行时,会将在整个项目中的内容,然后让框架生效.
 * 但是目前我们没有办法让主启动类可以一直运行,保证框架环境,所以使用SpringBoot项目中的测试类解决该问题
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
