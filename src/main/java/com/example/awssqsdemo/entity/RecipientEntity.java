package com.example.awssqsdemo.entity;

import com.example.awssqsdemo.dto.RecipientDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.util.StringUtils;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table("recipients")
public class RecipientEntity implements Persistable<String> {

    @Id
    private String id;
    @Column("channel")
    private String channel;
    @Column("address")
    private String address;
    @Column("full_name")
    private String fullName;

    @Transient
    @ToString.Exclude
    private List<NotificationEntity> notifications;

    @Override
    public boolean isNew() {
        return !StringUtils.hasText(id);
    }

    public RecipientDto toDto(){
        return new RecipientDto()
            .setId(id)
            .setAddress(address)
            .setChannel(channel)
            .setFullName(fullName);
    }
}
