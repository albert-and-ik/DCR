package com.example.dcr.controller;

import com.example.dcr.model.dto.CameraDto;
import com.example.dcr.model.dto.ResponseBodyDto;
import com.example.dcr.service.CameraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/cameras")
@AllArgsConstructor
@Tag(name="Камеры", description = "Api для работы с камерами")
public class CameraController {
    final CameraService cameraService;

    @GetMapping("/favorites")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить все избранные камеры", tags = {"Камеры"})
    public ResponseBodyDto<List<CameraDto>> getFavorites(){
        return ResponseBodyDto.getTrueSuccess(cameraService.getFavorites());
    }

    @PatchMapping("/{id}/setFavorite")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Отметить кам избранной", tags = {"Камеры"})
    public HttpStatus setFavorite(
            @PathVariable
            @Positive
            long id
    ) {
        cameraService.setFavorite(id, true);

        return HttpStatus.OK;
    }

    @PatchMapping("/{id}/rec")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Запись камеры вкл/выкл", tags = {"Камеры"})
    public HttpStatus setRec(
            @PathVariable
            @Positive
            long id,

            @RequestParam
            @Parameter(description = "Управление записью")
            boolean isRec
    ) {
        cameraService.setRec(id, isRec);

        return HttpStatus.OK;
    }

}