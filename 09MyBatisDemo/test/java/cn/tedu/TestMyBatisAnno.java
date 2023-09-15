package cn.tedu;

import cn.tedu.mapper.TeacherMapper;
import cn.tedu.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TestMyBatisAnno {
    @Autowired
    private TeacherMapper teacherMapper;//这个报错,是idea的误报

    @Test
    public void getTeacherAll() {
        List<Teacher> list = teacherMapper.getTeacherAll();
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }

    @Test
    public void insetTeacher() {
        int rows = teacherMapper.insetTeacher();
        System.out.println(rows > 0 ? "新增成功!" : "新增失败!");
    }

    @Test
    public void updateTeacher() {
        int rows = teacherMapper.updateTeacher();
        System.out.println(rows > 0 ? "修改成功!" : "修改失败!");
    }

    @Test
    public void deleteTeacher() {
        int rows = teacherMapper.deleteTeacher();
        System.out.println(rows > 0 ? "删除成功!" : "删除失败!");
    }
}
