package com.example.BlogApplication.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserDto {
    private long id;

    @NotEmpty
    @Size(min = 4,message = "User must be min of 4 character !!")

    private String name;

    @Email(message = "Email address is not valid!!")
    private String email;
    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be min of 3 chars and max of 10 chars!!")
    private String password;

    @NotEmpty
    @Size(min=5,max = 50,message = "About must be min of 5 chars and max of 50 chars!!")

    private String about;

    public UserDto(long id,String name,String email,String password,String about){
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
        this.about=about;

    }

    public UserDto() {

    }

    public long getId() {

        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
