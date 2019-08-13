package de.youthclubstage.backend.blabbermouthmanagerservice.repository;

import de.youthclubstage.backend.blabbermouthmanagerservice.entity.Message;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Calendar;

public interface MessageExtentedRepository {
    Page<Message> findAllExample(Example<Message> example, Pageable pageable);
    Page<Message> findAllByCalendarBetween(Calendar start, Calendar end, Example<de.youthclubstage.backend.blabbermouthmanagerservice.entity.Message> example, Pageable pageable);
}
