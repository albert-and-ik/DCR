package com.example.dcr.controller;


import com.example.dcr.model.dto.CameraDto;
import com.example.dcr.model.dto.DoorDto;
import com.example.dcr.model.dto.ResponseBodyDto;
import com.example.dcr.model.dto.RoomDto;
import com.example.dcr.service.CameraService;
import com.example.dcr.service.DoorService;
import com.example.dcr.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@Tag(name = "Комнаты", description = "API для работы с комнатами")
@AllArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    final RoomService roomService;
    final CameraService cameraService;
    final DoorService doorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить все комнаты", tags = {"Комнаты"})
    public ResponseBodyDto<List<RoomDto>> getAll() {
        return ResponseBodyDto.getTrueSuccess(roomService.getAll());
    }

    @GetMapping("/{name}/cameras")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить все камеры в комнате", tags = {"Комнаты"})
    public ResponseBodyDto<List<CameraDto>> getCamerasFromRoom(
            @PathVariable
            @NotBlank
            String name
    ) {
        return ResponseBodyDto.getTrueSuccess(cameraService.getCamerasFromRoom(name));
    }

    @GetMapping("/{name}/doors")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить все двери в комнате", tags = {"Комнаты"})
    public ResponseBodyDto<List<DoorDto>> getDoorsFromRoom(
            @PathVariable
            @NotBlank
            String name
    ) {
        return ResponseBodyDto.getTrueSuccess(doorService.getDoorByRoomName(name));
    }

}