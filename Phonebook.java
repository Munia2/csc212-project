/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author munia
 */

import java.util.*;
public class Phonebook {
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
        if ( contacts_list.search(c))
        {
                System.out.println("Contact name is already exist!");
                return;
        }
        if (!contacts_list.empty())
        {
            contacts_list.findfirst();
            
            while(!contacts_list.last())
            {
                    if (contacts_list.retrieve().getPhoneNumber().equals(c.getPhoneNumber()))
                    {
                            System.out.println("Contact number is alrady exist!");
                            return;
                    }
                    contacts_list.findnext();
            }
            if (contacts_list.retrieve().getPhoneNumber().equals(c.getPhoneNumber()))
                    {
                            System.out.println("Contact number is alrady exist!");
                            return;
                    }
        }
        
        contacts_list.insert(c);
        if (contacts_list.retrieve().equals(c))
            System.out.println("\n\nContact added successfully!");
            
        
        
        

    }
    

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
                searchPhone(phonenumber);
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
    
    public static void searchPhone(String phone){
        
        while(!contacts_list.last()){
            if (contacts_list.retrieve().getPhoneNumber().equals(phone))
                System.out.println(contacts_list.retrieve());
            
            contacts_list.findnext();
        }
        if (contacts_list.retrieve().getPhoneNumber().equals(phone)){
                System.out.println(contacts_list.retrieve());
                return;
        }
        System.out.println("The contact name is not exist");
    }
        
    public static void searchEmail(String email){
        LinkedList<Contact> l = new LinkedList<Contact>();
        
        while(!contacts_list.last()){
            if (contacts_list.retrieve().getEmail().equalsIgnoreCase(email))
                l.insert(contacts_list.retrieve());
            
            contacts_list.findnext();
        }
        if (contacts_list.retrieve().getEmail().equalsIgnoreCase(email))
                l.insert(contacts_list.retrieve());
        
        if (l.empty()){
            System.out.println("The contact email address is not exist");
            return;
        }
        
        l.display();
    }
 
   public static void searchAddress(String address){
       LinkedList<Contact> l = new LinkedList<Contact>();
        
        while(!contacts_list.last()){
            if (contacts_list.retrieve().getAddress().equalsIgnoreCase(address))
                l.insert(contacts_list.retrieve());
            
            contacts_list.findnext();
        }
        if (contacts_list.retrieve().getAddress().equalsIgnoreCase(address))
                l.insert(contacts_list.retrieve());
        
        if (l.empty()){
            System.out.println("The contact email address is not exist");
            return;
        }
        
        l.display();
    }
   
   public static void searchBirthday(String birthday){
       LinkedList<Contact> l = new LinkedList<Contact>();
        
        
        contacts_list.findfirst();
        while(!contacts_list.last()){
            if (contacts_list.retrieve().getBirthday().equals(birthday))
                l.insert(contacts_list.retrieve());
            
            contacts_list.findnext();
        }
        if (contacts_list.retrieve().getBirthday().equals(birthday))
                l.insert(contacts_list.retrieve());
        
        if (l.empty()){
            System.out.println("The contact birthday is not exist");
            return;
        }
        l.display();
   }
   
   public static void deleteEvent(String title,String n){
       
       //delete event if it has no contact
           if (events_list.empty())
               return;
           
           events_list.findfirst();
           while(!events_list.last())
           {
               if(events_list.retrieve().getTitle().equals(title)){
                   events_list.remove();
                   System.out.println("event is deleted");
                   return;
                }
               
               events_list.findnext();
           }
           if(events_list.retrieve().getTitle().equals(title)){
                   events_list.remove();
                   System.out.println("event is deleted");
                   return;
           }
           else{
               System.out.println("event it is not exist");
           }
           
           //list of the contacts with this event
            LinkedList<Contact> c = eventContacts(title);
           
           c.findfirst();
           while(!c.empty()&&!c.last())
           {
               if (c.retrieve().getName().equals(n)){
                   c.remove();
                   
                   break;
               }
               c.findnext();
               
               if(!c.empty()&& c.retrieve().getName().equals(n))
                   c.remove();
               
           
           }
    
   }
   
   //delete the contact events
   public static void deleteContactEvents(String n,LinkedList<Event> l){
       while(!l.empty())
       {
           String title = l.retrieve().getTitle();
           deleteEvent(title,n);
           l.remove();

       }
   }
   
   public static void deleteContact(){
       System.out.print("Enter the contact name that you want to delete:");
       in.nextLine();
       String n = in.nextLine();
       
       if (contacts_list.empty()){
           System.out.println("there is no contact to delete");
           return;
       }
       contacts_list.findfirst();
       while (!contacts_list.last()){
           if (contacts_list.retrieve().getName().equals(n)){
               LinkedList<Event> l = contactEvents(n);
               deleteContactEvents(n,l);
               contacts_list.remove();
               System.out.println(n+"is deleted");
               return;
           }
           contacts_list.findnext();
       }
       if (contacts_list.retrieve().getName().equals(n)){
               contacts_list.remove();
               System.out.println(n+" is deleted");
           
       }
       else{
           System.out.println("contact is not exist");
       }
   }
   
   public static boolean is_conflict(Event e , Contact c){
       LinkedList<Event> contact_events = c.getContact_Events();
       //or
       //LinkedList<Event> contact_events = c.Event_in_contact.events_in_event;
       
       if (contact_events.empty())
           //System.out.println("emplty");
           return false; //no conflict bec there ic not any events with this contact
        
//           System.out.println("c="+c);
//           contact_events.display();
            
            contact_events.findfirst();
            
            while(!contact_events.last()){
                if (e.getDate().equals(contact_events.retrieve().getDate()) && e.getTime().equals(contact_events.retrieve().getTime()))
                        return true;
                contact_events.findnext();
            }
               if (e.getDate().equals(contact_events.retrieve().getDate()) && e.getTime().equals(contact_events.retrieve().getTime()))
                   return true;
               else
               {
                   return false;
               }
       
   }
//   
    public static void scheduleEvent(){
          System.out.print("Enter the Event title:");
          in.nextLine();
          String title = in.nextLine() ;
          System.out.print("Enter contact name:");
          String cn = in.nextLine();
          System.out.print("Enter event date and time:");
          String d = in.next();
          String t = in.next();
          System.out.print("Enter event location:");
          in.nextLine();
          String loc = in.nextLine();
          Contact c = searchName(cn);
          Event e = new Event(title,d,t,loc,c); 
       if(c == null){
           System.out.println("can not schedule this event bec this contact not exist"+e.contacts.retrieve().getName());
           return;
       }
       
       if (c != null && !is_conflict(e, c) ){
           System.out.println("\nEvent Schedule successfully");
           //to add this event to this contact events
           c.getContact_Events().insertEvent(e);
           //to add this contact to this event
           e.getContacts().insert(c);
           //for all
           addEvent(e);
           
           
           //added for requirements
           //e.setContact_name(c.getName());
           //c.getEvent() = e;
          // c.getEvent().events_in_event.insertEvent(e);
           //OR
           //e.events_in_event.insertEvent(e);
       }
        else  
       {
           if(is_conflict(e, c))
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
                  System.out.print("Enter contact name:");
                  in.nextLine();
                  String cn = in.nextLine();
                  LinkedList<Event>l = contactEvents(cn);
                  if (l.empty()){
                  System.out.println("emplty list");
                  }
                  else{
                    l.display();
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
   

//print the contacts first name   
    public static void printFirstName(){

            System.out.print("Enter the first name:");
            in.nextLine();
            String fname = in.nextLine();

            if (contacts_list.empty()){
                System.out.println("No Contacts found !");
                return;
            }

            contacts_list.findfirst();
            int i =0;
            String[] name = contacts_list.retrieve().getName().split(" ");
            while(!contacts_list.last())   
            {
                if (name[i].equals(fname))
                    System.out.println(contacts_list.retrieve() + "\n");
                contacts_list.findnext();
                i++;
            }
            if (name[i].equals(fname))
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
           events_list.insertEvent(e);
       }

        
    } 
   //return the Events in contact
   public static LinkedList<Event> contactEvents(String n){
       Contact c = searchName(n);
       
       if (c != null)
           return c.getContact_Events();
       return new LinkedList<Event>();
       
   }
   
   // return the Contacts with the Event
   public static LinkedList<Contact> eventContacts(String n){
       Event e = searchTitle(n);

       if(e!= null)
           return e.getContacts();
       return new LinkedList<Contact>();
       
   }
   
   //Print all events alphabetically // O(n)
    public static void printAllEvents(){
        if (!events_list.empty())
        {
            events_list.findfirst();
            
            while(!events_list.last())
            
            {
                System.out.println( " Event : " + events_list.retrieve().title);
                events_list.findnext();
            }
            System.out.println( " Event : " + events_list.retrieve().title);
                events_list.findnext();
        }
        else
            System.out.println("No events found !");
    }
}
//   public static void printContactsName(){
//       
//   }
//   
//   public static void printEvents(){
//       
//   }
   
   

   
//   public static boolean searchEvent(String title){
//       return true;
//   } 
   
   
       

 //public boolean addEvent(Event e){
//ifsreach(! found)
//        events_list.insert(e);
//        if (events_list.retrieve().equals(e))
//            System.out.println("");
//        
//        System.out.println("");

   //   public static void print_LinkedList_of_all_contacts(LinkedList<Contact> l){
//       if (l.empty()){
//           System.out.println("emplty list");
//       }
//       else{
//           l.display();
//       }
//           l.findfirst();
//           while(!l.last())
//           {
//               System.out.println(l.retrieve());
//               System.out.println("");
//               l.findnext();
//               
//           }
//               l.retrieve();
//               System.out.println("");
//           
//       }
   
//           l.findfirst();
//           while(!l.last())
//           {
//               System.out.println(l.retrieve());
//               System.out.println("this event has the following contact");
//               //System.out.println(l.retrieve().getcontacts_with_evnt.display);
//               print_LinkedList_of_all_contacts(l.retrieve().getContacts_with_events());
//               System.out.println("");
//               l.findnext();
//               
//           }
//               System.out.println(l.retrieve());
//               System.out.println("this event has the following contact");
//                print_LinkedList_contacts_by_name(l.retrieve().getContacts_with_events());
//                System.out.println("");
//                l.findnext();
//       }
   
   
   
//   public static void print_LinkedList_contacts_by_name(LinkedList<Contact>l){
//       if (l.empty())
//           System.out.println("empty list");
//       else{
//           l.findfirst();
//           while(!l.last())
//           {
//               System.out.println(l.retrieve().getName());
//               System.out.println("");
//               l.findnext();
//           }
//           
//           System.out.println(l.retrieve().getName());
//           System.out.println("");
//       }
//   }
   //or
   
   ////////////////////added methods for schedulling Events//////////////////////


    /*public static void ScheduleEvent()
    {
        Contact c = new Contact();
        Event e = new Event();
        
        boolean event_Updated = false;
        boolean Added_Event_To_Contact = false;
        
        System.out.print("Enter event title: ");
        in.nextLine();
        e.title = in.nextLine();
        
        System.out.print("Enter contact name: ");
        c.setName(in.nextLine());
        
       if ( ! contacts_list.empty() && contacts_list.search(c) )
        {
            System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
           e.setDate(in.next());
           
            System.out.print("Enter event location: ");
            in.nextLine();
            e.location = in.nextLine();
            
           c = contacts_list.retrieve();
            Added_Event_To_Contact = c.insert(e);
            if (Added_Event_To_Contact)
            {
                // event added to contact
                contacts_list.update(c);
                if (!events_list.empty() && events_list.search(e))
                {
                    Event eventFound = events_list.retrieve();
                    if ((eventFound.date.compareTo(e.date)== 0 ) 
                            && (eventFound.time.compareTo(e.time)== 0 ) 
                            && (eventFound.location.compareTo(e.location)== 0 ))
                    {
                        eventFound.contacts_names.insert(c.getName());
                        events_list.update(eventFound);
                        event_Updated = true;
                    }
                }
                if (! event_Updated)  
                {
                    e.contacts_names.insert(c.getName());
                    events_list.insert(e);
                }
                System.out.println("Event scheduled successfully!   ");
            }
            else
                System.out.println("Contact has conflict Event !  ");
        }
        else
            System.out.println("Contact not found !");
        
    }*/
    
    
//    public static void PrintEvent(){
//        
//        System.out.println("Enter search criteria:");
//        System.out.println("1. contact name");
//        System.out.println("2. Event tittle");
//        System.out.println("\nEnter your choice: ");
//        int choice = in.nextInt();
//        
//        
//        switch ( choice )
//        {
//            case 1:
//            {
//                Contact c = new Contact();
//                System.out.print("Enter the contact name :  ");
//                in.nextLine();
//                c.setName(in.nextLine());
//                        
//                if (! contacts_list.empty() )
//                {
//                  if (contacts_list.search(c) == true)
//                  {
//                    System.out.println("Contact found !");
//                    c = contacts_list.retrieve();
//
//                    c.getEvents().findfirst();
//                    
//                    while(!c.getEvents().last())
//                    
//                    {
//                        
//                        Event e = ((Event)(c.getEvents()).retrieve());
//                        if (!events_list.empty() && events_list.search(e))
//                            System.out.println(events_list.retrieve());
//                        c.getEvents().findnext();
//                    }
//                    if (c.getEvents().empty())
//                        System.out.println("No events found for this contact !");
//                     }
//                else
//                    System.out.println("Contact not found !");
//                }
//                else
//                    System.out.println("Contact not found !");
//            }
//            break;
//
//            case 2:
//            {
//                Event e = new Event();
//                System.out.print("Enter the event title:  ");
//                in.nextLine();
//                e.event_title = in.nextLine();
//                
//                if (! events_list.empty() && events_list.search(e))
//                {
//                    System.out.println("Event found!");
//                    System.out.println(events_list.retrieve());
//                }
//                else
//                    System.out.println("Event not found !");
//            }
//            break;
//        }
//    }
//    
//
    
    
    

    