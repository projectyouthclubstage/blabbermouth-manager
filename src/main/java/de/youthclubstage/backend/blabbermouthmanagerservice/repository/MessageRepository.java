package de.youthclubstage.backend.blabbermouthmanagerservice.repository;

import de.youthclubstage.backend.blabbermouthmanagerservice.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MessageRepository extends MongoRepository<Message, UUID> {
}
