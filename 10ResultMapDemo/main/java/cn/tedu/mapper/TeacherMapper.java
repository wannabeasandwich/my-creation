package cn.tedu.mapper;

import cn.tedu.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

//指定这是一个操作数据库的mapper
@Mapper
public interface TeacherMapper {
    public Teacher selectTeacherById(Long id);

    public Teacher selectTeacherById01(Long id);

    public Teacher selectTeacherSubject(Long id);
}
