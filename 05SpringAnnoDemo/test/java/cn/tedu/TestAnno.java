package cn.tedu;

import cn.tedu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestAnno {
    /**
     * 注入时,由于属性注入,所以最好封装起来
     * 属性类型,能用父类型,就不要用真实类型
     */
    @Autowired
    private UserService service;

    @Test
    public void testComponent() {
        service.save();
    }

    @Test
    public void testValue() {
        System.out.println(service);
    }
}
