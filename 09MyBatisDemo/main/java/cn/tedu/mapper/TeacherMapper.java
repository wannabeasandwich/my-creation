package cn.tedu.mapper;

import cn.tedu.pojo.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 定义操作teacher表的接口,其中定义的接口方法用于绑定操作teacher表的SQL语句
 * 接口中的方法定义的规范:
 * ①方法名见名知意,要和绑定的SQL语句有类似的含义
 * ②返回值,要根据情况选择:
 * 1)执行的SQL没有结果,返回值是void即可
 * 2)执行的SQL返回操作的记录数,返回值是int即可
 * 3)执行的SQL返回查询的一条记录,返回值是对应的表的实体类
 * 4)执行的SQL返回查询的多条记录,返回值是对应的实体类的集合(泛型是实体类的集合)
 */
@Mapper //表明当前接口是一个操作数据库的Mapper
//@Component
public interface TeacherMapper {
    @Select("SELECT * FROM teacher") //将该SQL绑定到下面的接口方法上
    public List<Teacher> getTeacherAll();

    @Insert("INSERT INTO teacher(id, name, age, title, manager, salary, comm, gender, subject_id) VALUES (1234,'马师傅',18,'宗师',null,10000,50,'男',null);")
    public int insetTeacher();

    @Update("UPDATE teacher SET salary = 1000 WHERE name = '马师傅'")
    public int updateTeacher();

    @Delete("DELETE FROM teacher WHERE name = '马师傅'")
    public int deleteTeacher();
}
