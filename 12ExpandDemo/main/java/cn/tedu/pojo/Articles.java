package cn.tedu.pojo;

import java.util.Date;

public class Articles {
    private Long id;

    private String title;

    private String type;

    private String content;

    private String status;

    private Long userId;

    private Date createdTime;

    private Date modifiedTime;

    public Long getId() {
        return id;
    }

    public Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_articles.title
     *
     * @param title the value for tb_articles.title
     * @mbggenerated Tue Jul 04 21:12:38 CST 2023
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_articles.TYPE
     *
     * @return the value of tb_articles.TYPE
     * @mbggenerated Tue Jul 04 21:12:38 CST 2023
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_articles.TYPE
     *
     * @param type the value for tb_articles.TYPE
     * @mbggenerated Tue Jul 04 21:12:38 CST 2023
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_articles.content
     *
     * @return the value of tb_articles.content
     * @mbggenerated Tue Jul 04 21:12:38 CST 2023
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_articles.content
     *
     * @param content the value for tb_articles.content
     * @mbggenerated Tue Jul 04 21:12:38 CST 2023
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_articles.STATUS
     *
     * @return the value of tb_articles.STATUS
     * @mbggenerated Tue Jul 04 21:12:38 CST 2023
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_articles.STATUS
     *
     * @param status the value for tb_articles.STATUS
     * @mbggenerated Tue Jul 04 21:12:38 CST 2023
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_articles.user_id
     *
     * @return the value of tb_articles.user_id
     * @mbggenerated Tue Jul 04 21:12:38 CST 2023
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_articles.user_id
     *
     * @param userId the value for tb_articles.user_id
     * @mbggenerated Tue Jul 04 21:12:38 CST 2023
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_articles.created_time
     *
     * @return the value of tb_articles.created_time
     * @mbggenerated Tue Jul 04 21:12:38 CST 2023
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_articles.created_time
     *
     * @param createdTime the value for tb_articles.created_time
     * @mbggenerated Tue Jul 04 21:12:38 CST 2023
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_articles.modified_time
     *
     * @return the value of tb_articles.modified_time
     * @mbggenerated Tue Jul 04 21:12:38 CST 2023
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_articles.modified_time
     *
     * @param modifiedTime the value for tb_articles.modified_time
     * @mbggenerated Tue Jul 04 21:12:38 CST 2023
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}