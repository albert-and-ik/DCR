package com.example.dcr.service.impl;

import com.example.dcr.mapper.EntityMapper;
import com.example.dcr.model.dto.DoorDto;
import com.example.dcr.model.entity.DoorEntity;
import com.example.dcr.model.entity.RoomEntity;
import com.example.dcr.repository.DoorRepository;
import com.example.dcr.service.DoorService;
import com.example.dcr.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class DoorServiceImpl implements DoorService {

    final DoorRepository doorRepository;
    final EntityMapper mapper;
    final RoomService roomService;

    @Override
    @Transactional(readOnly = true)
    public List<DoorDto> getFavorites() {
        return doorRepository
                .getDoorEntitiesByFavoritesIsTrue()
                .stream()
                .map(mapper::toDto)
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

    @Override
    @Transactional
    public void updateOrCreate(List<DoorDto> dtos) {
        LocalDateTime updateTime = LocalDateTime.now();

        var listEntities = dtos.
                stream()
                .map(dto -> {
                    var doorEntity = mapper.toEntity(dto);

                    if(doorRepository.existsById(dto.getId()))
                        doorEntity.setFavorites(null);


                    if(dto.getRoom().equals("null") || dto.getRoom().isEmpty())
                        doorEntity.setRoom(null);
                    else {
                        RoomEntity roomEntity = new RoomEntity();

                        roomEntity.setId(roomService.getRoomByName(dto.getRoom()));

                        doorEntity.setRoom(roomEntity);
                    }

                    doorEntity.setUpdatedAt(updateTime);

                    return doorEntity;
                })
                .toList();

        doorRepository.saveAll(listEntities);
    }
}
