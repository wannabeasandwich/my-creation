package cn.tedu.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleTagDao {
    /**
     * 将文章和标签的关系数据写入到tb_article_tags中
     *
     * @param articleId 文章的id
     * @param tagIds    文章对应的标签id组
     * @return 新增的记录数
     */
    public int insert(Long articleId, Long[] tagIds);
}
