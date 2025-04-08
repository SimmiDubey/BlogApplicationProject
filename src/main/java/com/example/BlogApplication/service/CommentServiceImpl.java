package com.example.BlogApplication.service;

import com.example.BlogApplication.exception.ResourceNotFoundException;
import com.example.BlogApplication.model.Comment;
import com.example.BlogApplication.model.Post;
import com.example.BlogApplication.payloads.CommentDto;
import com.example.BlogApplication.repository.CommentRepository;
import com.example.BlogApplication.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {

        Post post= this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","postId",postId));
      Comment comment =  this.modelMapper.map(commentDto, Comment.class);

      comment.setPost(post);
      Comment savedComment = this.commentRepository.save(comment);
      return this.modelMapper.map(savedComment,CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment com = this.commentRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment","Comment Id",commentId));
        this.commentRepository.deleteById(commentId);


    }
}
