package com.example.dcr.service.impl;

import com.example.dcr.config.mapper.CameraMapper;
import com.example.dcr.model.dto.CameraDto;
import com.example.dcr.model.entity.CameraEntity;
import com.example.dcr.repository.CameraRepository;
import com.example.dcr.service.CameraService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CameraServiceImpl implements CameraService {

    final CameraRepository cameraRepository;
    final CameraMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<CameraDto> getFavorites() {
        return cameraRepository
                .getCameraEntitiesByFavoritesIsTrue()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public void setFavorite(long id, boolean isFavorite) {
        CameraEntity entity = cameraRepository
                .findById(id)
                .orElseThrow();

        entity.setFavorites(isFavorite);

        cameraRepository.save(entity);
    }

    @Override
    @Transactional
    public void setRec(long id, boolean isRec) {
        CameraEntity entity = cameraRepository
                .findById(id)
                .orElseThrow();

        entity.setRec(isRec);

        cameraRepository.save(entity);

    }
}
