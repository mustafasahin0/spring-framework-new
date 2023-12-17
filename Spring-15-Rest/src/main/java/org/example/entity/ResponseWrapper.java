package org.example.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dto.CourseDTO;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {

    private boolean success;
    private String message;
    private Integer code;
    private  Object data;

    public ResponseWrapper(boolean success, String message, Integer code, Object data) {
        this.success = success;
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.data = data;
    }

    public ResponseWrapper(String message, Object data) {
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.success = true;
        this.data = data;
    }
}
