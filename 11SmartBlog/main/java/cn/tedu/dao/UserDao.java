package cn.tedu.dao;

import cn.tedu.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 向tb_users表中新增记录
     *
     * @param user 新增的用户信息
     * @return 新增的记录数
     */
    public int insert(User user);

    /**
     * 查询指定注册时间范围内的用户信息
     *
     * @param beginTime 起始时间
     * @param endTime   终止时间
     * @return 指定范围内容的用户信息的集合
     */
    public List<User> list(String beginTime, String endTime);

    /**
     * 根据id修改指定的用户信息
     *
     * @param user 包含要修改的用户记录的id和修改信息
     * @return 修改的记录数
     */
    public int update(User user);

    /**
     * 批量修改用户的状态值
     *
     * @param status 要修改的状态值
     * @param ids    被修改状态值的用户的id
     * @return 修改的记录数
     */
    public int updateByIds(Integer status, Integer[] ids);
}
