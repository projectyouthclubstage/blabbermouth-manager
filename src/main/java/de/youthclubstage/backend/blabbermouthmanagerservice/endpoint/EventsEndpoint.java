package de.youthclubstage.backend.blabbermouthmanagerservice.endpoint;

import com.fasterxml.jackson.annotation.JsonFormat;
import de.youthclubstage.backend.blabbermouthmanagerservice.entity.Message;
import de.youthclubstage.backend.blabbermouthmanagerservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/v1/events", produces = "application/json")
public class EventsEndpoint {

    private final EventService eventService;

    @Autowired
    public EventsEndpoint(EventService eventService){
        this.eventService = eventService;
    }

    @RequestMapping(method = GET)
    public ResponseEntity<Page<Message>> getMessages(
            @RequestParam(defaultValue = "0")  int page,
            @RequestParam(defaultValue = "50")  int pageSize,
            @RequestParam(defaultValue = "calendar") String[] sort,
            @RequestParam(defaultValue = "ASC") String sortdirection,
            @RequestParam(required = false) Integer lastMinutes,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date from,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date to,
            Message message
    ){
        Date start = from;
        Date end = to;
        if(from == null && to == null && lastMinutes != null){
            Calendar curStart = Calendar.getInstance();
            curStart.add(Calendar.MINUTE, lastMinutes * -1);
            start = curStart.getTime();
            end =  Calendar.getInstance().getTime();
        }
        Sort mysort = new Sort(sortdirection.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC,sort);
        Page<Message> result = eventService.getMessages(Example.of(message),start,end, PageRequest.of(page,pageSize,mysort));
        return ResponseEntity.ok(result);
    }




}
