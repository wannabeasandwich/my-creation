package cn.tedu.csmall.sso.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;

@Slf4j
public class JwtUtils {

    /** 密钥*/
    private static final String SECRET_KEY = "jafdhlkjer";

    /** 以分钟为单位*/
    private static final Long EXPIRED_IN_MINUTE = 7L * 24 * 60;

    /** 私有化构造，避免外部随意创建对象*/
    private JwtUtils(){}

    /** 生成JWT*/
    public static String generate(Map<String,Object> claims){

        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRED_IN_MINUTE * 60 * 1000);

        // JWT的组成部分：Header(头)、payload(载荷)、Signature(签名)
        String jwt = Jwts.builder()
                // Header(头)：用于配置算法（alg）与结果数据类型（typ）
                .setHeaderParam("alg","HS256") //HS256算法名称
                .setHeaderParam("typ","jwt")
                // payload(载荷):用于配置需要封装到JWT的数据
                .setClaims(claims)
                .setExpiration(expirationDate)
                // Signature(签名) 用于指定算法与密钥(盐)
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact(); // 打包
        log.debug(jwt);

        return jwt;
    }

    /** 解析JWT*/
    public static Claims parse(String jwt){
        Claims claims =
                Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt).getBody();
        return claims;
    }


}
