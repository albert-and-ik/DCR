package com.example.dcr.model.dto;

import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class ResponseBodyDto<T> {
    @NonNull final boolean success;
    final T data;

    public static <T> ResponseBodyDto<T> getTrueSuccess(T data){
        return new ResponseBodyDto<>(true, data);
    }

    public static <T> ResponseBodyDto<T> getFalseSuccess(T data){
        return new ResponseBodyDto<>(false, data);
    }
}
