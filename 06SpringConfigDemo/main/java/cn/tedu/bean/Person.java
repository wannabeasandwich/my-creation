package cn.tedu.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
//该注解会通过指定prefix的值,去配置文件中,找对应层级的配置信息,然后自动根据属性和配置文件的值进行映射
//只适合配置文件字段和属性同名的情况,否则还是需要使用@Value
@ConfigurationProperties(prefix = "person")
public class Person {
    //用户名
    //@Value("${person.username}")
    private String username;
    //年龄
    //@Value("${person.age}")
    private Integer age;
    //是否是父母
    //@Value("${person.parent}")
    private boolean parent;
    //生日
    //@Value("${person.birth}")
    private Date birth;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isParent() {
        return parent;
    }

    public void setParent(boolean parent) {
        this.parent = parent;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }


    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", parent=" + parent +
                ", birth=" + birth +
                '}';
    }
}
