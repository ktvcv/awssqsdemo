package com.example.awssqsdemo.dto;

import com.example.awssqsdemo.entity.NotificationEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Accessors(chain = true)
public class NotificationDto {

    private String id;
    private String subject;
    private String text;
    private String recipientUid;
    private RecipientDto recipient;

    public NotificationEntity toEntity(){
        return new NotificationEntity()
            .setSubject(subject)
            .setText(text)
            .setRecipientUid(recipientUid);
    }

}
