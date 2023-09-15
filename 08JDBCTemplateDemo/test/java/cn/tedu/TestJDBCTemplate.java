package cn.tedu;

import cn.tedu.pojo.Classes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

@SpringBootTest
public class TestJDBCTemplate {
    //注入JDBCTemplate工具实例
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * JDBCTemplate入门案例
     */
    @Test
    public void test01() {
        //无须获取连接,JDBCTemplate会自动在HikariCP连接池中获取连接
        //1.定义SQL
        String sql = "INSERT INTO class (name, floor, teacher_id) VALUES ('无敌班', 9, 99)";
        //无须获取传输器,JDBCTemplate会自动创建传输器
        //2.调用update执行SQL
        /**
         * update() 用于执行增删改的SQL语句,并且执行后,会返回修改的记录数
         * execute() 用于执行增删改的SQL语句,但是执行后,不会返回任何值
         */
        int rows = jdbcTemplate.update(sql);
        System.out.println(rows > 0 ? "新增成功!" : "新增失败!");
        //无须释放资源,JDBCTemplate会自动释放资源
    }

    @Test
    public void testQueryForList() {
        //1.定义SQL
        String sql = "SELECT id, name, floor, teacher_id FROM class";
        //2.调用queryForList执行SQL
        /**
         * List<Map<String, Object>> queryForList(String sql, Object... args)
         * 参数1: 要执行的sql
         * 参数2: 要传入的参数值,可以传入无限个,传参的顺序要和SQL骨架中的"?"顺序一致
         * 返回值: 是一个List集合,其中泛型约束只允许该集合装Map,并且该Map的key是String类型,value是Object类型
         * 该方法可以将查询的多条记录,每一条记录封装到一个Map实例中,并且将多个Map实例封装到List中
         */
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        //3.遍历记过,输出所有记录
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

    @Test
    public void testQueryForMap() {
        //1.定义SQL
        String sql = "SELECT id, name, floor, teacher_id FROM class WHERE name = ?";
        //2.调用queryForMap执行SQL
        /**
         * Map<String, Object> queryForMap(String sql, Object... args)
         * 参数1: 要执行的sql
         * 参数2: 要传入的参数值,可以传入无限个,传参的顺序要和SQL骨架中的"?"顺序一致
         * 执行传入的sql,并将参数绑定到占位符位置
         * 返回值: 泛型key是String,value是Object的Map集合
         * 会自动将查询的结果中的列名作为key,值作为value存储到集合中
         */
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, "无敌班");
        //3.输出结果
        System.out.println(map);
        //试着遍历map输出
        map.forEach((k, v) -> System.out.println(k + "\t" + v));
    }

    @Test
    public void testQuery() {
        //1.定义SQL
        String sql = "SELECT id, name, floor, teacher_id FROM class WHERE name LIKE ?";
        //2.执行SQL语句,指定将结果集封装到对应的实体类中,并且传入对应的参数
//        List<Classes> list = jdbcTemplate.query(sql, new RowMapper<Classes>() {
//            @Override
//            public Classes mapRow(ResultSet rs, int i) throws SQLException {
//                Classes classes = new Classes();
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                int floor = rs.getInt("floor");
//                int teacher_id = rs.getInt("teacher_id");
//                classes.setId(id);
//                classes.setName(name);
//                classes.setFloor(floor);
//                classes.setTeacherId(teacher_id);
//                return classes;
//            }
//        },"3%");
        /**
         * BeanPropertyRowMapper是RowMapper的实现类,可以进行自动映射
         * 需要在创建BeanPropertyRowMapper时,指定要映射的实体类的字节码实例
         */
        List<Classes> list =
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Classes.class), "3%");
        //3.遍历记过,输出所有记录
        for (Classes classes : list) {
            System.out.println(classes);
        }
    }

    @Test
    public void testQueryForObject() {
        //1.定义SQL
        String sql = "SELECT COUNT(*) FROM class";
        //2.执行SQL语句,指定将结果集封装到对应的实体类中,并且传入对应的参数
        Integer rows = jdbcTemplate.queryForObject(sql, Integer.class);
        //3.输出查询总记录数
        System.out.println(rows);
    }

    @Test
    public void testAdd() {
        //1.定义SQL
        String sql = "INSERT INTO class (name, floor, teacher_id) VALUES (?,?,?)";
        //2.将参数以数组的形式封装
        //只适合少量参数时,可以使用update直接传参
        //int rows = jdbcTemplate.update(sql, "帅哥班", 99, 000);
        //适合参数较多时,可以将参数绑定为一个整体,传递
        Object[] args = {"美女班", 99, 000};
        int rows = jdbcTemplate.update(sql, args);
        System.out.println(rows > 0 ? "新增成功!" : "新增失败!");
    }

    @Test
    void testUpdate() {
        //1.定义SQL
        String sql = "UPDATE class SET name = ?,floor = ?,teacher_id = ? WHERE id = ?";
        //2.将参数封装为数组
        Object[] args = {"帅哥美女班", true, 100, 24};
        int rows = jdbcTemplate.update(sql, args);
        System.out.println(rows > 0 ? "修改成功!" : "修改失败!");
    }
}
