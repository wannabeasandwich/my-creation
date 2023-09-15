package cn.tedu.mapper;

import cn.tedu.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    Users selectByPrimaryKey(Integer id);

    List<Users> selectAll();

    /**
     * 分页查询tb_users表中记录
     *
     * @param offset 当前页的第一条记录的编号
     * @param size   每页显示的记录数
     * @return
     */
    List<Users> selectAllByPage(Integer offset, Integer size);

    int updateByPrimaryKey(Users record);
}