package cn.tedu;

import cn.tedu.mapper.ArticlesMapper;
import cn.tedu.mapper.UsersMapper;
import cn.tedu.pojo.Articles;
import cn.tedu.pojo.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LoadTests {
    @Autowired
    private ArticlesMapper articlesMapper;
    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void test01() {
        Articles articles = articlesMapper.selectByPrimaryKey(100L);
        System.out.println("文章信息:" + articles);
        try {
            Long userId = articles.getUserId();
            int i = userId.intValue();
            if (userId != null) {
                Users users = usersMapper.selectByPrimaryKey(i);
                System.out.println("用户信息:" + users);
            }
        } catch (NullPointerException e) {
            System.out.println("文章信息不存在!");
        }
    }

    @Test
    public void test02() {
        /**
         * 根据结果集设置不设置fetchType="lazy",分两种情况
         * 情况一: 不设置懒加载
         * 执行第一条SQL,如果查询出结果,就执行两条SQL语句,如果查询不出结果,则只执行一条SQL
         * 情况二: 设置懒加载
         * 指向第一条SQL,如果不使用关联数据,则不会执行第二条SQL语句,如果需要关联数据,才会执行第二条SQL语句
         */
        Articles articles = articlesMapper.selectByPrimaryKey(1L);
        System.out.println("文章标题:" + articles.getTitle());
        //System.out.println("文章信息:" + articles);
        //System.out.println("用户信息:" + articles.getUsers());
    }

    @Test
    public void test03() {
        Users users = usersMapper.selectByPrimaryKey(1);
        System.out.println("用户昵称:" + users.getNickname());
        List<Articles> articles = users.getArticles();
        for (Articles article : articles) {
            System.out.println(article);
        }
    }
}
