package com.example.dcr.model.dto;

import com.example.dcr.model.entity.CameraEntity;
import com.example.dcr.model.entity.RoomEntity;
import lombok.Data;

@Data
public class CameraDto {
    String id;
    String name;
    String room;
    Boolean rec;
    Boolean favorites;
    String snapshot;

    public CameraEntity toEntity(){
        CameraEntity entity = new CameraEntity();

        entity.setId(Long.parseLong(id));
        entity.setName(name);
        entity.setSnapshot(snapshot);
        entity.setFavorites(favorites);
        entity.setRec(rec);

        if(room!=null && !room.isEmpty()) {
            entity.setRoom(new RoomEntity(room));
        }

        return entity;
    }

    public static CameraDto toDto(CameraEntity entity){
        if(entity==null)
            return null;


        CameraDto dto = new CameraDto();

        dto.setId(String.valueOf(entity.getId()));
        dto.setName(entity.getName());
        dto.setRoom(entity.getRoom().getName());
        dto.setSnapshot(entity.getSnapshot());
        dto.setFavorites(entity.getFavorites());
        dto.setRec(entity.getRec());

        return dto;
    }
}
