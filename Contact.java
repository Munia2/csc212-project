public class Contact implements Comparable<Contact>{
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String birthday;
    private String notes;
    private LinkedList<Event> contact_events = new LinkedList<Event>();
   

    public Contact(String name, String phoneNumber, String email, String address, String birthday, String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
    }

    public int compareTo(Contact c){
        return name.compareTo(c.name);
    }
        // compare two names
//        int len1 = name.length();
//        int len2 = c.name.length();
//        int shortest = Math.min(len1, len2);
//  
//        for (int i = 0; i < shortest; i++) {
//            int name1ch = (int)name.charAt(i);
//            int name2ch = (int)c.name.charAt(i);
//  
//            if (name1ch != name2ch) {
//                return name1ch - name2ch;
//            }
//          try{

            
//            return name.compareTo(c.name);
//        }
//        catch (Exception e)
//        {
//             //To change body of generated methods, choose Tools | Templates.
//            throw new UnsupportedOperationException("Not supported yet.");
//        }    
    
        
  
        // Edge case for strings like
        // String 1="Geeks" and String 2="Geeksforgeeks"
//        if (len1 != len2) {
//            return len1 - len2;
//        }
  
        // If none of the above conditions is true,
        // it implies both the strings are equal
//        else {
//            return 0;
//        }
//    }


    
//    public Event getEvent() {
//        return event;
//    }

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

    public String getBirthday() {
        return birthday;
    }


    public LinkedList getContact_Events() {
        return contact_events;
    }
    
    public void displayEvents(){
        
    }

    @Override
    public String toString() {
        return "Name:" + name + "\nPhoneNumber:" + phoneNumber + "\nEmail:" + email + "\nAddress:" + address + "\nBirthday:" + birthday + "\nNotes:" + notes ;
    }
   
}


