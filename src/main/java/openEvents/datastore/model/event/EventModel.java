package openEvents.datastore.model.event;

import openEvents.datastore.model.attendee.AttendeeModel;
import openEvents.datastore.model.organizer.OrganizerModel;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.*;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "event")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column
    private String eventTitle;

    @NotNull
    @Column(name = "organizer")
    private String organizerName;

    @NotNull
    @Column(name = "description")
    private String eventDescription;

    @Column(name = "tags")
    private String eventTags;

    @NotNull
    @Column(name = "location")
    private String eventLocation;

    @Column(name = "type")
    private String eventType;

    @Column(name ="category")
    private String eventCategory;


//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name="organizer_id")
//    @JsonBackReference
//    private OrganizerModel organizer;


    @Column(name = "start_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date eventStartDateAndTime;


    @Column(name = "end_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date eventEndDateAndTime;


//    @Formula("organizer_id")
//    private int organizerId;

//    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<AttendeeModel> attendees = new ArrayList<>();

//    @ManyToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private Set<AttendeeModel> allAtendees = new HashSet<>();

    
}
