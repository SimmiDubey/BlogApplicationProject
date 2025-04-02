package com.example.BlogApplication.payloads;

import com.example.BlogApplication.model.Category;
import com.example.BlogApplication.model.User;

import java.util.Date;

public class PostDto {

    private String title;
    private String content;
    private String imageName;
    private Date addedDate;


    private CategoryDto category;
    private UserDto user;




    public PostDto(String title, String content,CategoryDto category,UserDto user,String imageName,Date addedDate){
        this.title = title;
        this.content = content;
        this.category=category;
        this.user=user;
        this.imageName=imageName;
        this.addedDate=addedDate;
    }



    public PostDto(){

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


    public CategoryDto getCategoryDto() {
        return category;
    }

    public void setCategoryDto(CategoryDto category) {
        this.category = category;
    }

    public UserDto getUserDto() {
        return user;
    }

    public void setUserDto(UserDto user) {
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
}


