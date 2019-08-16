package de.youthclubstage.backend.blabbermouthmanagerservice.endpoint;

import de.youthclubstage.blabbermouth.core.EventSender;
import de.youthclubstage.blabbermouth.core.model.EventMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TestEndpoint {
    private final EventSender eventSender;


    @Autowired
    public TestEndpoint(EventSender eventSender){
        this.eventSender = eventSender;
    }

    @RequestMapping(value = "/go", method = RequestMethod.GET)
    public ResponseEntity<Void> sendTest(){

        for (int x = 80000; x > 0; x--) {
            EventMessage eventMessage = new EventMessage();
            eventMessage.setId(UUID.randomUUID());
            eventMessage.setProcess(x);
            eventMessage.setState(x);
            eventMessage.setVersion(1L);
            eventSender.sendEvent(eventMessage);
        }

        return ResponseEntity.ok().build();
    }
}
