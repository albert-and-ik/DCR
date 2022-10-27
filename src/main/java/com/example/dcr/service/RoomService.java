package com.example.dcr.service;

import com.example.dcr.model.dto.CameraDto;
import com.example.dcr.model.dto.DoorDto;
import com.example.dcr.model.dto.RoomDto;

import java.util.List;

public interface RoomService {
    List<RoomDto> getAll();

    List<CameraDto> getCamerasFromRoom(long id);

    List<DoorDto> getDoorsFromRoom(long id);

    void updateOrCreate(List<String> names);

    long getRoomByNameOrCreate(String name);
}
