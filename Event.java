/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author munia
 */
public class Event implements Comparable<Event> {
    String title;
    String date;
    String time;
    String location;
    //String contact_name; 
    LinkedList <Contact> contacts = new LinkedList<Contact>();
    LinkedList <Event> events = new LinkedList<Event>();
    
    
    
    public Event(String eTitle, String date, String time, String location,Contact contact) {
        this.title = eTitle;
        this.date = date;
        this.time = time;
        this.location = location;
        //this.contact_name = contact.getName();
        contacts.insert(contact);
        //this.contacts_names = new LinkedList<String> ();//list because contact can have more than one event
        //contacts_names.insert(contact.getName());
    }
 
    public void removeContact()
    {
        String name = contacts.retrieve().getName();
        contacts.remove();
            if ( name != null)
            contacts.remove();
            
    }

    public void setDate(String date) {
        this.date = date;
    }
                    
    public int compareTo(Event e)  {
       
            return title.compareToIgnoreCase(e.title);
           }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }
    

//    public String getContact_name() {
//        return contact_name;
//    }
    
    

    public LinkedList<Contact> getContacts() {
        return contacts;
    }

    public String toString() {
        String s = "";
        contacts.findfirst();
         
         while(!contacts.last())
         {
             s += contacts.retrieve().getName() + " ";
             contacts.findnext();
         }
       return "Event title: " + title +
                    "\nContacts names:"+ s +"\nEvent date and time (MM/DD/YYYY HH:MM): " + date +" "+ time +
                   "\nEvent location: " + location + "\n" ;
    
    
    }
}


