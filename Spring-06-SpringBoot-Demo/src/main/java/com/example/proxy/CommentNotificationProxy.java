package com.example.proxy;

import com.example.entity.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
