package com.example.proxy;

import com.example.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
