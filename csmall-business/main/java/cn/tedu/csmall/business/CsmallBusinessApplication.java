package cn.tedu.csmall.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class CsmallBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsmallBusinessApplication.class, args);
    }

}
