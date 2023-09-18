package com.example.repository;

import org.springframework.stereotype.Component;

@Component
public class RegularHours implements HoursRepository {

    @Override
    public int getHours() {
        return 40;
    }
}
