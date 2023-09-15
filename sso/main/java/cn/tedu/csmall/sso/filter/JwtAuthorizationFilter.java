package cn.tedu.csmall.sso.filter;

import cn.tedu.csmall.commons.restful.JsonResult;
import cn.tedu.csmall.commons.restful.ResponseCode;
import cn.tedu.csmall.sso.security.LoginPrincipal;
import cn.tedu.csmall.sso.util.JwtUtils;
import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * OncePerRequestFilter：确保在一请求中只通过一次过滤器
 *
 * 处理JWT的过滤器
 *  <p>此过滤器将尝试获取请求中的JWT数据，如果存在有效数据，将尝试解析，</p>
 *  <p>然后，将解析得到的结果存入到Spring Security的上下文中，</p>
 *  <p>以至于Spring Security框架中的其它组件能够从上下文中获取到用户的信息，</p>
 *  <p>从而完成后续的授权访问。</p>
 */
@Slf4j
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        log.debug("执行JwtAuthorizationFilter...");

        // 清除security上下文
        SecurityContextHolder.clearContext();

        // 从请求头获取JWT
        String jwt = httpServletRequest.getHeader("Authorization");
        log.debug("从请求头中获取到的jwt数据：{}",jwt);

        // 判断是否获取到有效的JWT数据: 不为null&不为空白&包含文本 -- 无JWT数据(直接放行-验证登录)
        if(!StringUtils.hasText(jwt)){
            log.debug("请求头中JWT是无效的，直接放行！");
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }

        // 解析
        Claims claims = null;
        try {
            claims = JwtUtils.parse(jwt);
        }catch (MalformedJwtException e){
            log.debug("解析JWT失败，JWT数据有误：{},{}",e.getClass().getName(),e.getMessage());
            String message = "获取登录信息失败，请重新登录！";

            JsonResult jsonResult = JsonResult.failed(ResponseCode.BAD_REQUEST,message);

            String jsonResultString = JSON.toJSONString(jsonResult);
            log.debug("将向客户端响应：{}",jsonResultString);

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonResultString);
            return;
        }catch (SignatureException e){
            log.debug("解析JWT失败，JWT数据有误：{},{}",e.getClass().getName(),e.getMessage());
            String message = "获取登录信息失败，请重新登录！";

            JsonResult jsonResult = JsonResult.failed(ResponseCode.BAD_REQUEST,message);

            String jsonResultString = JSON.toJSONString(jsonResult);
            log.debug("将向客户端响应：{}",jsonResultString);

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonResultString);
            return;
        }catch (ExpiredJwtException e){
            log.debug("解析JWT失败，JWT数据过期：{},{}",e.getClass().getName(),e.getMessage());
            String message = "登录信息过期，请重新登录！";

            JsonResult jsonResult = JsonResult.failed(ResponseCode.BAD_REQUEST,message);

            String jsonResultString = JSON.toJSONString(jsonResult);
            log.debug("将向客户端响应：{}",jsonResultString);

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonResultString);
            return;
        }catch (Throwable e){
            log.debug("解析JWT失败，错误原因：{},{}",e.getClass().getName(),e.getMessage());
            String message = "服务器忙，请稍后重试！";

            JsonResult jsonResult = JsonResult.failed(ResponseCode.BAD_REQUEST,message);

            String jsonResultString = JSON.toJSONString(jsonResult);
            log.debug("将向客户端响应：{}",jsonResultString);

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonResultString);
            return;
        }

        Object id = claims.get("id");
        log.debug("从JWT中解析出的id:{}",id);

        Object username = claims.get("username");
        log.debug("从JWT中解析出的username:{}",username);

        // 准备当前登录的当事人信息
        LoginPrincipal loginPrincipal = new LoginPrincipal();
        loginPrincipal.setId(Long.parseLong(id.toString()));
        loginPrincipal.setUsername(username.toString());

        // 用户权限
        Object authoritiesString = claims.get("authorities");
        log.debug("从JWT中解析出的authoritiesString:{}",authoritiesString);
        List<SimpleGrantedAuthority> authorities =
                JSON.parseArray(authoritiesString.toString(), SimpleGrantedAuthority.class);

        // 解析成功后，将相关数据存入到Security上下文中
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(loginPrincipal,null,authorities);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        // "放行"
        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }
}




