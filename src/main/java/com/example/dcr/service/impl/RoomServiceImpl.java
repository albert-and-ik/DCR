package com.example.dcr.service.impl;

import com.example.dcr.mapper.EntityMapper;
import com.example.dcr.model.dto.CameraDto;
import com.example.dcr.model.dto.DoorDto;
import com.example.dcr.model.dto.RoomDto;
import com.example.dcr.model.entity.RoomEntity;
import com.example.dcr.repository.CameraRepository;
import com.example.dcr.repository.RoomRepository;
import com.example.dcr.service.DoorService;
import com.example.dcr.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {

    final RoomRepository roomRepository;
    final DoorService doorService;
    final CameraRepository cameraRepository;
    final EntityMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<RoomDto> getAll() {
        return roomRepository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CameraDto> getCamerasFromRoom(long id) {
        return cameraRepository
                .getCameraEntitiesByRoomId(id)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public List<DoorDto> getDoorsFromRoom(long id) {
        return doorService.getDoorEntitiesByRoomId(id);
    }

    @Override
    @Transactional
    public void updateOrCreate(List<String> names) {
        names.forEach(this::getRoomByNameOrCreate);
    }

    @Override
    @Transactional
    public long getRoomByNameOrCreate(String name) {
        long idRoom = roomRepository.findFirstByName(name);

        if(idRoom<=0){
            var roomEntity = new RoomEntity();
            roomEntity.setId(roomRepository.getMaximumId()+1);
            roomEntity.setName(name);
            roomEntity.setUpdatedAt(LocalDateTime.now());
            return roomRepository.save(roomEntity).getId();
        }else {
            return idRoom;
        }

    }
}
