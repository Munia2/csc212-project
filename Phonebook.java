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
                                "7. Print all events alphabetically\n" +
                                "8. Exit\n");
            
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
                    System.out.print("Enter the contact namethat you want to delete:");
                    in.nextLine();
                    String n = in.nextLine();
                    DeleteContact(n);
                    //DeleteContact();
                    break;
                
                case 4:
                    ScheduleEvent();
                    break;
                
                case 5:
                    PrintEvent();
                    break;
                    
                case 6:
                    PrintContactsFirstName();
                    break;
                    
                case 7:
                    PrintAllEvents();
                    break;
                    
                case 8:
                    System.out.println("Goodbye!");
                    break;
                case 9:
                    System.out.println("diplay contact list");
                    contacts_list.display();
                    break;
                default :
                    System.out.println("Try again");
            }
            System.out.println("\n");
        }while (choice != 8);
    }
    
    
    
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
        String notes = in.nextLine();
        
        Contact c = new Contact(cn,pn,ea,ca,bd, notes);
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
            System.out.println("Contact added successfully!");
        
        
        

    }
    

    public static void searchCriteria()
    {
        System.out.println("Enter search criteria:\n" +
                            "1. Name\n" +
                            "2. Phone Number\n" +
                            "3. Email Address\n" +
                            "4. Address\n" +
                            "5. Birthday");
        System.out.print("Enter your choice:");
        
        int choice = in.nextInt();
        if (contacts_list.empty())
            System.out.println("There is no contact");
        else
        {
            contacts_list.findfirst();
        switch(choice)
        {
            case 1:
                System.out.print("Enter the contact's name: ");
                    in.nextLine();
                    String name = in.nextLine();
                    searchName(name);
                                  
                break;
            
            case 2:
                System.out.print("Enter the contact's phone number:");
                   in.nextLine();
                   String phonenumber = in.nextLine();
                   searchPhone(phonenumber);
                    break;
                
            case 3:
                System.out.print("Enter the contact's email address: ");
                    
                   String emailaddress = in.next();
                   
                    searchEmail(emailaddress);
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
    public static void searchName(String name){
        
        contacts_list.findfirst();
        while(!contacts_list.last()){
            if (contacts_list.retrieve().getName().equals(name))
                System.out.println(contacts_list.retrieve());
            
            contacts_list.findnext();
        }
        if (contacts_list.retrieve().getName().equals(name)){
                System.out.println(contacts_list.retrieve());
                return;
        }
        
            System.out.println("The contact name is not exist");
        }
    
    public static void searchPhone(String phone){
        
        contacts_list.findfirst();
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
        
    public static void searchEmail(String e){
        LinkedList<Contact> res = new LinkedList<Contact>();
        
        contacts_list.findfirst();
        while(!contacts_list.last()){
            if (contacts_list.retrieve().getEmail().equals(e))
                res.insert(contacts_list.retrieve());
            
            contacts_list.findnext();
        }
        if (contacts_list.retrieve().getEmail().equals(e))
                res.insert(contacts_list.retrieve());
        
        if (res.empty()){
            System.out.println("The contact email address is not exist");
            return;
        }
        
        res.display();
    }
 
   public static void searchAddress(String address){
       LinkedList<Contact> res = new LinkedList<Contact>();
        
        
        contacts_list.findfirst();
        while(!contacts_list.last()){
            if (contacts_list.retrieve().getAddress().equals(address))
                res.insert(contacts_list.retrieve());
            
            contacts_list.findnext();
        }
        if (contacts_list.retrieve().getAddress().equals(address))
                res.insert(contacts_list.retrieve());
        
        if (res.empty()){
            System.out.println("The contact email address is not exist");
            return;
        }
        
        res.display();
        
        
   }
   
   public static void searchBirthday(String address){
       LinkedList<Contact> res = new LinkedList<Contact>();
        
        
        contacts_list.findfirst();
        while(!contacts_list.last()){
            if (contacts_list.retrieve().getBithday().equals(address))
                res.insert(contacts_list.retrieve());
            
            contacts_list.findnext();
        }
        if (contacts_list.retrieve().getBithday().equals(address))
                res.insert(contacts_list.retrieve());
        
        if (res.empty()){
            System.out.println("The contact birthday is not exist");
            return;
        }
        res.display();
   }
   
   public static void DeleteContact(String n){
       if (contacts_list.empty()){
           System.out.println("empty list");
           return;
       }
       contacts_list.findfirst();
       while (!contacts_list.last()){
           if (contacts_list.retrieve().getName().equals(n)){
               contacts_list.remove();
               System.out.println(n+"contact deleted");
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


    public static void ScheduleEvent()
    {
        Contact c = new Contact();
        Event e = new Event();
        
        boolean event_Updated = false;
        boolean Added_Event_To_Contact = false;
        
        System.out.print("Enter event title: ");
        in.nextLine();
        e.event_title = in.nextLine();
        
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
            Added_Event_To_Contact = c.addEvent(e);
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
            System.out.println("Cantcat not found !");
        
    }
    
    public static void PrintEvent(){
        
        System.out.println("Enter search criteria:");
        System.out.println("1. contact name");
        System.out.println("2. Event tittle");
        System.out.println("\nEnter your choice: ");
        int choice = in.nextInt();
        
        
        switch ( choice )
        {
            case 1:
            {
                Contact c = new Contact();
                System.out.print("Enter the contact name :  ");
                in.nextLine();
                c.setName(in.nextLine());
                        
                if (! contacts_list.empty() )
                {
                  if (contacts_list.search(c) == true)
                  {
                    System.out.println("Contact found !");
                    c = contacts_list.retrieve();

                    c.getEvents().findfirst();
                    
                    while(!c.getEvents().last())
                    
                    {
                        
                        Event e = ((Event)(c.getEvents()).retrieve());
                        if (!events_list.empty() && events_list.search(e))
                            System.out.println(events_list.retrieve());
                        c.getEvents().findnext();
                    }
                    if (c.getEvents().empty())
                        System.out.println("No events found for this contact !");
                     }
                else
                    System.out.println("Contact not found !");
                }
                else
                    System.out.println("Contact not found !");
            }
            break;

            case 2:
            {
                Event e = new Event();
                System.out.print("Enter the event title:  ");
                in.nextLine();
                e.event_title = in.nextLine();
                
                if (! events_list.empty() && events_list.search(e))
                {
                    System.out.println("Event found!");
                    System.out.println(events_list.retrieve());
                }
                else
                    System.out.println("Event not found !");
            }
            break;
        }
    }
    

    public static void PrintContactsFirstName(){
       
        System.out.print("Enter the first name:");
        in.nextLine();
        String fname = in.nextLine();
        
        if (contacts_list.empty())
            System.out.println("No Contacts found !");
        
        contacts_list.findfirst();
        
        while(!contacts_list.last())
        
        {
            String name = contacts_list.retrieve().getName();
            String [] All = name.split(" ");

            if (All[0].compareToIgnoreCase(fname) == 0)
                System.out.println(contacts_list.retrieve() + "\n");
            contacts_list.findnext();
        }
    }
    
    //7. Print all events alphabetically // O(n)
    public static void PrintAllEvents(){
        if (!events_list.empty())
        {
            events_list.findfirst();
            
            while(!events_list.last())
            
            {
                System.out.println( " Event : " + events_list.retrieve().event_title);
                events_list.findnext();
            }
        }
        else
            System.out.println("No events found !");
    }
}     

    