package openEvents.services;

import openEvents.datastore.model.event.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import openEvents.datastore.dao.event.EventDaoI;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EventService {
    @Autowired
    private EventDaoI eventDao;

    private final EventModel eventModel = new EventModel();

    final static private String INVALID_ID_ERROR = "Invalid Event Id";
    final static private String EVENT_NOT_FOUND = "No events found";

    public void createEvent(EventModel event) throws Exception {
        if (event == null) {
            throw new Exception("Invalid event details");
        }
        eventDao.createEvent(event);

    }

    public List<EventModel> getAllEvents() throws Exception {
        List<EventModel> events = eventDao.getAllEvents();
        if (events.isEmpty()) {
            throw new Exception(EVENT_NOT_FOUND);
        }
        return events;
    }

    public EventModel findOneEvent(int eventId) throws Exception {
        if (eventId == 0)
            throw new Exception(INVALID_ID_ERROR);

        if (eventModel == null)
            throw new Exception(EVENT_NOT_FOUND);

        return eventDao.findOneEvent(eventId);
    }

    public int deleteEvent(int eventId) throws Exception {
        if (eventId == 0)
            throw new Exception(INVALID_ID_ERROR);
        return eventDao.deleteEvent(eventId);
    }

    public EventModel editEvent(EventModel eventModel, int eventId) throws Exception {
        if (eventId == 0)
            throw new Exception(INVALID_ID_ERROR);
        if (eventModel == null)
            throw new Exception(EVENT_NOT_FOUND);
        return eventDao.editEvent(eventModel, eventId);
    }


}
