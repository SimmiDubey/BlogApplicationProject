package com.example.BlogApplication.service;


import com.example.BlogApplication.payloads.CommentDto;

public interface CommentService {

    //create

     CommentDto createComment(CommentDto commentDto,Integer postId);


     //delete

      void deleteComment(Integer commentId);

}
