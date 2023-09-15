package cn.tedu;

import cn.tedu.mapper.ArticlesMapper;
import cn.tedu.pojo.Articles;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.Action;
import java.util.List;

@SpringBootTest
class ArticleTests {
    @Autowired
    private ArticlesMapper articlesMapper;

    @Test
    void selectAll() {
        List<Articles> articles = articlesMapper.selectAll();
        for (Articles article : articles) {
            System.out.println(article);
        }
    }

}
