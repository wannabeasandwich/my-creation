package cn.tedu.pojo;

/**
 * 声明tedu库中teacher表的实体类
 * 1.遵循规则:
 * ①类名和表名最好一致
 * ②类中的属性和表中的字段保持一致(属性名和字段名、属性类型和字段类型)
 * ③都要遵循驼峰规则(表中字段如果是subject_id → 属性名则为subjectId)
 * ④生成属性的get、set和toString方法
 * <p>
 * 2.数据库字段类型和属性类型的对应关系:
 * ①int、bigint对应int、long、Integer、Long
 * ②varchar、char对应String
 * ③double、float对应double、float、Double、Float
 * ④date、time、datetime对应Date
 */
public class Teacher {
    private Integer id;
    private String name;
    private Integer age;
    private String title;
    private Integer manager;
    private Integer salary;
    private Integer comm;
    private String gender;
    private Integer subjectId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getComm() {
        return comm;
    }

    public void setComm(Integer comm) {
        this.comm = comm;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", title='" + title + '\'' +
                ", manager=" + manager +
                ", salary=" + salary +
                ", comm=" + comm +
                ", gender='" + gender + '\'' +
                ", subjectId=" + subjectId +
                '}';
    }
}
