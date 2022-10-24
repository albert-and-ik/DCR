package com.example.dcr.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name="doors")
public class DoorEntity extends BaseEntity{

    @Column(nullable = false)
    boolean favorites;

}
