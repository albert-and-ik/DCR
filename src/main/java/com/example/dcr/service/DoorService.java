package com.example.dcr.service;

import com.example.dcr.model.dto.DoorDto;

import java.util.List;

public interface DoorService {
    List<DoorDto> getFavorites();

    void setFavorite(long id, boolean isFavorite);

    void updateOrCreate(List<DoorDto> dtos);
}
