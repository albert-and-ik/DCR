package com.example.dcr.repository;

import com.example.dcr.model.entity.CameraEntity;
import com.example.dcr.model.entity.RoomEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CameraRepository extends  BaseEntityRepository<CameraEntity> {
    List<CameraEntity> findAllByFavorites(boolean isFavorites);
    List<CameraEntity> getCameraEntitiesByRoomName(String name);

    @Modifying(clearAutomatically = true)
    @Query("update CameraEntity c " +
            "set c.name=:name, " +
            "c.snapshot=:snapshot," +
            "c.room=:room," +
            "c.updatedAt=:updateAt " +
            "where c.id =:id")
    void update(@Param("id")long id,
                @Param("name") String name,
                @Param("snapshot") String snapshot,
                @Param("room")RoomEntity room,
                @Param("updateAt")LocalDateTime updateAt);
}
