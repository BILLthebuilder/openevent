package openEvents.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import openEvents.datastore.model.event.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import openEvents.services.EventService;

import java.util.List;


@Slf4j
@Controller
@RequestMapping(value = "/api/v1/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<EventModel> list() {
        List<EventModel> events = null;
        try {
            events = eventService.getAllEvents();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return events;
    }

    @PostMapping(value = "/save")
    public @ResponseBody String save(@RequestBody EventModel eventModel) {
        try {
            eventService.createEvent(eventModel);
            System.out.println(eventModel);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
        json.put("message","success");

        String message = json.asText();

        return message;
    }

    @GetMapping(value = "event/{id}")
    public @ResponseBody EventModel getById(@PathVariable int id){
        EventModel oneEvent = null;
        try {
            oneEvent = eventService.findOneEvent(id);
        }catch(Exception ex){
            log.error(ex.getMessage());
        }

        return oneEvent;
    }

    @DeleteMapping(value = "delete/event/{id}")
    public @ResponseBody int delete(@PathVariable int id){
        int deleted = 0;
        try{
            deleted = eventService.deleteEvent(id);
        }catch (Exception ex){
           log.error(ex.getMessage());
        }

        return deleted;
    }

    @PostMapping(value = "edit/event/{id}")
    public @ResponseBody EventModel edit(@PathVariable int id, @RequestBody EventModel eventModel){
        EventModel editedEvent = null;
        try{
            editedEvent = eventService.editEvent(eventModel,id);
        }catch (Exception ex){
            log.error(ex.getMessage());
        }

        return editedEvent;
    }
}