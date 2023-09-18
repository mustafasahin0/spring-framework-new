package com.example.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("OTH")
public class OvertimeHours implements HoursRepository{

    @Override
    public int getHours() {
        return 20;
    }
}
