package com.example.BlogApplication.service;

import com.example.BlogApplication.model.Post;
import com.example.BlogApplication.payloads.PostDto;

import java.util.List;

public interface PostService{

    //create

    PostDto createPost(PostDto postDto,Long userId,Integer categoryId);

    //update

    PostDto updatePost(PostDto postDto,Integer postId);

    //delete

   void deletePost(Integer postId);

    //get
    PostDto getPostById(Integer postId);

    //getAll
    List<PostDto> getAllPost();

    //get All post by category

    List<PostDto> getPostsByCategory(Integer categoryId);
    //get all post by user

    List<PostDto> getPostsByUser(Long userId);

    // search post
    List<PostDto> searchPosts(String keyword);

}

