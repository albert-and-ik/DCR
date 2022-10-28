package com.example.dcr.model.dto;

import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class ResponseBodyDto<T> {
    @NonNull final boolean success;
    final T data;
}
