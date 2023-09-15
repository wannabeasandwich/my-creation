package cn.tedu.csmall.sso.security;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 自定义用户详情类
 */
//@Data // set\get\equals\hashcode\toString\无参构造
@Setter
@Getter
@EqualsAndHashCode
@ToString(callSuper = true)
public class AdminDetails extends User {

    private Long id;

    public AdminDetails(String username, String password,
                        boolean enable, Collection<? extends GrantedAuthority> authorities){
        super(username,password,enable,
                true,   // 账号未过期
                true, // 凭证未过期
                true,   // 账号未锁定
                authorities);
    }

}


