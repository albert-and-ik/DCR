package com.example.dcr.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoomCameraDataDto {
    List<String> room;
    List<CameraDto> cameras;
}
