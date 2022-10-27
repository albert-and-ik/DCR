package com.example.dcr.service;

import com.example.dcr.model.dto.CameraDto;
import com.example.dcr.model.entity.CameraEntity;

import java.util.List;
import java.util.stream.Stream;

public interface CameraService {
    Stream<CameraEntity> getFavorites();

    void setFavorite(long id, boolean isFavorite);

    void setRec(long id, boolean isRec);

    void updateOrCreate(List<CameraDto> dtos);
}
