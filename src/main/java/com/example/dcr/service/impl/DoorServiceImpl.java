package com.example.dcr.service.impl;

import com.example.dcr.model.dto.DoorDto;
import com.example.dcr.model.entity.DoorEntity;
import com.example.dcr.repository.DoorRepository;
import com.example.dcr.service.DoorService;
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
public class DoorServiceImpl implements DoorService {

    final DoorRepository doorRepository;
    final RoomService roomService;

    @Override
    @Transactional(readOnly = true)
    public List<DoorDto> getFavorites() {
        return doorRepository
                .getDoorEntitiesByFavorites(true)
                .stream()
                .map(DoorDto::toDto)
                .toList();
    }

    @Override
    @Transactional
    public void setFavorite(@Positive long id, boolean isFavorite) {
        DoorEntity entity = doorRepository
                .findById(id)
                .orElseThrow();

        entity.setFavorites(isFavorite);

        doorRepository.save(entity);
    }

    @Override
    @Transactional
    public void updateOrCreate(@NotEmpty List<DoorDto> dtos) {
        LocalDateTime updateTime = LocalDateTime.now();

        var listEntities = dtos.
                stream()
                .map(dto -> {
                    var doorEntity = dto.toEntity();

                    if(doorRepository.existsById(Long.parseLong(dto.getId())))
                        doorEntity.setFavorites(null);


                    doorEntity.setRoom(roomService.getRoomByNameOrCreate(dto.getRoom()));

                    doorEntity.setUpdatedAt(updateTime);

                    return doorEntity;
                })
                .toList();

        doorRepository.saveAll(listEntities);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DoorDto> getDoorByRoomName(@NotBlank String name) {
        return doorRepository
                .getDoorEntitiesByRoomName(name)
                .stream()
                .map(DoorDto::toDto)
                .toList();
    }
}
