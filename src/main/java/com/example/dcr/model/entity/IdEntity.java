package com.example.dcr.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class IdEntity extends EmptyEntity {

    @Id
    @Column(name="id")
    long id;
}
