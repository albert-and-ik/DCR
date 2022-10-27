package com.example.dcr.mapper;

import com.example.dcr.model.dto.CameraDto;
import com.example.dcr.model.dto.DoorDto;
import com.example.dcr.model.dto.RoomDto;
import com.example.dcr.model.entity.CameraEntity;
import com.example.dcr.model.entity.DoorEntity;
import com.example.dcr.model.entity.RoomEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntityMapper {

    DoorDto toDto(DoorEntity doorEntity);
    RoomDto toDto(RoomEntity roomEntity);
    CameraDto toDto(CameraEntity cameraEntity);


    DoorEntity toEntity(DoorDto doorDto);
    RoomEntity toEntity(RoomDto roomDto);
    CameraEntity toEntity(CameraDto cameraDto);
}
