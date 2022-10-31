package com.example.dcr.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name="doors")
public class DoorEntity extends BaseIdEntity {

    @NotBlank
    @Column(name="name")
    String name;

    @Column(name = "favorites", nullable = false)
    boolean favorites;


    @Column(name="snapshot")
    String snapshot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room")
    RoomEntity room;
}
