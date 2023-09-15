package cn.tedu;

import cn.tedu.mapper.UserMapper;
import cn.tedu.mapper.UsersMapper;
import cn.tedu.pojo.Users;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 老安
 * @data 2023-07-06 19:56
 */
@SpringBootTest
public class PageHelperTests {
    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void test01() {
        //查询第一页的记录,一页显示10条
        //List<Users> users = usersMapper.selectAllByPage(0, 10);
        //查询第二页的记录,一页显示10条
        List<Users> users = usersMapper.selectAllByPage(10, 10);
        for (Users user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test02() {
        /**
         * 第一个表示查询的页数
         * 第二个参数表示每页显示的记录数
         */
        PageHelper.startPage(3, 10);
        List<Users> users = usersMapper.selectAll();
        for (Users user : users) {
            System.out.println(user);
        }
    }
}
