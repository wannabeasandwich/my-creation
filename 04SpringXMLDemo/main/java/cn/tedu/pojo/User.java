package cn.tedu.pojo;

/**
 * 用于交给Spring容器管理
 */
public class User {
    private String name = "朱逸群";
    private int age = 25;
    /*Spring容器管理的对象,默认调用的是无参构造,如果没有,则会报错*/
    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "我叫 " + name + ",今年 " + age + " 岁!";
    }
}
