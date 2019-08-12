package de.youthclubstage.backend.blabbermouthmanagerservice.service;

import de.youthclubstage.backend.blabbermouthmanagerservice.entity.Message;
import de.youthclubstage.backend.blabbermouthmanagerservice.mapping.MessageMapper;
import de.youthclubstage.backend.blabbermouthmanagerservice.repository.MessageRepository;
import de.youthclubstage.blabbermouth.core.annotation.EventType;
import de.youthclubstage.blabbermouth.core.annotation.EventhandlerMethod;
import de.youthclubstage.blabbermouth.core.model.EventMessage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Calendar;


@Service
public class EventWriter {

    private final MessageMapper messageMapper;
    private final MessageRepository messageRepository;

    @Autowired
    public EventWriter(MessageMapper messageMapper,MessageRepository messageRepository){
        this.messageMapper = messageMapper;
        this.messageRepository = messageRepository;
    }


    @EventhandlerMethod(process = -1, state = -1, eventTyp = EventType.ALL)
    public EventMessage allMessages(EventMessage message){
        Message currentMessage = messageMapper.toMessage(message);
        currentMessage.setCalendar(Calendar.getInstance());
        messageRepository.save(currentMessage);
        return null;
    }



}
