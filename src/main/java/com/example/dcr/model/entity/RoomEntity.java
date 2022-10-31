package com.example.dcr.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name = "rooms")
@NoArgsConstructor
public class RoomEntity extends BaseEmptyEntity{
    @Id
    @Column(name="name")
    String name;

    public RoomEntity(@NotBlank String name){
        this.name = name;
    }
}
