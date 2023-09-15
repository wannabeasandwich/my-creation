package cn.tedu.csmall.sso;

import cn.tedu.csmall.commons.pojo.admin.vo.AdminLoginVO;
import cn.tedu.csmall.sso.mapper.AdminMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CsmallSsoApplicationTests {

    @Autowired
    private AdminMapper mapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testGetByUsername() {
        String username = "root";
        AdminLoginVO adminLoginVO = mapper.getByUsername(username);
        System.out.println(adminLoginVO);
    }

}











