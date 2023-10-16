/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author munia
 */
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
                    printAllEvents();
                    break;
//                case 8:
//                    System.out.println("Enter the name of the contact that you want to delete his events");
//                    String n = in.nextLine();
//                    LinkedList<Event> l = contactEvents(n);
//                    deleteContactEvents(n,l);
//                    break;
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
    
    
//add a contact
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
//            contacts_list.findfirst();
//            
//            while(!contacts_list.last())
//            {
//                    if (contacts_list.retrieve().getPhonenumber().equals(pn))
//                    {
//                            System.out.println("Contact number is alrady exist!");
//                            return;
//                    }
//                    contacts_list.findnext();
//            }
//            if (contacts_list.retrieve().getPhonenumber().equals(pn))
//                    {
//                            System.out.println("Contact number is alrady exist!");
//                            return;
//                    }
//        }
        }
        contacts_list.sorted(c);
        if (contacts_list.retrieve().equals(c))
            System.out.println("\n\nContact added successfully!");
    }
        
//        Contact c = new Contact(cn,pn,ea,ca,bd, n);
//        
//        if (!contacts_list.empty()){
            
//            if ( searchName(cn) != null){
//                System.out.println("Contact name is already exist!");
//                return;
//            }
//                
//                
//            
//            if ( searchPhone(pn) != null){
//                System.out.println("Contact number is already exist!");
//                return;
//            }
//            contacts_list.findfirst();
//            
//            while(!contacts_list.last())
//            {
//                    if (contacts_list.retrieve().getPhonenumber().equals(pn))
//                    {
//                            System.out.println("Contact number is already exist!");
//                            return;
//                            
//                    }
//                    contacts_list.findnext();
//            }
//            if (contacts_list.retrieve().getPhonenumber().equals(pn))
//                    {
//                            System.out.println("Contact number is alrady exist!");
//                            return;
//                            
//                    }
//            contacts_list.findfirst();
//            
//            while(!contacts_list.last())
//            {
//                    if (contacts_list.retrieve().getName().equals(cn))
//                    {
//                            System.out.println("Contact name is already exist!");
//                            return;
//                            
//                    }
//                    contacts_list.findnext();
//            }
//            if (contacts_list.retrieve().getName().equals(cn))
//                    {
//                            System.out.println("Contact name is alrady exist!");
//                            return;
//                            
//                    }
//        
//        }
//        
//        contacts_list.insert(c);
//        if (contacts_list.retrieve().equals(c))
//            System.out.println("\n\nContact added successfully!");
//        
//
//    }
        

    
    

    public static void searchCriteria()
    {
        System.out.println("Enter search criteria:\n" +
                            "1. Name\n" +
                            "2. Phone Number\n" +
                            "3. Email Address\n" +
                            "4. Address\n" +
                            "5. Birthday");
        System.out.print("\nEnter your choice:");
        
        int choice = in.nextInt();
        if (contacts_list.empty())
            System.out.println("There is no contact");
        else
        {
            contacts_list.findfirst();
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
    
        public static Contact searchPhone(String phone){
        
            contacts_list.findfirst();
            while(!contacts_list.last()){
                if (contacts_list.retrieve().getPhonenumber().equals(phone))
                    return contacts_list.retrieve();//System.out.println(contacts_list.retrieve());
            
                contacts_list.findnext();
                }
            if (contacts_list.retrieve().getPhonenumber().equals(phone)){
                //System.out.println(contacts_list.retrieve());
                return contacts_list.retrieve();
            }
            return null;//System.out.println("The contact phone is not exist");
       }
        
    public static void searchEmail(String email){
        //LinkedList<Contact> l = new LinkedList<Contact>();
        
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
 
   public static void searchAddress(String address){
       //LinkedList<Contact> l = new LinkedList<Contact>();
        
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
   
   public static void searchBirthday(String birthday){
       //LinkedList<Contact> l = new LinkedList<Contact>();
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
   
   
 public static void deleteContact()
    {
        Contact c = new Contact();
        
        System.out.print("Enter the contact\'s name: ");
        in.nextLine();
        c.setName(in.nextLine());
       
        if (contacts_list.empty())
            System.out.println("Contact not found!");
        else
        {
            c = contacts_list.remove(c);
            if ( c == null)
                System.out.println("Contact not found!");
            else
            {
                if (! c.getEvents().empty())
                {
                    Event e;
                    c.getEvents().findfirst();
                    while ( !events_list.last())
                    {
                         e = c.getEvents().retrieve();
                        if (events_list.search(e))
                        {
                            Event c_event = events_list.retrieve();
                            c_event.removeContact(c.getName());
                            if (c_event.getContacts_names().empty())
                            {
                                events_list.remove(e);
                                System.out.println("Delete event, No cantact particapate");
                            }
                            else
                                events_list.update(c_event);
                            
                        }
                        c.getEvents().findnext();
                    }
                    e = c.getEvents().retrieve();
                        if (events_list.search(e))
                        {
                            Event c_event = events_list.retrieve();
                            c_event.removeContact(c.getName());
                            if (c_event.getContacts_names().empty())
                            {
                                events_list.remove(e);
                                System.out.println("Delete event, No cantact particapate");
                            }
                            else
                                events_list.update(c_event);
                            System.out.println("Contact Deleted Successfully !");
                            System.out.println(c);
                        } 
        
        }       
    }
 
 
 
 
 
 
   
   
        }
   }
   

 
 public static boolean is_conflict(Event e){
       if (!events_list.empty()) {
        events_list.findfirst();
        while (!events_list.last()) {
            if ((events_list.retrieve().getDate().compareTo(e.getDate()) == 0)
                    && events_list.retrieve().getTime().equals(e.getTime())) {
                return true; // Event with the same date and time already exists
            }
            events_list.findnext();
        }

        // Check the last event outside the loop
        if ((events_list.retrieve().getDate().compareTo(e.getDate()) == 0)
                && events_list.retrieve().getTime().equals(e.getTime())) {
            return true; // Event with the same date and time already exists
        }
    } return false;
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
          Event e = new Event(title,d,t,loc,cn); 
       if(c == null){
           System.out.println(" this contact does not exist");
           return;
       }
       
       if (c != null && !is_conflict(e) ){
           e.getContacts_names().sorted(c.getName());
           addEvent(e);
           System.out.println("\nEvent Scheduled successfully");
       }
        else  
       {
           if(is_conflict(e))
               System.out.println("there is conflict event");
       }
       
       
       
   }
// print event details 
      public static void printEventDetails(){
          System.out.println("Enter search criteria:\n1.contact name \n2.Event title\n");
          System.out.println("Enter your choice");
          int choice = in.nextInt();
          switch(choice){
              case 1:
                 // Contact c= new Contact();
                 
                  System.out.print("Enter contact name:");
                  
                  //c.setName(in.nextLine());
                  String cn = in.nextLine();
                  //Contact c =searchName(cn);
                  //LinkedList<Event>l = new LinkedList();//= .//contactEvents(cn);
                 // if (!contacts_list.empty()){
                  if (contacts_list.empty())                 
                  System.out.println("empty list");
                   //break;
                   if (searchName(cn) != null){
                   System.out.println("\ncontact found");
                   contacts_list.retrieve().getEvents().display();
                   }
                 
                    
                  //if(contacts_list.search(c)){
                 // c=contacts_list.retrieve();
                  //c.events_list.findfirst();
                  //while(!c.events_list.last()){
                  
                  //}
//                  else{
//                 
//                    contacts_list.display();
//                }
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
   



//print the contacts first name   
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
           
            if (names[0].equals(fname))
                System.out.println(contacts_list.retrieve() + "\n");

    }
//search for the event titlle if it will return the event if its exist or it will return null;
   public static Event searchTitle(String n){
       
       if(events_list.empty())
           return null;
       
       events_list.findfirst();
       while(!events_list.last())
       {
           if (events_list.retrieve().getTitle().equals(n))
               return events_list.retrieve();
           
           events_list.findnext();
       }
       
       if (events_list.retrieve().getTitle().equals(n))
           return events_list.retrieve();
       
       return null;
     
}
   //add event if it is not exist in the event list
   public static void addEvent(Event e){
       
       Event find = searchTitle(e.getTitle());
       
       if (find == null){
           events_list.sorted(e);
       }

        
    } 
   //return the Events in contact
//   public static LinkedList<Event> contactEvents(String n){
//       Contact c = searchName(n);
//       
//       if (c != null)
//           return c.getContact_Events();
//       return new LinkedList<Event>();
//       
//   }
   
   // return the Contacts with the Event
//   public static LinkedList<String> eventContacts(String n){
//       Event e = searchTitle(n);
//
//       if(e!= null)
//           return e.getContacts_names();
//       return new LinkedList<String>();
//       
//   }
   
   //Print all events alphabetically // O(n)
    public static void printAllEvents(){
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
            System.out.println("No events found !");
    }
}

                
    
    
   //   public static boolean is_conflict(Event e , Contact c){
//       //LinkedList<Event> contact_events = c.getContact_Events();
//       //or
//       //LinkedList<Event> contact_events = c.Event_in_contact.events_in_event;
//       
//       if (contact_events.empty())
//           //System.out.println("emplty");
//           return false; //no conflict bec there ic not any events with this contact
//        
////           System.out.println("c="+c);
////           contact_events.display();
//            
//            contact_events.findfirst();
//            
//            while(!contact_events.last()){
//                if (e.getDate().equals(contact_events.retrieve().getDate()) && e.getTime().equals(contact_events.retrieve().getTime()))
//                        return true;
//                contact_events.findnext();
//            }
//               if (e.getDate().equals(contact_events.retrieve().getDate()) && e.getTime().equals(contact_events.retrieve().getTime()))
//                   return true;
//               else
//               {
//                   return false;
//               }
//       
//   }             
//    public static LinkedList <Contact> contacts_list = new LinkedList <Contact>();
//    public static LinkedList<Event> events_list  = new LinkedList<Event>();
//    public static Scanner in = new Scanner(System.in);
//    public static void main(String[] args){
//        
//   
//        
//        
//        int choice;
//        System.out.println("Welcome to the Linked Tree Phonebook!");
//        do{
//            System.out.println( "Please choose an option:\n" +
//                                "1. Add a contact\n" +
//                                "2. Search for a contact\n" +
//                                "3. Delete a contact\n" +
//                                "4. Schedule an event\n" +
//                                "5. Print event details\n" +
//                                "6. Print contacts by first name\n" +
//                                "7. Print all events alphabetically\n"+
//                                "8. Print all contacts\n"+
//                                "9. Exit\n");
//            
//            System.out.print("Enter your choice:");
//            choice = in.nextInt();
//            System.out.println("");
//            switch (choice)
//            {
//                case 1:
//                    addContact();
//                    break;
//                
//                case 2:
//                    searchCriteria();
//                    break;
//                
//                case 3:
//                    deleteContact();
//                    break;
//                
//                case 4:
//                              
//                    scheduleEvent();
//                    break;
//                
//                case 5:
//                    printEventDetails();
//                    break;
//                    
//                case 6:
//                    printFirstName();
//                    break;
//                    
//                case 7:
//                    printAllEvents();
//                    break;
////                case 8:
////                    System.out.println("Enter the name of the contact that you want to delete his events");
////                    String n = in.nextLine();
////                    LinkedList<Event> l = contactEvents(n);
////                    deleteContactEvents(n,l);
////                    break;
//                case 8:
//                    System.out.println("contact list:");
//                    contacts_list.display();
//                    break;
//                    
//                case 9:
//                    System.out.println("Goodbye!");
//                    break;    
//            }
//            System.out.println("\n");
//        }while (choice != 9);
//    }
//    
//    
////add a contact
//    public static void addContact(){
//        
//        System.out.print("Enter the contact's name:");
//        in.nextLine();
//        String cn = in.nextLine();
//        System.out.print("Enter the contact's phone number:");
//        String pn = in.next();
//        System.out.print("Enter the contact's email address:");
//        String ea = in.next();
//        System.out.print("Enter the contact's address:");
//        in.nextLine();
//        String ca = in.nextLine();
//        System.out.print("Enter the contact's birthday:");
//        String bd = in.next();
//        System.out.print("Enter any notes for the contact:");
//        in.nextLine();
//        String n = in.nextLine();
//        
//        Contact c = new Contact(cn,pn,ea,ca,bd, n);
//        if ( contacts_list.search(c))
//        {
//                System.out.println("Contact name is already exist!");
//                return;
//        }
//        if (!contacts_list.empty())
//        {
//            contacts_list.findfirst();
//            
//            while(!contacts_list.last())
//            {
//                    if (contacts_list.retrieve().phonenumber.equals(c.phonenumber))
//                    {
//                            System.out.println("Contact number is alrady exist!");
//                            return;
//                    }
//                    contacts_list.findnext();
//            }
//            if (contacts_list.retrieve().phonenumber.equals(c.phonenumber))
//                    {
//                            System.out.println("Contact number is alrady exist!");
//                            return;
//                    }
//        }
//        
//        contacts_list.insert(c);
//        if (contacts_list.retrieve().equals(c))
//            System.out.println("\n\nContact added successfully!");
//            
//        
//        
//        
//
//    }
//    
//
//    public static void searchCriteria()
//    {
//        System.out.println("Enter search criteria:\n" +
//                            "1. Name\n" +
//                            "2. Phone Number\n" +
//                            "3. Email Address\n" +
//                            "4. Address\n" +
//                            "5. Birthday");
//        System.out.print("\nEnter your choice:");
//        
//        int choice = in.nextInt();
//        if (contacts_list.empty())
//            System.out.println("There is no contact");
//        else
//        {
//            contacts_list.findfirst();
//        switch(choice)
//        {
//            case 1:
//                System.out.print("\nEnter the contact's name: ");
//                    in.nextLine();
//                    String name = in.nextLine();
//                    if (searchName(name) == null)
//                        System.out.println("\nThe contact name is not exist");
//                    else{
//                        System.out.println("\nContact found!");
//                        System.out.println(searchName(name));
//                    }
//                break;
//            
//            case 2:
//                System.out.print("Enter the contact's phone number:");
//                in.nextLine();
//                String phonenumber = in.nextLine();
//                searchPhone(phonenumber);
//                break;
//                
//            case 3:
//                System.out.print("Enter the contact's email address: ");
//                String emailAddress = in.next();
//                searchEmail(emailAddress);
//                break;
//            case 4:
//                System.out.print("Enter the contact's address: ");
//                String address = in.next();
//                searchAddress(address);    
//                break;
//            case 5:
//                System.out.print("Enter the contact's Birthday: ");
//                String birthday = in.next();
//                searchBirthday(birthday);                                                       
//               }
//        }
//
//
//    }
//    public static Contact searchName(String name){
//  
//        while(!contacts_list.last()){
//            if (contacts_list.retrieve().getName().equalsIgnoreCase(name))
//                return contacts_list.retrieve();
//            
//            contacts_list.findnext();
//        }
//        
//        if (contacts_list.retrieve().getName().equalsIgnoreCase(name)){
//            return contacts_list.retrieve();
//        }
//        return null;
//        }
//    
//    public static void searchPhone(String phone){
//        
//        while(!contacts_list.last()){
//            if (contacts_list.retrieve().phonenumber.equals(phone))
//                System.out.println(contacts_list.retrieve());
//            
//            contacts_list.findnext();
//        }
//        if (contacts_list.retrieve().phonenumber.equals(phone)){
//                System.out.println(contacts_list.retrieve());
//                return;
//        }
//        System.out.println("The contact name is not exist");
//    }
//        
//    public static void searchEmail(String email){
//        LinkedList<Contact> l = new LinkedList<Contact>();
//        
//        while(!contacts_list.last()){
//            if (contacts_list.retrieve().getEmail().equalsIgnoreCase(email))
//                l.insert(contacts_list.retrieve());
//            
//            contacts_list.findnext();
//        }
//        if (contacts_list.retrieve().getEmail().equalsIgnoreCase(email))
//                l.insert(contacts_list.retrieve());
//        
//        if (l.empty()){
//            System.out.println("The contact email address is not exist");
//            return;
//        }
//        
//        //l.display();
//    }
// 
//   public static void searchAddress(String address){
//       LinkedList<Contact> l = new LinkedList<Contact>();
//        
//        while(!contacts_list.last()){
//            if (contacts_list.retrieve().getAddress().equalsIgnoreCase(address))
//                l.insert(contacts_list.retrieve());
//            
//            contacts_list.findnext();
//        }
//        if (contacts_list.retrieve().getAddress().equalsIgnoreCase(address))
//                l.insert(contacts_list.retrieve());
//        
//        if (l.empty()){
//            System.out.println("The contact email address is not exist");
//            return;
//        }
//        
//        l.display();
//    }
//   
//   public static void searchBirthday(String birthday){
//       LinkedList<Contact> l = new LinkedList<Contact>();
//        
//        
//        contacts_list.findfirst();
//        while(!contacts_list.last()){
//            if (contacts_list.retrieve().getBirthday().equals(birthday))
//                l.insert(contacts_list.retrieve());
//            
//            contacts_list.findnext();
//        }
//        if (contacts_list.retrieve().getBirthday().equals(birthday))
//                l.insert(contacts_list.retrieve());
//        
//        if (l.empty()){
//            System.out.println("The contact birthday is not exist");
//            return;
//        }
//        l.display();
//   }
//   
//   /*public static void deleteEvent(String title,String n){
//       
//       //delete event if it has no contact
//           if (events_list.empty())
//               return;
//           
//           events_list.findfirst();
//           while(!events_list.last())
//           {
//               if(events_list.retrieve().getTitle().equals(title)){
//                   events_list.remove();
//                   System.out.println("event is deleted");
//                   return;
//                }
//               
//               events_list.findnext();
//           }
//           if(events_list.retrieve().getTitle().equals(title)){
//                   events_list.remove();
//                   System.out.println("event is deleted");
//                   return;
//           }
//           else{
//               System.out.println("event it is not exist");
//           }
//           
//           //list of the contacts with this event
//            LinkedList<Contact> c = eventContacts(title);
//           
//           c.findfirst();
//           while(!c.empty()&&!c.last())
//           {
//               if (c.retrieve().getName().equals(n)){
//                   c.remove();
//                   
//                   break;
//               }
//               c.findnext();
//               
//               if(!c.empty()&& c.retrieve().getName().equals(n))
//                   c.remove();
//               
//           
//           }
//    
//   }*/
//   
//   
//   
//   
//   
//   
//   
//   
//   
//   /*public static void deleteContactEvents(String n,LinkedList<Event> l){
//       while(!l.empty())
//       {
//           String title = l.retrieve().getTitle();
//           deleteEvent(title,n);
//           l.remove();
//
//       }
//   }
//   
//   public static void deleteContact(){
//       System.out.print("Enter the contact name that you want to delete:");
//       in.nextLine();
//       String n = in.nextLine();
//       
//       if (contacts_list.empty()){
//           System.out.println("there is no contact to delete");
//           return;
//       }
//       contacts_list.findfirst();
//       
//       while (!contacts_list.last()){
//           if (contacts_list.retrieve().getName().equals(n)){
//               LinkedList<Event> l = contactEvents(n);
//               deleteContactEvents(n,l);              
//               contacts_list.remove();
//               System.out.println(n+"is deleted");
//               return;
//           }
//           contacts_list.findnext();
//       }
//       if (contacts_list.retrieve().getName().equals(n)){
//               contacts_list.remove();
//               System.out.println(n+" is deleted");
//           
//       }
//       else{
//           System.out.println("contact is not exist");
//       }
// }*/
// 
// public static void deleteContact()
//    {
//        Contact c = new Contact();
//        
//        System.out.print("Enter the contact\'s name: ");
//        c.name = in.nextLine();
//       
//        if (contacts_list.empty())
//            System.out.println("Contact not found!");
//        else
//        {
//            c = contacts_list.remove(c);
//            if ( c == null)
//                System.out.println("Contact not found!");
//            else
//            {
//                if (! c.events.empty())
//                {
//                Event e;
//                    c.events.findfirst();
//                    while ( !events_list.last())
//                    {
//                         e = c.events.retrieve();
//                        if (events_list.search(e))
//                        {
//                            Event c_event = events_list.retrieve();
//                            c_event.removeContact(c.name);
//                            if (c_event.contacts_names.empty())
//                            {
//                                events_list.remove(e);
//                                System.out.println("Delete event, No cantact particapate");
//                            }
//                            else
//                                events_list.update(c_event);
//                            
//                        }
//                        c.events.findnext();
//                    }
//                     e = c.events.retrieve();
//                        if (events_list.search(e))
//                        {
//                            Event c_event = events_list.retrieve();
//                            c_event.removeContact(c.name);
//                            if (c_event.contacts_names.empty())
//                            {
//                                events_list.remove(e);
//                                System.out.println("Delete event, No cantact particapate");
//                            }
//                            else
//                                events_list.update(c_event);
//                            
//                        }
//                System.out.println("Contact Deleted Successfully !");
//                System.out.println(c);
//            }    
//        
//        }       
//    }
// 
// 
// 
// 
// 
// 
//   
//   
//   
//   }
//   
////   public static boolean is_conflict(Event e , Contact c){
////       //LinkedList<Event> contact_events = c.getContact_Events();
////       //or
////       //LinkedList<Event> contact_events = c.Event_in_contact.events_in_event;
////       
////       if (contact_events.empty())
////           //System.out.println("emplty");
////           return false; //no conflict bec there ic not any events with this contact
////        
//////           System.out.println("c="+c);
//////           contact_events.display();
////            
////            contact_events.findfirst();
////            
////            while(!contact_events.last()){
////                if (e.getDate().equals(contact_events.retrieve().getDate()) && e.getTime().equals(contact_events.retrieve().getTime()))
////                        return true;
////                contact_events.findnext();
////            }
////               if (e.getDate().equals(contact_events.retrieve().getDate()) && e.getTime().equals(contact_events.retrieve().getTime()))
////                   return true;
////               else
////               {
////                   return false;
////               }
////       
////   }
// 
// public static boolean is_conflict(Event e){
//       if (!events_list.empty()) {
//        events_list.findfirst();
//        while (!events_list.last()) {
//            if ((events_list.retrieve().date.compareTo(e.date) == 0)
//                    && events_list.retrieve().time.equals(e.time)) {
//                return true; // Event with the same date and time already exists
//            }
//            events_list.findnext();
//        }
//
//        // Check the last event outside the loop
//        if ((events_list.retrieve().date.compareTo(e.date) == 0)
//                && events_list.retrieve().time.equals(e.time)) {
//            return true; // Event with the same date and time already exists
//        }
//    } return false;
//}
////schedule event  
//    public static void scheduleEvent(){
//          System.out.print("Enter the Event title:");
//          in.nextLine();
//          String title = in.nextLine() ;
//          System.out.print("Enter contact name:");
//          String cn = in.nextLine();
//          System.out.print("Enter event date and time:");
//          String d = in.next();
//          String t = in.next();
//          System.out.print("Enter event location:");
//          in.nextLine();
//          String loc = in.nextLine();
//          Contact c = searchName(cn);
//          Event e = new Event(title,d,t,loc,cn); 
//          if(c == null){
//            System.out.println("can not schedule this event bec this contact not exist");
//            return;
//       }
//       
//       if (c != null && !is_conflict(e) ){
//           System.out.println("\nEvent Schedule successfully");
//           //to add this event to this contact events
//           //c.getContact_Events().insertEvent(e);
//           //to add this contact to this event
//           e.contacts_names.insert(c.getName());
//           //for all
//           addEvent(e);
//           
//           
//           //added for requirements
//           //e.setContact_name(c.getName());
//           //c.getEvent() = e;
//          // c.getEvent().events_in_event.insertEvent(e);
//           //OR
//           //e.events_in_event.insertEvent(e);
//       }
//        else  
//       {
//           if(is_conflict(e))
//               System.out.println("there is conflict event");
//       }
//       
//       
//       
//   }
//// print event details 
//      public static void printEventDetails(){
//          System.out.println("Enter search criteria:\n1.contact name \n2.Event title\n");
//          System.out.println("Enter your choice");
//          int choice = in.nextInt();
//          switch(choice){
//              case 1:
//                  //Contact c = new Contact();
//                  System.out.print("Enter contact name:");
//                  //c.setName(in.nextLine());
//                  String cn = in.nextLine();
//                  Contact c = searchName(cn);
//                  //c.events.display();
//                  //LinkedList<Event>l = new LinkedList();//= .//contactEvents(cn);
//                  if (contacts_list.empty()){
//                  System.out.println("emplty list");
//                  break;
//                  }
//                  else{
//                      c.events.display();
//                }
//                  break;
//              case 2:
//                  System.out.print("Enter events title:");
//                  in.nextLine();
//                  String t = in.nextLine();
//                  Event e = searchTitle(t);
//                  if (e != null){
//                      System.out.println("Event found!");
//                      System.out.println(e);
//                  }
//                  else{
//                      System.out.println("Event not found");
//                  }
//                  break;
//          }
//                  
//      } 
//   
//
////print the contacts first name   
////    public static void printFirstName(){
////
////            System.out.print("Enter the first name:");
////            in.nextLine();
////            String fname = in.nextLine();
////
////            if (contacts_list.empty()){
////                System.out.println("No Contacts found !");
////                return;
////            }
////
////            contacts_list.findfirst();
////            int i =0;
////            String[] name = contacts_list.retrieve().getName().split(" ");
////            while(!contacts_list.last())   
////            {
////                if (name[i].equals(fname))
////                    System.out.println(contacts_list.retrieve() + "\n");
////                contacts_list.findnext();
////                i++;
////            }
////            if (name[i].equals(fname))
////                    System.out.println(contacts_list.retrieve() + "\n");
////        }
//    
//    public static void printFirstName(){
//       
//        System.out.print("Enter the first name:");
//        String fname = in.nextLine();
//        
//        if (contacts_list.empty())
//            System.out.println("No Contacts found !");
//        
//        contacts_list.findfirst();
//        while (!contacts_list.last())
//        {
//            String name = contacts_list.retrieve().name;
//            String [] All = name.split(" ");
//
//            if (All[0].compareToIgnoreCase(fname) == 0)
//                System.out.println(contacts_list.retrieve() + "\n");
//            contacts_list.findnext();
//        }
//        String name = contacts_list.retrieve().name;
//            String [] All = name.split(" ");
//
//            if (All[0].compareToIgnoreCase(fname) == 0)
//                System.out.println(contacts_list.retrieve() + "\n");
//        
//    }
//
////search for the event titlle if it will return the event if its exist or it will return null;
//   public static Event searchTitle(String n){
//       
//       if(events_list.empty())
//           return null;
//       
//       events_list.findfirst();
//       while(!events_list.last())
//       {
//           if (events_list.retrieve().getTitle().equals(n))
//               return events_list.retrieve();
//           
//           events_list.findnext();
//       }
//       
//       if (events_list.retrieve().getTitle().equals(n))
//           return events_list.retrieve();
//       
//       return null;
//     
//}
//   //add event if it is not exist in the event list
//   public static void addEvent(Event e){
//       
//       Event find = searchTitle(e.getTitle());
//       
//      if (find == null){
//           events_list.insert(e);
//       }
//
//        
//    } 
//   //return the Events in contact
////   public static LinkedList<Event> contactEvents(String n){
////       Contact c = searchName(n);
////       
////       if (c != null)
////           return c.getContact_Events();
////       return new LinkedList<Event>();
////       
////   }
//   
//   // return the Contacts with the Event
//   public static LinkedList<String> eventContacts(String n){
//       Event e = searchTitle(n);
//
//       if(e!= null)
//           return e.getContacts_names();
//       return new LinkedList<String>();
//       
//   }
//   
//   //Print all events alphabetically // O(n)
//    public static void printAllEvents(){
//        if (!events_list.empty())
//        {
//            events_list.findfirst();
//            
//            while(!events_list.last())
//            
//            {
//                System.out.println( " Event : " + events_list.retrieve().title);
//                events_list.findnext();
//            }
//            System.out.println( " Event : " + events_list.retrieve().title);
//                events_list.findnext();
//        }
//        else
//            System.out.println("No events found !");
//    }
//}