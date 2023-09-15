package cn.tedu.csmall.sso.mapper;

import cn.tedu.csmall.commons.pojo.admin.model.Admin;
import cn.tedu.csmall.commons.pojo.admin.vo.AdminListItemVO;
import cn.tedu.csmall.commons.pojo.admin.vo.AdminLoginVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 管理员Mapper接口
 */
@Repository
public interface AdminMapper {

    /**
     * 插入管理员数据
     *
     * @param admin 管理员数据
     * @return 受影响的行数，成功插入数据时，将返回1
     */
    int insert(Admin admin);

    /**
     * 根据管理员用户名统计此用户名对应的管理员数据的数量
     *
     * @param username 管理员用户名
     * @return 此名称对应的管理员数据的数量
     */
    int countByUsername(String username);

    /**
     * 查询管理员列表
     *
     * @return 管理员列表的集合
     */
    List<AdminListItemVO> list();

    /**
     * 根据管理员用户名查询管理员的登录相关信息
     * @param username 管理员用户名
     * @return 管理员的登录相关信息，没有数据则返回null
     */
    AdminLoginVO getByUsername(String username);
}
