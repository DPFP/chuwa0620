package com.chuwa.redbook_mongoDB.model;


import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;


@Document("posts")
public class Post {

    @Id
    private long id;
    private String title;
    private String description;
    private String content;

    public Post(){

    }

    public Post(long id, String title, String description, String content, LocalDateTime createdDateTime, LocalDateTime updateDateTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.createdDateTime = createdDateTime;
        this.updateDateTime = updateDateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    @CreationTimestamp
    private LocalDateTime createdDateTime;
    @CreationTimestamp
    private LocalDateTime updateDateTime;

}
