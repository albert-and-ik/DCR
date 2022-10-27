package com.example.dcr.service;

import com.example.dcr.model.dto.RoomDto;
import com.example.dcr.model.entity.RoomEntity;

import java.util.List;

public interface RoomService {
    List<RoomDto> getAll();

    void updateOrCreate(List<String> names);

    RoomEntity getRoomByNameOrCreate(String name);
}
