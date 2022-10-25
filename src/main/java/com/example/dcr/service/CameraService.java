package com.example.dcr.service;

import com.example.dcr.model.dto.CameraDto;

import java.util.List;

public interface CameraService {
    List<CameraDto> getFavorites();

    void setFavorite(long id, boolean isFavorite);

    void setRec(long id, boolean isRec);
}
