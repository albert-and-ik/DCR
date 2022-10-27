package com.example.dcr.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEmptyEntity extends EmptyEntity{
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
