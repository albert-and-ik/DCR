package com.example.dcr.repository;

import com.example.dcr.model.entity.CameraEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CameraRepository extends  BaseEntityRepository<CameraEntity> {
    List<CameraEntity> getCameraEntitiesByFavorites(boolean favorites);

    List<CameraEntity> getCameraEntitiesByRoomName(String name);
}
