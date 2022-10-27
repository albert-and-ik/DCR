package com.example.dcr.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Table(name= "cameras")
public class CameraEntity extends BaseEntity {

    @Column(name="favorites",nullable = false)
    Boolean favorites;

    @Column(name="rec",nullable = false)
    Boolean rec;

    @NotBlank
    @Column(name = "name")
    String name;

    @Column(name = "snapshot")
    String snapshot;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room")
    RoomEntity room;
}
