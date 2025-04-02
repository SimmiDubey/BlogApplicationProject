package com.example.BlogApplication.controller;

import com.example.BlogApplication.model.Post;
import com.example.BlogApplication.payloads.PostDto;
import com.example.BlogApplication.service.PostService;
import com.example.BlogApplication.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    //create

  @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto>createPost(@RequestBody PostDto postDto,
                                             @PathVariable Long userId,
                                             @PathVariable Integer categoryId){

      PostDto createPost=this.postService.createPost(postDto,userId,categoryId);

     return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }

}
