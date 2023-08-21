package com.example.awssqsdemo.entity;

import com.example.awssqsdemo.dto.NotificationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.util.StringUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Accessors(chain = true)
@Table("notifications")
public class NotificationEntity implements Persistable<String> {

    @Id
    private String id;
    @Column("subject")
    private String subject;
    @Column("text")
    private String text;
    @Column("recipient_uid")
    private String recipientUid;

    @Transient
    private RecipientEntity recipientEntity;

    @Override
    public String  getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return !StringUtils.hasText(id);
    }

    public NotificationDto toDto(){
        return new NotificationDto()
            .setId(id)
            .setRecipientUid(recipientUid)
            .setSubject(subject)
            .setText(text);
    }
}
