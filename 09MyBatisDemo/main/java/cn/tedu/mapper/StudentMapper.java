package cn.tedu.mapper;

import cn.tedu.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 定义操作teacher表的接口,其中定义的接口方法用于绑定操作teacher表的SQL语句
 * 接口中的方法定义的规范:
 * ①方法名见名知意,要和绑定的SQL语句有类似的含义
 * ②返回值,要根据情况选择:
 * 1)执行的SQL没有结果,返回值是void即可
 * 2)执行的SQL返回操作的记录数,返回值是int即可
 * 3)执行的SQL返回查询的一条记录,返回值是对应的表的实体类
 * 4)执行的SQL返回查询的多条记录,返回值是对应的实体类的集合(泛型是实体类的集合)
 * ③参数,根据绑定SQL语句所需的参数来选择
 * 1)参数类型一定要传入的占位符所需参数的类型一致(不过MyBatis对于日期类型,会自动转义)
 * 2)参数名: 分情况考虑
 * a. SQL语句只有一个占位符时,参数名可以起任意值,但是建议和占位符名字一致
 * b. SQL语句有多个占位符时,参数名必须要和占位符的名字一致
 */
@Mapper
public interface StudentMapper {

    public int insertStudent();

    public int insertStudent01(Student student);

    public int updateStudent();

    public int updateStudent01(Map<String,Object> map);

    public int deleteStudent();

    @Delete("DELETE FROM student WHERE name = #{name}")
    public int deleteStudent02(String name);

    public List<Student> selectStudent();

    public Student selectStudentById(Long id);

    public List<Student> selectStudentByJobAndGender(String job, String gender);

    public List<Student> selectStudentByBirth(String minBirth, String maxBirth);
}
