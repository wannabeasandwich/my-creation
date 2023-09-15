package cn.tedu.dao;

import cn.tedu.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 该类是用于定义关于tb_article表的接口映射
 */
@Mapper
public interface ArticleDao {
    /**
     * 向tb_article表中新增文章信息
     *
     * @param article 文章信息
     * @return 新增的记录数
     */
    public int insert(Article article);

    /**
     * 基于文章id查询出文章信息,并且包含文章的作者信息以及文章的标签信息
     *
     * @param id 文章id
     * @return 文章信息(包含作者信息和标签信息)
     */
    public Article selectById(Long id);

    /**
     * 查询所有文章信息,包含章的作者信息以及文章的标签信息
     *
     * @return 多篇文章信息(包含作者信息和标签信息)
     */
    public List<Article> select();
}
