package com.example.mongoblog.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("blog_posts")
public class BlogPost {
    @Id
    private String id;
    private String title;
    private String description;
    private String content;

    public BlogPost() {

    }
    public BlogPost(String title, String description, String content) {
        this.id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
