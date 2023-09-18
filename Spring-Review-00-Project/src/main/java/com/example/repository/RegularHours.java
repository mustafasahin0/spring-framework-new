package com.example.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RegularHours implements HoursRepository {

    @Override
    public int getHours() {
        return 40;
    }
}
