package com.example.BlogApplication.repository;

import com.example.BlogApplication.model.Category;
import com.example.BlogApplication.model.Post;
import com.example.BlogApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

}
