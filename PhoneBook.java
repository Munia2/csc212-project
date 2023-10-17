import java.util.*;

public class PhoneBook {

    public static LinkedList <Contact> contacts_list = new LinkedList <Contact>();
    public static LinkedList<Event> events_list  = new LinkedList<Event>();
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        
   
        
        
        int choice;
        System.out.println("Welcome to the Linked Tree Phonebook!");
        do{
            System.out.println( "Please choose an option:\n" +
                                "1. Add a contact\n" +
                                "2. Search for a contact\n" +
                                "3. Delete a contact\n" +
                                "4. Schedule an event\n" +
                                "5. Print event details\n" +
                                "6. Print contacts by first name\n" +
                                "7. Print all events alphabetically\n"+
                                "8. Print all contacts\n"+
                                "9. Exit\n");
            
            System.out.print("Enter your choice:");
            choice = in.nextInt();
            System.out.println("");
            switch (choice)
            {
                case 1:
                    addContact();
                    break;
                
                case 2:
                    searchCriteria();
                    break;
                
                case 3:
                    deleteContact();
                    break;
                
                case 4:
                              
                    scheduleEvent();
                    break;
                
                case 5:
                    printEventDetails();
                    break;
                    
                case 6:
                    printFirstName();
                    break;
                    
                case 7:
                    printEvents();
                    break;
                case 8:
                    System.out.println("contact list:");
                    contacts_list.display();
                    break;
                    
                case 9:
                    System.out.println("Goodbye!");
                    break;    
            }
            System.out.println("\n");
        }while (choice != 9);
    }
    
    
////add a contact to the contacts list
    public static void addContact(){
        
        System.out.print("Enter the contact's name:");
        in.nextLine();
        String cn = in.nextLine();
        System.out.print("Enter the contact's phone number:");
        String pn = in.next();
        System.out.print("Enter the contact's email address:");
        String ea = in.next();
        System.out.print("Enter the contact's address:");
        in.nextLine();
        String ca = in.nextLine();
        System.out.print("Enter the contact's birthday:");
        String bd = in.next();
        System.out.print("Enter any notes for the contact:");
        in.nextLine();
        String n = in.nextLine();
        
        Contact c = new Contact(cn,pn,ea,ca,bd, n);
        
        if (!contacts_list.empty())
        {
            if ( searchName(cn) != null || searchPhone(pn) != null){
                System.out.println("Contact is already exist!");
                return;
            }
        }
        contacts_list.sortedContact(c);
        if (contacts_list.retrieve().equals(c))
            System.out.println("\n\nContact added successfully!");
    }
        

    public static void searchCriteria()
    {
        if (contacts_list.empty())
            System.out.println("There is no contact");
        else{
        System.out.println("Enter search criteria:\n" +
                            "1. Name\n" +
                            "2. Phone Number\n" +
                            "3. Email Address\n" +
                            "4. Address\n" +
                            "5. Birthday");
        System.out.print("\nEnter your choice:");
        
        int choice = in.nextInt();
        switch(choice)
        {
            case 1:
                System.out.print("\nEnter the contact's name: ");
                    in.nextLine();
                    String name = in.nextLine();
                    if (searchName(name) == null)
                        System.out.println("\nThe contact name is not exist");
                    else{
                        System.out.println("\nContact found!");
                        System.out.println(searchName(name));
                    }
                break;
            
            case 2:
                System.out.print("Enter the contact's phone number:");
                in.nextLine();
                String phonenumber = in.nextLine();
                if (searchPhone(phonenumber) == null)
                        System.out.println("\nThe contact phone number is not exist");
                else{
                        System.out.println("\nContact found!");
                        System.out.println(searchPhone(phonenumber));
                    }
                break;
                
            case 3:
                System.out.print("Enter the contact's email address: ");
                String emailAddress = in.next();
                searchEmail(emailAddress);
                break;
            case 4:
                System.out.print("Enter the contact's address: ");
                String address = in.next();
                searchAddress(address);    
                break;
            case 5:
                System.out.print("Enter the contact's Birthday: ");
                String birthday = in.next();
                searchBirthday(birthday);                                                       
               }
        }


    }
    //Search for the contact by his phone number it will return the contact that has the name, or return null if its not exist
    public static Contact searchName(String name){
        
        contacts_list.findfirst();
        while(!contacts_list.last()){
            if (contacts_list.retrieve().getName().equalsIgnoreCase(name))
                return contacts_list.retrieve();
            
            contacts_list.findnext();
        }
        
        if (contacts_list.retrieve().getName().equalsIgnoreCase(name)){
            return contacts_list.retrieve();
        }
        return null;
        }
    //Search for the contact by his phone number and it will return the contact that has the number, or return null if its not exist
        public static Contact searchPhone(String phone){
        
            contacts_list.findfirst();
            while(!contacts_list.last()){
                if (contacts_list.retrieve().getPhonenumber().equals(phone))
                    return contacts_list.retrieve();
            
                contacts_list.findnext();
                }
            if (contacts_list.retrieve().getPhonenumber().equals(phone)){
                //System.out.println(contacts_list.retrieve());
                return contacts_list.retrieve();
            }
            return null;//System.out.println("The contact phone is not exist");
       }
     //Search for the contact by his email address if there are more than one contact have the same email it will print them all   
    public static void searchEmail(String email){
        contacts_list.findfirst();
        if (contacts_list.empty()){
            System.out.println("The contact email address is not exist");
            return;
        }
        
        while(!contacts_list.last()){
            if (contacts_list.retrieve().getEmail().equalsIgnoreCase(email))
                System.out.println(contacts_list.retrieve());
            
            contacts_list.findnext();
        }
        if (contacts_list.retrieve().getEmail().equalsIgnoreCase(email))
                System.out.println(contacts_list.retrieve());   
    }
 //Search for the contact by his address if there are more than one contact have the same address it will print them all 
   public static void searchAddress(String address){
        contacts_list.findfirst();
        while(!contacts_list.last()){
            if (contacts_list.retrieve().getAddress().equalsIgnoreCase(address))
                System.out.println(contacts_list.retrieve());
            
            contacts_list.findnext();
        }
        if (contacts_list.retrieve().getAddress().equalsIgnoreCase(address))
                System.out.println(contacts_list.retrieve());
        
        if (contacts_list.empty()){
            System.out.println("The contact email address is not exist");
            return;
        }
        
    }
   //Search for the contact by his birthday if there are more than one contact have the same birthday it will print them all  
   public static void searchBirthday(String birthday){
       contacts_list.findfirst();
        if (contacts_list.empty()){
            System.out.println("The contact birthday is not exist");
            return;
        }
        
        contacts_list.findfirst();
        while(!contacts_list.last()){
            if (contacts_list.retrieve().getBirthday().equals(birthday))
                System.out.println(contacts_list.retrieve());
            
            contacts_list.findnext();
        }
        if (contacts_list.retrieve().getBirthday().equals(birthday))
                System.out.println(contacts_list.retrieve());
        
   }
   //search for the event title it will return the event if its exist, null otherwise
   public static Event searchTitle(String n){
       
       if(events_list.empty())
           return null;
       
       events_list.findfirst();
       while(!events_list.last())
       {
           if (events_list.retrieve().getTitle().equalsIgnoreCase(n))
               return events_list.retrieve();
           
           events_list.findnext();
       }
       
       if (events_list.retrieve().getTitle().equalsIgnoreCase(n))
           return events_list.retrieve();
       
       return null;
     
}
   
 // Delete a contact and all the events with the contact if there is no other contact associated with it
 public static void deleteContact()
    {
        Contact c = new Contact();
        
        System.out.print("Enter the contact\'s name: ");
        in.nextLine();
        c = searchName(in.nextLine());
        if (contacts_list.empty())
            System.out.println("empty list!");
        else
        {
            if ( c == null)
                System.out.println("Contact dosa not exist!");
            else
            {
                contacts_list.remove(c);
                if (!c.getEvents().empty())
                {
                    Event e;
                    c.getEvents().findfirst();
                    while ( !c.getEvents().last())
                    {
                         e = c.getEvents().retrieve();
                        if (events_list.search(e))
                        {
                            Event c_event = events_list.retrieve();
                            c_event.getContacts_names().remove(c.getName());
                            if (c_event.getContacts_names().empty())
                            {
                                events_list.remove(e);
                                System.out.println("Contact's event "+e.getTitle() +" is also deleted");
                            }
                            else{
                            System.out.println("Contact deleted successfully!");
                            }  
                        }
                        c.getEvents().findnext();
                    }
                        e = c.getEvents().retrieve();
                        if (events_list.search(e))
                        {
                            Event c_event = events_list.retrieve();
                            c_event.getContacts_names().remove(c.getName());
                            if (c_event.getContacts_names().empty())
                            {
                                events_list.remove(e);
                                System.out.println("contact event "+e.getTitle() +" is also deleted");
                            }
                            else{
                            System.out.println("Contact Deleted Successfully !");
                            }
                        } 
        
        }       
    }
        }
   }
   

//check if there is a conflict between a new event and a current scheduled event it will return true if there is a conflict false otherwise
 public static boolean is_conflict(String d,String t,String cn){
       if (!events_list.empty()) {
           
        events_list.findfirst();
        while (!events_list.last()) {
            if (events_list.retrieve().getDate().equals(d)
                    && events_list.retrieve().getTime().equals(t)&& events_list.retrieve().getContacts_names().equals(cn )) {
                return true; 
            }
            events_list.findnext();
        }
        
        if ( events_list.retrieve().getDate().equals(d)
                && events_list.retrieve().getTime().equals(t)&& events_list.retrieve().getContacts_names().equals(cn) ) {
            return true; 
        }
    } return false;
}
 //add event 
   public static void addEvent(Event e, Contact c){
       
       if (searchTitle(e.getTitle()) == null){
           events_list.sortedEvent(e); //add event if it is not exist in the event list 
           c.getEvents().insert(e);
       }
       else{
           c.getEvents().insert(e);
       }
        
    } 
//schedule event  
    public static void scheduleEvent(){
          System.out.print("Enter the Event title:");
          in.nextLine();
          String title = in.nextLine() ;
          System.out.print("Enter contact name:");
          String cn = in.nextLine();
          System.out.print("Enter event date and time(MM/DD/YYYY HH:MM):");
          String d = in.next();
          String t = in.next();
          System.out.print("Enter event location:");
          in.nextLine();
          String loc = in.nextLine();
          Contact c = searchName(cn);
          if(c == null){
            System.out.println(" this contact does not exist");
            return;
       }
       Event e;
          if (searchName(title) != null)
              e = searchTitle(title);
          else{
              e = new Event(title,d,t,loc);
          }
          
         if ( !is_conflict(d,t,cn) ){
           e.getContacts_names().insert(cn);
           addEvent(e,c);
           System.out.println("\nEvent Scheduled successfully!");
       }
        else  
       {
          System.out.println("there is conflict event");
       }   
   }
// Print event details 
      public static void printEventDetails(){
          System.out.println("Enter search criteria:\n1.contact name \n2.Event title\n");
          System.out.print("Enter your choice:");
          int choice = in.nextInt();
          switch(choice){
              case 1:                 
                  System.out.print("Enter contact name:");
                  in.nextLine();
                  String cn = in.nextLine();

                  if (contacts_list.empty()){                 
                  System.out.println("empty list");
                  return;
                  }
                   if (searchName(cn) != null){
                   System.out.println("\ncontact found");
                   c.getEvents().display();
                   }

                  break;
              case 2:
                  System.out.print("Enter events title:");
                  in.nextLine();
                  String t = in.nextLine();
                  Event e = searchTitle(t);
                  if (e != null){
                      System.out.println("Event found!");
                      System.out.println(e);
                  }
                  else{
                      System.out.println("Event not found");
                  }
                  break;
          }
                  
      } 
   



//Print the contacts' first name   
    public static void printFirstName(){
       
        System.out.print("Enter the first name:");
        in.nextLine();
        String fname = in.nextLine();
        
        if (contacts_list.empty())
            System.out.println("No Contacts found !");
        
        String[] names = contacts_list.retrieve().getName().split(" ");
        
        contacts_list.findfirst();
         while(!contacts_list.last())   
            {
                names = contacts_list.retrieve().getName().split(" ");
                if (names[0].equals(fname))
                System.out.println(contacts_list.retrieve() + "\n");
            contacts_list.findnext();
            }
            names = contacts_list.retrieve().getName().split(" ");
            if (names[0].equals(fname))
                System.out.println(contacts_list.retrieve() + "\n");

    }
    
    //Print all events alphabetically 
    public static void printEvents(){
        if (!events_list.empty())
        {
            events_list.findfirst();
            
            while(!events_list.last())
            
            {
                System.out.println(events_list.retrieve().getTitle());
                events_list.findnext();
            }
            System.out.println(events_list.retrieve().getTitle());
                events_list.findnext();
        }
        else
            System.out.println("empty list");
    }
}
