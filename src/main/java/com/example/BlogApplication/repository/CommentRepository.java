package com.example.BlogApplication.repository;

import com.example.BlogApplication.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
