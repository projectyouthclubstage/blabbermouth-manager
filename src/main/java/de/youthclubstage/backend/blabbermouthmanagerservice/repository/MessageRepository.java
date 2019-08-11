package de.youthclubstage.backend.blabbermouthmanagerservice.repository;

import de.youthclubstage.backend.blabbermouthmanagerservice.entity.Message;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Calendar;
import java.util.UUID;

public interface MessageRepository extends MongoRepository<Message, UUID> {

    Page<Message> findAllByCalendarBetween(Calendar start, Calendar end, Example<Message> example, Pageable pageable);
}
