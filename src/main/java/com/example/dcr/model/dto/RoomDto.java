package com.example.dcr.model.dto;

import com.example.dcr.model.entity.RoomEntity;
import lombok.Data;

@Data
public class RoomDto {
    String name;

    public RoomEntity toEntity(){
        return new RoomEntity(name);
    }

    public static RoomDto toDto(RoomEntity roomEntity){
        if(roomEntity==null)
            return null;

        RoomDto dto = new RoomDto();
        dto.setName(roomEntity.getName());

        return dto;
    }

}
