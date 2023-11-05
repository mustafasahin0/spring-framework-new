package com.example.repository;


import com.example.entity.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
