package de.youthclubstage.backend.blabbermouthmanagerservice.service;

import de.youthclubstage.backend.blabbermouthmanagerservice.mapping.MessageMapper;
import de.youthclubstage.backend.blabbermouthmanagerservice.repository.MessageRepository;
import de.youthclubstage.blabbermouth.core.EventSender;
import de.youthclubstage.blabbermouth.core.annotation.EventhandlerMethod;
import de.youthclubstage.blabbermouth.core.model.EventMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventWriter {

    private final MessageMapper messageMapper;
    private final MessageRepository messageRepository;

    @Autowired
    public EventWriter(MessageMapper messageMapper,MessageRepository messageRepository){
        this.messageMapper = messageMapper;
        this.messageRepository = messageRepository;
    }


    @EventhandlerMethod(process = -1 , state = -1)
    public EventMessage allMessages(EventMessage message){
        messageRepository.save(messageMapper.toMessage(message));
        return null;
    }



}
