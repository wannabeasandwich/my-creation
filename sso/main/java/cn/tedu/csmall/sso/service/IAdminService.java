package cn.tedu.csmall.sso.service;

import cn.tedu.csmall.commons.pojo.admin.dto.AdminAddDTO;
import cn.tedu.csmall.commons.pojo.admin.dto.AdminLoginDTO;
import cn.tedu.csmall.commons.pojo.admin.vo.AdminListItemVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 管理员业务接口
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
public interface IAdminService {

    /**
     * 添加管理员
     *
     * @param adminAddDTO 管理员数据
     */
    @Transactional
    void addNew(AdminAddDTO adminAddDTO);

    /**
     * 查询管理员列表
     *
     * @return 管理员列表的集合
     */
    List<AdminListItemVO> list();

    /**
     * 管理员登录
     * @param adminLoginDTO 封装了管理员的登录提交的数据
     */
    String login(AdminLoginDTO adminLoginDTO);
}
