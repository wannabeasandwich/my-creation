package cn.tedu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * SpringBoot项目默认提供的测试类,但是主要的其中的注解,
 * 只要有以下的注解,什么类都可以是测试类
 * ①类上使用@SpringBootTest表示该类是SpringBoot测试类,当运行其中的测试方法时,会自动运行Application主启动类
 * ②在类中的方法(在方法中定义要测试的业务逻辑,该方法称为单元测试方法),并在方法上添加@Test注解,此时该方法可以被运行
 * ③单元测试方法声明是有要求的:
 *   1)必须是公开的方法
 *   2)必须返回值是void(测试方法是不需要返回值的)
 *   3)必须是无参方法(测试方法所需的参数,都提前在方法中定义好即可)
 */
@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(1111);
    }

}
