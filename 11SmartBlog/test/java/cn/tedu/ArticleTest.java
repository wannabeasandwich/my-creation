package cn.tedu;

import cn.tedu.dao.ArticleDao;
import cn.tedu.dao.ArticleTagDao;
import cn.tedu.dao.TagDao;
import cn.tedu.pojo.Article;
import cn.tedu.pojo.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class ArticleTest {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private ArticleTagDao articleTagDao;

    @Test
    public void insert() {
        Article article = new Article();
        article.setTitle("第二阶段如何学习?");
        article.setContent("欲练此功,必现苦其心志,劳其筋骨,饿其体肤!");
        article.setType("1");
        article.setStatus("2");
        article.setUserId(35L);
        System.out.println("插入文章之前的文章id:" + article.getId());
        //将文章信息写入到文章表中
        int rows = articleDao.insert(article);
        System.out.println(rows > 0 ? "新增文章信息成功!" : "新增文章信息失败");
        System.out.println("插入文章之后的文章id:" + article.getId());
        //将文章关联的标签信息,写入到标签表中
        rows = articleTagDao.insert(article.getId(), new Long[]{1L, 9L});
        System.out.println(rows > 0 ? "新增标签信息成功!" : "新增信息信息失败");
    }

    @Test
    public void selectById() {
        Article article = articleDao.selectById(1L);
        System.out.println("文章信息:" + article);
        System.out.println("作者信息:" + article.getAuthor());
        List<Tag> tagList = article.getTagList();
        for (Tag tag : tagList) {
            System.out.println(article.getTitle() + "文章的标签信息:" + tag);
        }
    }
    @Test
    public void select() {
        List<Article> articleList = articleDao.select();
        for (Article article : articleList) {
            System.out.println("文章信息:" + article);
            System.out.println("作者信息:" + article.getAuthor());
            List<Tag> tagList = article.getTagList();
            System.out.println("标签信息:");
            for (Tag tag : tagList) {
                System.out.println(tag);
            }
            System.out.println("===============================================================");
        }

    }
}
