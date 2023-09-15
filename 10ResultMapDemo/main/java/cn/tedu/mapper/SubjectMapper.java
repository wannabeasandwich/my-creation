package cn.tedu.mapper;

import cn.tedu.pojo.Subject;
import org.apache.ibatis.annotations.Mapper;

//指定这是一个操作数据库的mapper
@Mapper
public interface SubjectMapper {
    public Subject selectSubjectTeacherByName(String name);
}
