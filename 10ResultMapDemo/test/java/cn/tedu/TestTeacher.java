package cn.tedu;

import cn.tedu.mapper.TeacherMapper;
import cn.tedu.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestTeacher {

    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void selectTeacherById() {
        Teacher teacher = teacherMapper.selectTeacherById(1L);
        System.out.println(teacher);
    }

    @Test
    public void selectTeacherById01() {
        Teacher teacher = teacherMapper.selectTeacherById01(10L);
        System.out.println(teacher);
    }

    @Test
    public void selectTeacherSubject() {
        Teacher teacher = teacherMapper.selectTeacherSubject(10L);
        System.out.println("teacher = " + teacher);
        System.out.println("subject = " + teacher.getSubject());
    }
}
