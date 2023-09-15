package cn.tedu.dao;

import cn.tedu.pojo.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagDao {
    /**
     * 向tb_tags表新增一条标签
     *
     * @param tag 新增标签的内容
     * @return 新增的实际数量
     */
    @Insert("INSERT INTO tb_tags(name,remark,created_time,modified_time) VALUES (#{name},#{remark},#{createdTime},#{modifiedTime})")
    public int insert(Tag tag);
}
