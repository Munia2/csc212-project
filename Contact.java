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
        return name.compareTo(c.name);
}

    public String getName() {
        return name;
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
