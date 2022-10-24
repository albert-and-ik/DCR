package com.example.dcr.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column
    long id;

    @NotBlank
    @Column
    String name;
}
