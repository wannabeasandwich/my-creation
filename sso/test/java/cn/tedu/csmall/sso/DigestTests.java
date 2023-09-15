package cn.tedu.csmall.sso;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@SpringBootTest
public class DigestTests {

    @Test
    public void test01MdD5(){
        String rawPassword = "123123";

        String encodePassword = DigestUtils.md5DigestAsHex(rawPassword.getBytes());

        System.out.println("rawPassword: "+rawPassword);
        System.out.println("encodePassword: "+encodePassword);
        // rawPassword: 123123
        // encodePassword: 4297f44b13955235245b2497399d7a93
    }

    @Test
    public void test02MdD5(){

        String salt = "onSD98_$a";
        String rawPassword = "123123";

        String encodePassword = DigestUtils.md5DigestAsHex((rawPassword+salt).getBytes());

        System.out.println("rawPassword: "+rawPassword);
        System.out.println("encodePassword: "+encodePassword);

    }

    @Test
    public void test03MdD5(){

        String rawPassword = "123123";
        String encodePassword1 = DigestUtils.md5DigestAsHex(rawPassword.getBytes());

        String encodePassword = DigestUtils.md5DigestAsHex(encodePassword1.getBytes());
        System.out.println("rawPassword: "+rawPassword);
        System.out.println("encodePassword: "+encodePassword);

    }

    @Test
    public void test04MdD5(){
        for(int i=0;i<5;i++){
            String salt = UUID.randomUUID().toString();
            String rawPassword = "123123";

            String encodePassword = DigestUtils.md5DigestAsHex((rawPassword+salt).getBytes());

            System.out.println("rawPassword: "+rawPassword);
            System.out.println("encodePassword: "+encodePassword);
        }
        /*
            rawPassword: 123123
            encodePassword: 7faf0965d8cdc1ba09d8c5ab3dddf55a
            rawPassword: 123123
            encodePassword: d1dfa224bcf5df35c14e9d630de4c569
            rawPassword: 123123
            encodePassword: 92c7c60d3fddef552f86d6e41b88391a
            rawPassword: 123123
            encodePassword: d904696d721c8e0aaf28e5bb0f858a99
            rawPassword: 123123
            encodePassword: 0805f9e062d28da537ff098d037fae07
         */
    }

    @Test
    public void testBcryptEncode(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "123123";

        String encodePassword = passwordEncoder.encode(rawPassword);
        System.out.println("rawPassword: "+rawPassword);
        System.out.println("encodePassword: "+encodePassword);
        // $2a$10$Y.6PFTpAKtyn4xOKqSN9u.kfgnOz5mkRKlSU8N7VeahQJ5y4V5aUm
        // $2a$10$ASsa4H80VlRCISSm4URL1uhNVWvufvxHBAGWj4HWIw3DfKRxwFsXq
        // $2a$10$zN4PB.Ul.xHXWd8w/FHlueD3BldN5FdLkh/c1XqS5JdPUBOhCqgKW
    }

    @Test
    public void testBcryptMatches(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String rawPassword = "123123";
        String encodePassword = "$2a$10$ASsa4H80VlRCISSm4URL1uhNVWvufvxHBAGWj4HWIw3DfKRxwFsXq";

        boolean matches = passwordEncoder.matches(rawPassword, encodePassword);

        System.out.println("匹配结果："+matches);
    }


}















