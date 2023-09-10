package com.example.repository;


import com.example.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
