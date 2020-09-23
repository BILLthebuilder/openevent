package openEvents.datastore.dao.event;

import openEvents.datastore.model.event.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EventDao implements EventDaoI{
    @PersistenceContext
    private EntityManager em;


    EventModel eventModelInstance = new EventModel();


    @Override
    public EventModel createEvent(EventModel event){
        return em.merge(event);
    }

    @Override
    @SuppressWarnings({ "unchecked" })
    public List<EventModel> getAllEvents(){
        List<EventModel> events = em.createQuery("from " + EventModel.class.getName()).getResultList();
        return events;
    }

    @Override
    public EventModel editEvent(EventModel eventModel, int eventId){
        this.eventModelInstance = this.findOneEvent(eventId);
        return em.merge(eventModel);
    }

    @Override
    public EventModel findOneEvent(int eventId){
        this.eventModelInstance = em.find(EventModel.class, eventId);
        return eventModelInstance;
    }

    @Override
    public int deleteEvent(int eventId){
        this.eventModelInstance = this.findOneEvent(eventId);
        em.remove(eventModelInstance);
        return eventModelInstance.getId();
    }
}
