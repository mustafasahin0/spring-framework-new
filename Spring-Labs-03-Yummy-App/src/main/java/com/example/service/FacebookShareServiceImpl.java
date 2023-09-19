package com.example.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FacebookShareServiceImpl implements ShareService{

    @Override
    public void share() {
        System.out.println("Sharing on Facebook");
    }
}
