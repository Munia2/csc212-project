
import java.util.*;

public class Contact implements Comparable<Contact>{
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String bithday;
    private String notes;
    private LinkedList events;
    
    public Contact(){
        this.name = "";
        this.phoneNumber = "";
        this.email = "";
        this.address = "";
        this.bithday = "";
        this.notes = "";
    }
    
    public Contact(Contact c){
        this.name = c.name;
        this.phoneNumber = c.phoneNumber;
        this.email = c.email;
        this.address = c.address;
        this.bithday = c.bithday;
        this.notes = c.notes;
        
    }

    public Contact(String name, String phoneNumber, String email, String address, String bithday, String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.bithday = bithday;
        this.notes = notes;
    }
    
    
    

    
    
    public int compareTo(Contact c){
        // compare two names
        int len1 = name.length();
        int len2 = c.name.length();
        int shortest = Math.min(len1, len2);
  
        for (int i = 0; i < shortest; i++) {
            int name1ch = (int)name.charAt(i);
            int name2ch = (int)c.name.charAt(i);
  
            if (name1ch != name2ch) {
                return name1ch - name2ch;
            }
            
//            try {
//            return (this.name.compareTo(c.name));
//        }
//        catch (Exception e)
//        {
//             //To change body of generated methods, choose Tools | Templates.
//            throw new UnsupportedOperationException("Not supported yet.");
//        }    
    }
        
  
        // Edge case for strings like
        // String 1="Geeks" and String 2="Geeksforgeeks"
        if (len1 != len2) {
            return len1 - len2;
        }
  
        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            return 0;
        }
    }

    public boolean addEvent(Event e){
        
        events.insertAtEnd(e);
        if (events.retrieve().equals(e))
            return true;
        
        return false;
        
    } 
    public void setName(String name) {
        this.name = name;
    }
    
    
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }

//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public void setBithday(String bithday) {
//        this.bithday = bithday;
//    }
//
//    public void setNotes(String notes) {
//        this.notes = notes;
//    }
//
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getBithday() {
        return bithday;
    }

    public String getNotes() {
        return notes;
    }

    public LinkedList getEvents() {
        return events;
    }

    @Override
    public String toString() {
        return "Contact{" + "name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address + ", bithday=" + bithday + ", notes=" + notes + '}';
    }
    
}


