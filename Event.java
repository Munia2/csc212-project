/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author munia
 */

public class Event implements Comparable<Event> {
    private boolean type; //if true then it is an event else it is appointment
    private String title;
    private String date;
    private String time;
    private String location;
    private String contact_name;
    private LinkedList <String> contacts_names;
    
    public Event(boolean type, String title, String date, String time, String location, String contact_name) {
        this.type = type;
        this.title = title;
        this.date =  date;
        this.time = time;
        this.location = location;
        this.contact_name = contact_name;
        this.contacts_names = new LinkedList<String> ();
    }

    public String toString() {
        
          return "\nEvent/Appointment title: " + title +"\ncontact name: "+contact_name+
                    "\nEvent/Appointment date and time (MM/DD/YYYY HH:MM): " + date +" "+ time +
                   "\nEvent/Appointment location: " + location ;
    }

 
    public int compareTo(Event e){
        return title.compareToIgnoreCase(e.title);
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public boolean getType() {
        return type;
    }        

    public void setContacts_names(LinkedList<String> contacts_names) {
        this.contacts_names = contacts_names;
    }
    
    public LinkedList<String> getContacts_names() {
        return contacts_names;
    }
}