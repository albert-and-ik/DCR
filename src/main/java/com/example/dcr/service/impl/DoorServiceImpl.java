package com.example.dcr.service.impl;

import com.example.dcr.config.mapper.DoorMapper;
import com.example.dcr.model.dto.DoorDto;
import com.example.dcr.model.entity.DoorEntity;
import com.example.dcr.repository.DoorRepository;
import com.example.dcr.service.DoorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DoorServiceImpl implements DoorService {

    final DoorRepository doorRepository;
    final DoorMapper doorMapper;

    @Override
    @Transactional(readOnly = true)
    public List<DoorDto> getFavorites() {
        return doorRepository
                .getDoorEntitiesByFavoritesIsTrue()
                .stream()
                .map(doorMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public void setFavorite(long id, boolean isFavorite) {
        DoorEntity entity = doorRepository
                .findById(id)
                .orElseThrow();

        entity.setFavorites(isFavorite);

        doorRepository.save(entity);
    }
}
