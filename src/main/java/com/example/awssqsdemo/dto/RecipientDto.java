package com.example.awssqsdemo.dto;

import com.example.awssqsdemo.entity.RecipientEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Accessors(chain = true)
public class RecipientDto {

    private String id;
    private String channel;
    private String address;
    private String fullName;
    private List<NotificationDto> notifications;

    public RecipientEntity toEntity(){
        return new RecipientEntity()
            .setChannel(channel)
            .setAddress(address)
            .setFullName(fullName);
    }
}
