package com.amiya.jwt.Exceptions;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private Object data;
    private String message;
    private boolean error = true;

    public ApiResponse(Object data, String message){
        this.data = data;
        this.message = message;
    }
}
