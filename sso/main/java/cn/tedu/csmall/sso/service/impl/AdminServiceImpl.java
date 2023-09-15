package cn.tedu.csmall.sso.service.impl;


import cn.tedu.csmall.commons.exception.CoolSharkServiceException;
import cn.tedu.csmall.commons.pojo.admin.dto.AdminAddDTO;
import cn.tedu.csmall.commons.pojo.admin.dto.AdminLoginDTO;
import cn.tedu.csmall.commons.pojo.admin.model.Admin;
import cn.tedu.csmall.commons.pojo.admin.vo.AdminListItemVO;
import cn.tedu.csmall.commons.restful.ResponseCode;
import cn.tedu.csmall.sso.mapper.AdminMapper;
import cn.tedu.csmall.sso.security.AdminDetails;
import cn.tedu.csmall.sso.service.IAdminService;
import cn.tedu.csmall.sso.util.JwtUtils;
import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 品牌业务实现
 */
@Slf4j
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminMapper adminMapper;

    public AdminServiceImpl() {
        log.debug("创建业务逻辑对象：AdminServiceImpl");
    }

    @Override
    public void addNew(AdminAddDTO adminAddDTO) {
        log.debug("开始处理添加管理员的业务，参数：{}", adminAddDTO);

        // 检查此用户名有没有被占用
        String username = adminAddDTO.getUsername();
        int count = adminMapper.countByUsername(username);
        if (count > 0) {
            String message = "添加管理员失败，用户名【" + username + "】已经被占用！";
            log.error(message);
            throw new CoolSharkServiceException(ResponseCode.CONFLICT, message);
        }

        // 创建实体对象
        Admin admin = new Admin();

        // 将当前方法参数的值复制到实体类型的对象中
        BeanUtils.copyProperties(adminAddDTO, admin);
        // 补全属性值（不由客户端提交的属性的值，应该在插入之前补全）
        admin.setLoginCount(0);
        admin.setLastLoginIp(null);
        admin.setGmtLastLogin(null);

        // 将原密码从admin对象中取出，加密后再存入到admin对象中
        String rawPassword = admin.getPassword();
        String encodePassword = passwordEncoder.encode(rawPassword);
        admin.setPassword(encodePassword);

        // 将管理员数据写入到数据库中
        log.debug("即将向管理员表中写入数据：{}", admin);
        int rows = adminMapper.insert(admin);
    }

    @Override
    public List<AdminListItemVO> list() {
        log.debug("开始处理查询管理员列表的业务");
        return adminMapper.list();
    }

    @Override
    public String login(AdminLoginDTO adminLoginDTO) {
        log.debug("开始处理登录业务，参数：{}",adminLoginDTO);

        // 利用 AuthenticationManager 执行Security的认证
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(adminLoginDTO.getUsername(),adminLoginDTO.getPassword());

        Authentication loginResult = authenticationManager.authenticate(authentication);
        // authenticate()是会抛出异常的方法，如果能执行到此处，则表示用户名与密码是匹配的
        log.debug("登录成功！认证方法返回：{}",loginResult);

        log.debug("尝试获取Principal：{}",loginResult.getPrincipal());

        AdminDetails adminDetails = (AdminDetails) loginResult.getPrincipal();

        Long id = adminDetails.getId();
        log.debug("登录成功的用户id：{}",id);

        String username = adminDetails.getUsername();
        log.debug("登录成功的用户名：{}",username);

        Collection<GrantedAuthority> authorities = adminDetails.getAuthorities();
        log.debug("登录成功的权限：{}",authorities);
        String authoritiesString = JSON.toJSONString(authorities);
        log.debug("权限转换为JSON：{}",authoritiesString);

        // 应该在此处生成JWT，向JWT存入：id(暂无)，username，权限
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",id);
        claims.put("username",username);
        claims.put("authorities",authoritiesString);

        // 调用生成JWT方法
        String jwt = JwtUtils.generate(claims);

        return jwt;
    }
    // 登录请求 -》 Security -》 UserDetailsServiceImpl -》 Mapper
    // 登录请求 -》 Controller -》 Service -》 AuthenticationManager -》 UserDetailsServiceImpl -》 Mapper


}

