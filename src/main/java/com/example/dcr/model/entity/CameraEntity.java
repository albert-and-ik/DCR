package com.example.dcr.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Table(name= "cameras")
public class CameraEntity extends BaseIdEntity {

    @Column(name="favorites", nullable = false)
    boolean favorites;

    @Column(name="rec", nullable = false)
    boolean rec;

    @NotBlank
    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "snapshot")
    String snapshot;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room")
    RoomEntity room;
}
