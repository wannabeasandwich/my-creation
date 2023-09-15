package cn.tedu.csmall.commons.pojo.admin.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AdminLoginVO implements Serializable {

    /**
     * 管理员id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码（密文）
     */
    private String password;

    /**
     * 账号是否启用 0-未启用 1-启用
     */
    private Integer enable;

    /**
     * 权限列表
     */
    private List<String> permissions;
}
