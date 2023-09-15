package cn.tedu.csmall.sso.config;

import cn.tedu.csmall.sso.filter.JwtAuthorizationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启全局的授权访问的检查
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthorizationFilter jwtAuthorizationFilter;


    @Bean
    public PasswordEncoder passwordEncoder(){
        log.debug("创建密码编码器组件！");
        // return NoOpPasswordEncoder.getInstance(); // 不加密的密码编码器
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();  // 禁用防止跨域访问

        http.cors();

        // 白名单 - 不需要登录就可以访问的请求
        String[] urls = {
            "/admins/login",
            "/doc.html",
            "/**/*.css",
            "/**/*.js",
            "/swagger-resources",
            "/v2/api-docs",
            "/favicon.ico"
        };

        // /*只能匹配1层级路径：/user /admins 不能匹配多层级：/admins/add /admins/list
        // /** 可以匹配若干层级路径
        http.authorizeRequests()            // 请求需要被授权才可以访问
            .antMatchers(urls)              // 匹配某些路径
            .permitAll()                    // 允许直接访问
            .anyRequest()                   // 其他请求
            .authenticated();               // 通过认证（已经登录才能访问）

        // 添加处理JWT过滤器，必须在处理用户名与密码过滤器(Security内置)之前。 - 验证JWT成功后无需验证登录
        http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
    }


}













