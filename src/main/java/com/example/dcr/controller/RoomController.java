package com.example.dcr.controller;


import com.example.dcr.model.dto.CameraDto;
import com.example.dcr.model.dto.DoorDto;
import com.example.dcr.model.dto.RoomDto;
import com.example.dcr.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@Tag(name = "Комнаты", description = "API для работы с комнатами")
@AllArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    final RoomService roomService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить все комнаты", tags = {"Комнаты"})
    public List<RoomDto> getAll() {
        return roomService.getAll();
    }

    @GetMapping("/{id}/cameras")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить все камеры в комнате", tags = {"Комнаты"})
    public List<CameraDto> getCamerasFromRoom(
            @PathVariable
            @Positive
            long id
    ) {
        return roomService.getCamerasFromRoom(id);
    }

    @GetMapping("/{id}/doors")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить все двери в комнате", tags = {"Комнаты"})
    public List<DoorDto> getDoorsFromRoom(
            @PathVariable
            @Positive
            long id
    ) {
        return roomService.getDoorsFromRoom(id);
    }

}