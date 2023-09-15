package cn.tedu.pojo;

import java.io.Serializable;

/**
 * 该类用于定义封装结果的javaBean
 * java中bean表示的就是一种特殊的java类,用于封装数据的实体类,一般都可以称为bean
 * 我们二阶段,主要使用实体类的作用就是用于封装通过第三方技术,封装表中信息作用
 * 合格的实体类要求如下:
 * ①属性名要和表中的字段保持一致,还要符合驼峰规则
 * 比如: 数据库字段teacher_id 不区分大小写,所以使用_的方式表示i是大写
 * 实体类中对应的属性,则应该按照java的驼峰规则定义,teacherId
 * ②属性要私有
 * ③提供属性对应的get和set方法
 * ④必须类中提供无参构造
 */
public class Classes {
    private Integer id;
    private String name;
    private Integer floor;
    private Integer teacherId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", floor=" + floor +
                ", teacherId=" + teacherId +
                '}';
    }
}
