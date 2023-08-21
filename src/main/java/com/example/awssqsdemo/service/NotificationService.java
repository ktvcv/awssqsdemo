package com.example.awssqsdemo.service;

import com.example.awssqsdemo.dto.NotificationDto;
import com.example.awssqsdemo.entity.NotificationEntity;
import com.example.awssqsdemo.repository.NotificationRepository;
import com.example.awssqsdemo.repository.RecipientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public Mono<NotificationDto> getNotification(final String id){
        return notificationRepository.findById(id)
            .map(NotificationEntity::toDto);
    }
}
