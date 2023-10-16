/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author munia
 */
public class Contact implements Comparable<Contact> {
    private String name;
    private String phonenumber;
    private String emailaddress;
    private String address;
    private String birthday; 
    private String notes;
    private LinkedList<Event> events; 
   
    public Contact() {
        name = "";
        phonenumber = "";
        emailaddress = "";
        address = "";
        birthday = null;
        notes = "";
        events = new LinkedList<Event>();
    }

    public Contact(String name, String phonenumber, String emailaddress, String address, String birthday, String notes) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.emailaddress = emailaddress;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
        events = new LinkedList<Event>();
    }

   
    public String toString() {
        return "\nName: " + name +
                    "\nPhone Number: " + phonenumber +
                    "\nEmail Address: " + emailaddress +
                    "\nAddress: " +  address +
                    "\nBirthday: " + birthday +
                    "\nNotes: " + notes + "\n";
    }

    
   public boolean addEvent(Event e) {
       
       
    if (!events.empty()) {
        events.findfirst();
        while (!events.last()) {
            if ((events.retrieve().getDate().equals(e.getDate()))
                    && events.retrieve().getTime().equals(e.getTime())) {
                return false; // Event with the same date and time already exists
            }
            events.findnext();
        }

        // Check the last event outside the loop
        if ((events.retrieve().getDate().equals(e.getDate()))
                && events.retrieve().getTime().equals(e.getTime())) {
            return false; // Event with the same date and time already exists
        }
    }
    events.insert(e);
    return true;
   }
     public boolean removeEvent(String title)
    {
        if (events.empty()){
         System.out.println("there is no events available");
         return false;}
         
        Event e = new Event();
        e.setTitle(title);
        if (events.search(e))
        {
            events.remove(e);
            return true;
        }
        return false;
    }
    
   
   public int compareTo(Contact c) {
        return this.name.compareTo(c.name);
}

    public String getName() {
        return name;
    }
    public void setName(String n){
        name = n;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return emailaddress;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }
    

    public LinkedList<Event> getEvents() {
        return events;
    }

  
    








    
}