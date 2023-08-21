package com.example.awssqsdemo.repository;

import com.example.awssqsdemo.entity.NotificationEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface NotificationRepository extends R2dbcRepository<NotificationEntity, String> {
}
