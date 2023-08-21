package com.example.awssqsdemo.repository;

import com.example.awssqsdemo.entity.RecipientEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface RecipientRepository extends R2dbcRepository<RecipientEntity, String> {
}
