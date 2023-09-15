package cn.tedu;

import cn.tedu.mapper.StudentMapper;
import cn.tedu.mapper.TeacherMapper;
import cn.tedu.pojo.Student;
import cn.tedu.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class TestMyBatisXML {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void selectStudent() {
        List<Student> list = studentMapper.selectStudent();
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void insertStudent() {
        int rows = studentMapper.insertStudent();
        System.out.println(rows > 0 ? "成功!" : "失败!");
    }
    @Test
    public void insertStudent01() {
        Student student = new Student();
        student.setId(7777);
        student.setName("沙和尚");
        student.setAge(1000);
        student.setGender("男");
        student.setJob("搬家大队长");
        student.setBirth(null);
        student.setLocationId(0);
        student.setClassId(0);
        student.setTeamLeader(0);
        int rows = studentMapper.insertStudent01(student);
        System.out.println(rows > 0 ? "成功!" : "失败!");
    }
    @Test
    public void updateStudent() {
        int rows = studentMapper.updateStudent();
        System.out.println(rows > 0 ? "成功!" : "失败!");
    }
    @Test
    public void updateStudent01() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "沙和尚");
        map.put("job", "沙帅哥");
        int rows = studentMapper.updateStudent01(map);
        System.out.println(rows > 0 ? "成功!" : "失败!");
    }
    @Test
    public void deleteStudent() {
        int rows = studentMapper.deleteStudent();
        System.out.println(rows > 0 ? "成功!" : "失败!");
    }
    @Test
    public void deleteStudent02() {
        int rows = studentMapper.deleteStudent02("沙和尚");
        System.out.println(rows > 0 ? "成功!" : "失败!");
    }
}
