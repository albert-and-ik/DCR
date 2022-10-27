package com.example.dcr.repository;

import com.example.dcr.model.entity.DoorEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoorRepository extends BaseEntityRepository<DoorEntity>{
    List<DoorEntity> getDoorEntitiesByFavoritesIsTrue();
    List<DoorEntity> getDoorEntitiesByRoomName(String name);
}
