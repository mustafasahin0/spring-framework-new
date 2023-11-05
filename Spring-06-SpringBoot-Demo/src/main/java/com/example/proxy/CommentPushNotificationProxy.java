package com.example.proxy;

import com.example.entity.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@Qualifier("PUSH")
public class CommentPushNotificationProxy implements CommentNotificationProxy{

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification for comment: " + comment.getText());
    }
}
