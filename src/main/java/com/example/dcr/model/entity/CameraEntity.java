package com.example.dcr.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name= "cameras")
public class CameraEntity extends BaseEntity{

    @Column(nullable = false)
    boolean favorites;

    @Column(nullable = false)
    boolean rec;

    @Column
    String snapshot;

}
