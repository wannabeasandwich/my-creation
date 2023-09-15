package cn.tedu.pojo;


public class Teacher {
    private Long id;
    private String name;
    private Long age;
    private String title;
    private Long manager;
    private Long salary;
    private Long comm;
    private String gender;
    private Long subjectId;
    //封装老师所授科目的信息
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Long getManager() {
        return manager;
    }

    public void setManager(Long manager) {
        this.manager = manager;
    }


    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }


    public Long getComm() {
        return comm;
    }

    public void setComm(Long comm) {
        this.comm = comm;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
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
                ", subject=" + subject +
                '}';
    }
}
