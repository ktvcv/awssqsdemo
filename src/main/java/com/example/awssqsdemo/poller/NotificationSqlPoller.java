package com.example.awssqsdemo.poller;

import com.example.awssqsdemo.dto.NotificationDto;
import com.example.awssqsdemo.entity.NotificationEntity;
import com.example.awssqsdemo.repository.NotificationRepository;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationSqlPoller {

    private final NotificationRepository repository;

    public NotificationSqlPoller(final NotificationRepository repository) {
        this.repository = repository;
    }

    @SqsListener(value = "${sqs.notification.queue.name}")
    public void readMessages(@Payload final NotificationDto message){
        log.info("received notification {}", message);
        final NotificationEntity entity = message.toEntity();
        repository.save(entity).subscribe();
    }
}
