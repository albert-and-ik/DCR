package com.example.dcr.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name="doors")
public class DoorEntity extends BaseEntity{

    @NotBlank
    @Column(name="name")
    String name;

    @Column(nullable = false, name = "favorites")
    Boolean favorites;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room")
    RoomEntity room;
}
