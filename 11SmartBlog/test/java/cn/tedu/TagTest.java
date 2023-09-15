package cn.tedu;

import cn.tedu.dao.TagDao;
import cn.tedu.pojo.Tag;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.util.Date;

@SpringBootTest
public class TagTest {
    @Autowired
    private TagDao tagDao;

    @Test
    public void insert() {
        Tag tag = new Tag();
        tag.setName("chatGPT");
        tag.setRemark("这是目前非常火热的人工智能");
        tag.setCreatedTime(new Date());
        tag.setModifiedTime(new Date());
        int rows = tagDao.insert(tag);
        System.out.println(rows > 0 ? "成功!" : "失败!");
    }
}
