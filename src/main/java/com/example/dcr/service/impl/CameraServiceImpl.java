package com.example.dcr.service.impl;

import com.example.dcr.model.dto.CameraDto;
import com.example.dcr.model.entity.CameraEntity;
import com.example.dcr.repository.CameraRepository;
import com.example.dcr.service.CameraService;
import com.example.dcr.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class CameraServiceImpl implements CameraService {

    final CameraRepository cameraRepository;
    final RoomService roomService;

    @Override
    @Transactional(readOnly = true)
    public List<CameraDto> getFavorites() {
        return cameraRepository
                .getCameraEntitiesByFavorites(true)
                .stream()
                .map(CameraDto::toDto)
                .toList();
    }

    @Override
    @Transactional
    public void setFavorite(@Positive long id, boolean isFavorite) {
        CameraEntity entity = cameraRepository
                .findById(id)
                .orElseThrow();

        entity.setFavorites(isFavorite);

        cameraRepository.save(entity);
    }

    @Override
    @Transactional
    public void setRec(@Positive long id, boolean isRec) {
        CameraEntity entity = cameraRepository
                .findById(id)
                .orElseThrow();

        entity.setRec(isRec);

        cameraRepository.save(entity);

    }

    @Override
    @Transactional(readOnly = true)
    public List<CameraDto> getCamerasFromRoom(@NotBlank String name) {
        return cameraRepository
                .getCameraEntitiesByRoomName(name)
                .stream()
                .map(CameraDto::toDto)
                .toList();
    }

    @Override
    @Transactional
    public void updateOrCreate(@NotEmpty List<CameraDto> dtos) {

        LocalDateTime updateTime = LocalDateTime.now();

        var listEntities = dtos
                .stream()
                .map(dto -> {
                    var cameraEntity = dto.toEntity();

                    if(cameraRepository.existsById(Long.parseLong(dto.getId()))) {
                        cameraEntity.setFavorites(null);
                        cameraEntity.setRec(null);
                    }

                    cameraEntity.setRoom(roomService.getRoomByNameOrCreate(dto.getRoom()));

                    cameraEntity.setUpdatedAt(updateTime);

                    return cameraEntity;
                })
                .toList();

        cameraRepository.saveAll(listEntities);

    }
}
