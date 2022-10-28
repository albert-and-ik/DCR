package com.example.dcr.controller;

import com.example.dcr.model.dto.DoorDto;
import com.example.dcr.model.dto.ResponseBodyDto;
import com.example.dcr.service.DoorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/doors")
@Tag(name = "Двери", description = "Api для работы с моделью дверь")
@AllArgsConstructor
public class DoorController {

    final DoorService doorService;

    @GetMapping("/favorites")
    @Operation(summary = "Получить все избранные двери", tags = {"Двери"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseBodyDto<List<DoorDto>> getFavoritesDoors() {
        return ResponseBodyDto.getTrueSuccess(doorService.getFavorites());
    }

    @PatchMapping("/{id}/setFavorite")
    @Operation(summary = "Сделать дверь избранной", tags = {"Двери"})
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus changeFavorite(
            @PathVariable
            @Positive
            long id
    ) {
        doorService.setFavorite(id, true);

        return HttpStatus.OK;
    }
}