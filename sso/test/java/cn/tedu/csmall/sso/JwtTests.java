package cn.tedu.csmall.sso;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class JwtTests {

    @Test
    public void testGenerateJwt(){

        // 准备Claims
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",13378);
        claims.put("name","Tom");

        // 过期时间 1分钟
        Date expirationDate = new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000);// 当前时间

        // JWT的组成部分：Header(头)、payload(载荷)、Signature(签名)
        String jwt = Jwts.builder()
                // Header(头)：用于配置算法（alg）与结果数据类型（typ）
                .setHeaderParam("alg","HS256") //HS256算法名称
                .setHeaderParam("typ","jwt")
                // payload(载荷):用于配置需要封装到JWT的数据
                .setClaims(claims)
                .setExpiration(expirationDate)
                // Signature(签名) 用于指定算法与密钥(盐)
                .signWith(SignatureAlgorithm.HS256,"jafdhlkjer")
                .compact(); // 打包
        System.out.println(jwt);

        // 头.载荷.签名
        // eyJhbGciOiJIUzI1NiIsInR5cCI6Imp3dCJ9
        // .
        // eyJuYW1lIjoiVG9tIiwiaWQiOjEzMzc4LCJleHAiOjE2OTI4NzkyNzd9
        // .
        // HBrytzOepfehYeG-D6piohXV873Q_w9SXOZs66Gog0s
    }

    @Test
    public void testParseJwt(){
        String jwt = "eyJhbGciOiJIUzI1NiIsInR5cCI6Imp3dCJ9.eyJleHAiOjE2OTM3MTM1NDIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiIvYW1zL2FkbWluL2RlbGV0ZSJ9LHsiYXV0aG9yaXR5IjoiL2Ftcy9hZG1pbi9yZWFkIn0seyJhdXRob3JpdHkiOiIvYW1zL2FkbWluL3VwZGF0ZSJ9LHsiYXV0aG9yaXR5IjoiL3Btcy9wcm9kdWN0L2RlbGV0ZSJ9LHsiYXV0aG9yaXR5IjoiL3Btcy9wcm9kdWN0L3JlYWQifSx7ImF1dGhvcml0eSI6Ii9wbXMvcHJvZHVjdC91cGRhdGUifV0sInVzZXJuYW1lIjoicm9vdCJ9.1qT3yILL9VoiMWxRkGUq6xQRBLcpkEZFnlmfdnhcF7A";

        Claims claims = Jwts.parser().setSigningKey("jafdhlkjer").parseClaimsJws(jwt).getBody();

        Object username = claims.get("username");
        System.out.println("username:" + username);

        Object authorities = claims.get("authorities");
        System.out.println("authorities:" + authorities);

//        Object id = claims.get("id");
//        Object name = claims.get("name");
//
//        System.out.println("id:"+id);
//        System.out.println("name:"+name);

    }



    @Test
    public void testDate(){
        Date now = new Date();// 当前时间
        System.out.println(now); // Thu Aug 24 19:58:42 CST 2023
        System.out.println(now.getYear());

        Date date1 = new Date();
        System.out.println("date1: "+date1.getTime());
        long l = System.currentTimeMillis(); // 当前时间到1970.1.1 00:00:00的时间戳(毫秒值)
        System.out.println("l:"+l);

        Date date2 = new Date();
        date2.setTime(0); //
        System.out.println("date2: "+date2); // Thu Jan 01 08:00:00 CST 1970

        Date date3 = new Date();
        date3.setTime(System.currentTimeMillis() + 1000);
        System.out.println("date3:"+date3);

        Date date4 = new Date(System.currentTimeMillis() + 1000);
        System.out.println("date4:"+date4);

    }


}











