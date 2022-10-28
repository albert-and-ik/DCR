package com.example.dcr.service.impl;

import com.example.dcr.model.dto.RoomDto;
import com.example.dcr.model.entity.RoomEntity;
import com.example.dcr.repository.CameraRepository;
import com.example.dcr.repository.RoomRepository;
import com.example.dcr.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {

    final RoomRepository roomRepository;
    final CameraRepository cameraRepository;

    @Override
    @Transactional(readOnly = true)
    public List<RoomDto> getAll() {
        return roomRepository
                .findAll()
                .stream()
                .map(RoomDto::toDto)
                .toList();
    }

    @Override
    @Transactional
    public void updateOrCreate(List<String> names) {
        names.forEach(this::getRoomByNameOrCreate);
    }


    @Override
    @Transactional
    public @Nullable RoomEntity getRoomByNameOrCreate(String name) {
        if(name == null || name.equals("null") || name.isEmpty())
            return null;

        return roomRepository
                .findById(name)
                .orElseGet(() -> {
                    var newRoom = new RoomEntity(name);
                    newRoom.setUpdatedAt(LocalDateTime.now());
                    return roomRepository.save(newRoom);
                });
    }
}
