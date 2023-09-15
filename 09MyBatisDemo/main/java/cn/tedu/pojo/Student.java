package cn.tedu.pojo;


import java.util.Date;

public class Student {
    private long id;
    private String name;
    private long age;
    private String gender;
    private String job;
    private Date birth;
    private long locationId;
    private long teamLeader;
    private long classId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }


    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }


    public long getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(long teamLeader) {
        this.teamLeader = teamLeader;
    }


    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                ", birth=" + birth +
                ", locationId=" + locationId +
                ", teamLeader=" + teamLeader +
                ", classId=" + classId +
                '}';
    }
}
