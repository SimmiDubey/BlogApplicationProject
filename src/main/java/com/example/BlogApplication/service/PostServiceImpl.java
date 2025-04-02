package com.example.BlogApplication.service;

import com.example.BlogApplication.exception.ResourceNotFoundException;
import com.example.BlogApplication.model.Category;
import com.example.BlogApplication.model.Post;
import com.example.BlogApplication.model.User;
import com.example.BlogApplication.payloads.PostDto;
import com.example.BlogApplication.repository.CategoryRepository;
import com.example.BlogApplication.repository.PostRepository;
import com.example.BlogApplication.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public PostDto createPost(PostDto postDto, Long userId, Integer categoryId) {

        User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","user Id",userId));

        Category category =this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","category Id",categoryId));


        Post post = this.modelMapper.map(postDto, Post.class);
        postDto.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
       Post newPost = this.postRepository.save(post);
        return this.modelMapper.map(newPost,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public PostDto getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getAllPost() {
        return List.of();
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {

       Category cat=this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","category id",categoryId));
          List<Post>posts = this.postRepository.findByCategory(cat);
       List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
       return postDtos;
    }



    @Override
    public List<PostDto> getPostsByUser(Long userId) {

        User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","user id",userId);
        List<Post>post=this.postRepository.findByUser(user);
        List<PostDto>postDtos = posts.stream().


        return List.of();
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return List.of();
    }
}
