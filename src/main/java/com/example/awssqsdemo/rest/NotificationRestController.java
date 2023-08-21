package com.example.awssqsdemo.rest;

import com.example.awssqsdemo.dto.NotificationDto;
import com.example.awssqsdemo.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/notification")
public class NotificationRestController {

    private final NotificationService notificationService;

    @GetMapping("/{uid}")
    public Mono<NotificationDto> getById(@PathVariable final String uid){
        return notificationService.getNotification(uid);
    }
}
