package cn.tedu.pojo;

import java.util.Date;
import java.util.List;

public class Users {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_users.id
     *
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_users.username
     *
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_users.nickname
     *
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_users.password
     *
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_users.mobile
     *
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_users.status
     *
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_users.created_time
     *
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_users.modified_time
     *
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    private Date modifiedTime;
    private List<Articles> articles;

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_users.id
     *
     * @return the value of tb_users.id
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_users.id
     *
     * @param id the value for tb_users.id
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_users.username
     *
     * @return the value of tb_users.username
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_users.username
     *
     * @param username the value for tb_users.username
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_users.nickname
     *
     * @return the value of tb_users.nickname
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_users.nickname
     *
     * @param nickname the value for tb_users.nickname
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_users.password
     *
     * @return the value of tb_users.password
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_users.password
     *
     * @param password the value for tb_users.password
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_users.mobile
     *
     * @return the value of tb_users.mobile
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_users.mobile
     *
     * @param mobile the value for tb_users.mobile
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_users.status
     *
     * @return the value of tb_users.status
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_users.status
     *
     * @param status the value for tb_users.status
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_users.created_time
     *
     * @return the value of tb_users.created_time
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_users.created_time
     *
     * @param createdTime the value for tb_users.created_time
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_users.modified_time
     *
     * @return the value of tb_users.modified_time
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_users.modified_time
     *
     * @param modifiedTime the value for tb_users.modified_time
     * @mbggenerated Thu Jul 06 19:51:10 CST 2023
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status=" + status +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}