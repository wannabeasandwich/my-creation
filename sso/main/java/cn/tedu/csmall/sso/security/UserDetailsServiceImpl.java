package cn.tedu.csmall.sso.security;

import cn.tedu.csmall.commons.pojo.admin.vo.AdminLoginVO;
import cn.tedu.csmall.sso.mapper.AdminMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 一旦编写了`UserDetailsService`接口的实现类，并将此类由Spring创建对象，
 * 则Spring Security会自动装配此类的对象，在后续启动项目时，将不再生成默认的随机密码，且默认的用户名`user`将不再可用。
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        log.debug("Spring Security 自动根据用户名 {} 查询用户详情",s);

        // 执行查询
        AdminLoginVO adminLoginVO = adminMapper.getByUsername(s);

        // 判断从数据库中是否读取到了有效的用户数据
        if(adminLoginVO != null){

            List<String> permissions = adminLoginVO.getPermissions();
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for(String permission : permissions){
                authorities.add(new SimpleGrantedAuthority(permission));
            }

            AdminDetails adminDetails = new AdminDetails(
                    adminLoginVO.getUsername(),
                    adminLoginVO.getPassword(),
                    adminLoginVO.getEnable()==1,
                    authorities
            );

            adminDetails.setId(adminLoginVO.getId());

            return adminDetails;
        }

        return null;
    }
}








