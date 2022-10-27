package com.example.dcr.repository;

import com.example.dcr.model.entity.BaseIdEntity;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;

@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseIdEntity> extends EmptyEntityRepository<T, Long> {
    void deleteAllByUpdatedAtBefore(LocalDateTime localDateTime);
}
