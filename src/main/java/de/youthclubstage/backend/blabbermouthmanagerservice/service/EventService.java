package de.youthclubstage.backend.blabbermouthmanagerservice.service;

import de.youthclubstage.backend.blabbermouthmanagerservice.entity.Message;
import de.youthclubstage.backend.blabbermouthmanagerservice.repository.MessageExtentedRepository;
import de.youthclubstage.backend.blabbermouthmanagerservice.repository.MessageExtentedRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.Date;

@Service
public class EventService {
    private final MessageExtentedRepository messageRepository;

    @Autowired
    public EventService(MessageExtentedRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public Page<Message> getMessages(Example<Message> example, Date start, Date end, Pageable pageable){
        Query query = new Query(new Criteria().alike(example).and("calendar").gt(start).and("calendar").lt(end));
        if(start != null && end != null) {
            return messageRepository.findAllByCalendarBetween(start,end,example,pageable);
        }else
            return messageRepository.findAllExample(example,pageable);
    }
}
