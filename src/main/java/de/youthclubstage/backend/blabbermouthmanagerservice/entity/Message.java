package de.youthclubstage.backend.blabbermouthmanagerservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class Message {
    @Id
    private UUID id;
    private Integer process;
    private Integer state;
    private String content;
    private Long version;
}
