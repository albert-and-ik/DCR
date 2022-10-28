package com.example.dcr.model.dto;

import com.example.dcr.model.entity.DoorEntity;
import com.example.dcr.model.entity.RoomEntity;
import lombok.Data;

@Data
public class DoorDto {
    String id;
    String room;
    String snapshot;
    String name;
    Boolean favorites;


    public DoorEntity toEntity(){
        DoorEntity entity = new DoorEntity();

        entity.setId(Long.parseLong(id));
        entity.setName(name);
        entity.setSnapshot(snapshot);
        entity.setFavorites(favorites);

        if(room!=null && !room.isEmpty()) {
            entity.setRoom(new RoomEntity(room));
        }

        return entity;
    }


    public static DoorDto toDto(DoorEntity entity){
        if(entity==null)
            return null;

        DoorDto dto = new DoorDto();

        dto.setId(String.valueOf(entity.getId()));
        dto.setName(entity.getName());
        dto.setRoom(entity.getRoom().getName());
        dto.setSnapshot(entity.getSnapshot());
        dto.setFavorites(entity.getFavorites());

        return dto;
    }
}
