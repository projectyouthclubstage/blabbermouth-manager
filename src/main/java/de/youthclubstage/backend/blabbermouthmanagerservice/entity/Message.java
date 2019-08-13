package de.youthclubstage.backend.blabbermouthmanagerservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Data
public class Message {
    @Id
    private UUID id;
    @Indexed
    private Integer process;
    @Indexed
    private Integer state;
    @Indexed
    private String application;
    private String content;
    private Long version;
    private Long retryCount = 0L;
    private boolean isRetryMessage = false;
    private UUID previousMessage;
    @Indexed
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="CET")
    private Calendar calendar;
}
