/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author munia
 */
public class Event implements Comparable<Event> {
    private String title;
    private String date;
    private String time;
    private String location;
    private LinkedList <String> contacts_names;

    public Event() {
        title = "";
        date = "";
        time = "";
        location = "";
        contacts_names = new LinkedList<String> ();
    }
    
    public Event(String title, String date, String time, String location, String contact) {
        this.title = title;
        this.date =  date;
        this.time = time;
        this.location = location;
        this.contacts_names = new LinkedList<String> ();
        contacts_names.sorted(contact);
    }

    public void addContact (String contact)
    {
         contacts_names.sorted(contact);
    }
    
    public boolean removeContact(String contact)
    {
            String name = contacts_names.remove(contact);
            if ( name != null)
                return true; 
            return false;
    }

    public String toString() {
        String s = "";
        
        contacts_names.findfirst();
        while(!contacts_names.last())   
        {
            s += contacts_names.retrieve() + ",";
            contacts_names.findnext();
        }
         
        s += contacts_names.retrieve();

          return "\nEvent title: " + title + "\nContact name: "+ s +
                    "\nEvent date and time (MM/DD/YYYY HH:MM): " + date + time +
                   "\nEvent location: " + location ;
    }

 
    public int compareTo(Event obj){
        return (this.title.compareToIgnoreCase(obj.title));
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

    public String getLocation() {
        return location;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    

    public LinkedList<String> getContacts_names() {
        return contacts_names;
    }
    
    
   

}


//public class Event implements Comparable<Event> {
//    String title;
//    String date;
//    String time;
//    String location;
//    LinkedList <String> contacts_names;
//
//    public Event() {
//        title = "";
//        date = null;
//        time = "";
//        location = "";
//        contacts_names = new LinkedList<String> ();
//    }
//    
//    public Event(String title, String date, String time, String location, String contact) {
//        this.title = title;
//        this.date = date;
//        this.time = time;
//        this.location = location;
//        this.contacts_names = new LinkedList<String> ();
//        contacts_names.insert(contact);
//    }
//
//    public void addContact (String contact)
//    {
//         contacts_names.insert(contact);
//         
//    }
//    
//    public boolean removeContact(String contact){
//        
//        String name = contacts_names.remove(contact);
//            if ( name != null)
//                return true; 
//            return false;
//
//    } 
//    
////    public boolean removeContact(String contact)
////    {
////            String name = contacts_names.remove(contact);
////            if ( name != null)
////                return true; 
////            return false;
////    }
//
//    @Override
//    public String toString() {
//        String str = "\nEvent title: " + title +
//                    "\nEvent date and time (MM/DD/YYYY HH:MM): " + date + time +
//                   "\nEvent location: " + location + "\n" +
//                    "\nContacts names:   " ;
//                
//        contacts_names.findfirst();
//          while ()
//         {
//             str += contacts_names.retrieve() + "\t";
//             contacts_names.findnext();
//         }
//          return str;
//    }
//
// 
//    public int compareTo(Event obj) {
//            return (this.title.compareToIgnoreCase(obj.title));
//        
//
//        }
//    
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public LinkedList<String> getContacts_names() {
//        return contacts_names;
//    }
//
//}   
//
