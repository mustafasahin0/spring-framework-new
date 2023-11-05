package com.example.proxy;

import com.example.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class EmailCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification for comment: " + comment.getText());
    }
}
