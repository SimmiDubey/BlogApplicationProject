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
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import com.example.BlogApplication.payloads.PostResponse;

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
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
       Post newPost = this.postRepository.save(post);
        return this.modelMapper.map(newPost,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
     Post post= this.postRepository.findById(postId)
               .orElseThrow(()-> new ResourceNotFoundException("Post","postId",postId));
           post.setTitle(postDto.getTitle());
           post.setContent(postDto.getContent());
           post.setImageName(postDto.getImageName());
           Post updatedPost=this.postRepository.save(post);
        return this.modelMapper.map(updatedPost,PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
       Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","postId",postId));
        this.postRepository.delete(post);

    }

  //getPost
    @Override
    public PostDto getPostById(Integer postId) {
        Post post=this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","post id",postId));
        return this.modelMapper.map(post,PostDto.class);
    }

    //getAllPost
    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize) {
        Pageable p = PageRequest.of(pageNumber, pageSize);
        Page<Post> pagePost = this.postRepository.findAll(p);
        List<Post> allPosts = pagePost.getContent();
        List<PostDto>postDto = allPosts.stream().map((post)-> this.modelMapper.map(post,PostDto.class))
                .collect(Collectors.toList());

        PostResponse postResponse=new PostResponse();
        postResponse.setContent(postDto);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getTotalElements());
        postResponse.setLastPage(pagePost.isLast());

         return postResponse;
//        allPosts.stream()
//
//                .map(post -> this.modelMapper.map(post, PostDto.class))
//                .collect(Collectors.toList());
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

        User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","user id",userId));
        List<Post>posts = this.postRepository.findByUser(user);
        List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;

    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        List<Post>posts = this.postRepository.searchByTitle("%" + keyword + "%");
        List<PostDto>postDto = posts.stream().map((post)->this.modelMapper.map(post,PostDto.class))
                 .collect(Collectors.toList());
        return postDto;
    }
}
