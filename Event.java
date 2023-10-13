/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author munia
 */




import java.util.*;



public class Event implements Comparable<Event> {
    String event_title;
    String date;
    String time;
    String location;
    LinkedList <String> contacts_names;//the contact that involved in the event

    public Event() {
        this.event_title = "";
        this.date = "";
        this.time = "";
        this.location = "";
        this.contacts_names = new LinkedList<String> ();
    }
    
    public Event(String eTitle, String date, String time, String location, String contact) {
        this.event_title = eTitle;
        this.date = date;
        this.time = time;
        this.location = location;
        this.contacts_names = new LinkedList<String> ();//list because contact can have more than one event
        contacts_names.insert(contact);
    }

    public void addContact (String contact)
    {
        contacts_names.insert(contact);
    }
    
    public void removeContact()
    {
        String name = contacts_names.retrieve();
        contacts_names.remove();
            if ( name != null)
            contacts_names.remove();
            
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    public String toString() {
        String str = "";
        contacts_names.findfirst();
         
         while(!contacts_names.last())
         {
             str += contacts_names.retrieve() + " ";
             contacts_names.findnext();
         }
       return "Event title: " + event_title +
                    "\nEvent date and time (MM/DD/YYYY HH:MM): " + date + time +
                   "\nEvent location: " + location + "\n" +
                    "\nContacts names:"+ str;
         
          
    }
   
    public int compareTo(Event obj)  {
       
            return this.event_title.compareToIgnoreCase(obj.event_title);
           }

}


