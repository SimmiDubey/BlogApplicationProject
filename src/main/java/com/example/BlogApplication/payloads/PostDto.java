package com.example.BlogApplication.payloads;

import com.example.BlogApplication.model.Comment;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PostDto {

    private String title;
    private String content;
    private String imageName;
    private Date addedDate;

    private CategoryDto category;
    private UserDto user;

    private Set<CommentDto>comments = new HashSet<>();

    public PostDto(String title, String content, CategoryDto category,
                   UserDto user, String imageName, Date addedDate) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.user = user;
        this.imageName = imageName;
        this.addedDate = addedDate;

    }

    public PostDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Set<CommentDto> getComments() {
        return comments;
    }

    public void setComments(Set<CommentDto> comments) {
        this.comments = comments;
    }
}
