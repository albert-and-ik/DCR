package com.example.dcr.repository;

import com.example.dcr.model.entity.EmptyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EmptyEntityRepository<T extends EmptyEntity, ID> extends JpaRepository<T,ID> {
}
