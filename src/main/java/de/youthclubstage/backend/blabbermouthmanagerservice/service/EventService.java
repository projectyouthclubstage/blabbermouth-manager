package de.youthclubstage.backend.blabbermouthmanagerservice.service;

import de.youthclubstage.backend.blabbermouthmanagerservice.entity.Message;
import de.youthclubstage.backend.blabbermouthmanagerservice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.Calendar;
import java.util.List;

@Service
public class EventService {
    private final MessageRepository messageRepository;

    @Autowired
    public EventService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public Page<Message> getMessages(Example<Message> example, Calendar start,Calendar end, Pageable pageable){
        if(start != null && end != null) {
            return messageRepository.findAllByCalendarBetween(start, end, example, pageable);
        }else
            return messageRepository.findAll(example,pageable);
    }
}
