package com.example.dcr.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name = "rooms")
public class RoomEntity extends BaseEntity{

    @NotBlank
    @Column(name="name")
    String name;
}
