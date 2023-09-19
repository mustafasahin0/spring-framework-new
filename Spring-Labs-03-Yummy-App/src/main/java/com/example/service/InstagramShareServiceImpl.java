package com.example.service;

import org.springframework.stereotype.Component;

@Component
public class InstagramShareServiceImpl implements ShareService{

    @Override
    public void share() {
        System.out.println("Sharing on Instagram");
    }
}
