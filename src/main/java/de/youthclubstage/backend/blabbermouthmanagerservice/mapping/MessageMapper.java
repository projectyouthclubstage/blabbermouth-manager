package de.youthclubstage.backend.blabbermouthmanagerservice.mapping;

import de.youthclubstage.backend.blabbermouthmanagerservice.entity.Message;
import de.youthclubstage.blabbermouth.core.model.EventMessage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message toMessage(EventMessage source);
}
