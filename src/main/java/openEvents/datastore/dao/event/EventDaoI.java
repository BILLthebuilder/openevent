package openEvents.datastore.dao.event;

import openEvents.datastore.model.event.EventModel;

import java.util.List;

public interface EventDaoI {
    EventModel createEvent(EventModel event)throws Exception;
    List<EventModel> getAllEvents()throws Exception;
    EventModel editEvent(EventModel eventModel, int eventId)throws Exception;
    EventModel findOneEvent(int eventId)throws Exception;
    int  deleteEvent(int eventId)throws Exception;
}
