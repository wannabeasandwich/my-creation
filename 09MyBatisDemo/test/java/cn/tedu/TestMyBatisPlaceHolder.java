package cn.tedu;

import cn.tedu.mapper.StudentMapper;
import cn.tedu.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TestMyBatisPlaceHolder {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void selectStudentById() {
        Student student = studentMapper.selectStudentById(2L);
        System.out.println(student);
    }

    @Test
    public void selectStudentByJobAndGender() {
        List<Student> students = studentMapper.selectStudentByJobAndGender("语文课代表", "男");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void selectStudentByBirth() {
        //查询2015年5月份的学生
        List<Student> students = studentMapper.selectStudentByBirth("2015-4-30", "2015-6-1");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
