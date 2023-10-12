import java.util.*;



public class Event implements Comparable<Event> {
    String event_title;
    Date date;
    String time;
    String location;
    LinkedList <String> contacts_names;//the contact that involved in the event

    public Event() {
        this.event_title = "";
        this.date = null;
        this.time = "";
        this.location = "";
        this.contacts_names = new LinkedList<String> ();
    }
    
    public Event(String eTitle, String date, String time, String location, String contact) {
        this.event_title = eTitle;
        this.date = new Date(date);
        this.time = time;
        this.location = location;
        this.contacts_names = new LinkedList<String> ();//list because contact can have more than one event
        contacts_names.insert(contact);
    }

    public boolean addContact (String contact)
    {
        return contacts_names.insert(contact);
    }
    
    public boolean removeContact(String contact)
    {
           return contacts_names.remove(contact);
            
    }

    
    public String toString() {
       return "Event title: " + event_title +
                    "\nEvent date and time (MM/DD/YYYY HH:MM): " + date + time +
                   "\nEvent location: " + location + "\n" +
                    "\nContacts names:"+contacts_names+"\n";
                
        
    }

    
    public int compareTo(Event obj)  {
       
            return this.event_title.compareToIgnoreCase(obj.event_title);
           }

}


