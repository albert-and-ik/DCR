package com.example.dcr.service;

import com.example.dcr.model.dto.CameraDto;
import com.example.dcr.model.dto.DoorDto;

import java.io.IOException;
import java.util.List;

public interface RubetekService {
    List<DoorDto> getDoors() throws IOException;
    List<String> getRooms() throws IOException;
    List<CameraDto> getCameras() throws IOException;

}
