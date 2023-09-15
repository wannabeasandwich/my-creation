package cn.tedu;

import cn.tedu.mapper.SubjectMapper;
import cn.tedu.mapper.TeacherMapper;
import cn.tedu.pojo.Subject;
import cn.tedu.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TestSubject {

    @Autowired
    private SubjectMapper subjectMapper;

    @Test
    public void selectTeacherById() {
        Subject subject = subjectMapper.selectSubjectTeacherByName("物理");
        System.out.println(subject);
        List<Teacher> teachers = subject.getTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
}
