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

    public static BST contacts_list = new BST();
    public static LinkedList<Event> events_list  = new LinkedList<Event>();
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        
   
        
        
        char choice;
        System.out.println("Welcome to the BST Phonebook!");
        do{
            
            System.out.println( "Please choose an option:\n" +
                                "1. Add a contact\n" +
                                "2. Search for a contact\n" +
                                "3. Delete a contact\n" +
                                "4. Schedule an event\n" +
                                "5. Print event details\n" +
                                "6. Print contacts by first name\n" +
                                "7. Print all events alphabetically\n"+
//                                "8. Print all contacts\n"+
                                "8. Exit\n");
            
            System.out.print("Enter your choice:");
          //  in.nextLine();
            choice = in.next().charAt(0);
            System.out.println("");
            switch (choice)
            {
                case '1':
                    addContact();
                    break;
                
                case '2':
                    searchCriteria();
                    break;
                
                case '3':
                    deleteContact();
                    break;
                
                case '4':
                              
                    scheduleEvent();
                    break;
                
                case '5':
                    printEventDetails();
                    break;
                    
                case '6':
                    printFirstName();
                    break;
                    
                case '7':
                    printEvents();
                    break;
                    
//                case '8':
//                    if (contacts_list.isEmpty())
//                       System.out.println("The tree is empty");
//                    else {
//                       System.out.println("Contact list:");
//                       contacts_list.traverse();
//                    }   
//                    break;
                    
                case '8':
                    System.out.println("Goodbye!");
                    break;  
                default:
                    System.out.println("Invliad choice, please enter a choice from 1 to 8 ");  
            }
            System.out.println("\n");
        }while (choice != '8');
    }
    
    
    public  static void addContact(){
        
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
        
        if (!contacts_list.isEmpty())
        {
            if (searchPhone(contacts_list.root,pn) != null && searchName(contacts_list.root,cn) != null)
                System.out.println("\nContact name and phone number is already exist!"); 
            else if (searchPhone(contacts_list.root,pn) != null)
                System.out.println("\nContact phone number is already exist!");
            else if (contacts_list.insert(cn,c)) 
                    System.out.println("\n\nContact added successfully!");
                 else
                    System.out.println("\nContact name is already exist!");
        }
        else
            contacts_list.insert(cn,c);
//                System.out.println("\n\nContact added successfully!");
    }
//            if ( searchName(contacts_list.root,cn) != null || searchPhone(contacts_list.root,pn) != null){
//                System.out.println("Contact is already exist!");
//                return;
//            }
//            if (contacts_list.insert(cn,c)) 
//                System.out.println("\n\nContact added successfully!");  
    
        

    public static void searchCriteria(){
        if (contacts_list.isEmpty())
            System.out.println("There is no contact!");
        else{
        System.out.println("Enter search criteria:\n" +
                            "1. Name\n" +
                            "2. Phone Number\n" +
                            "3. Email Address\n" +
                            "4. Address\n" +
                            "5. Birthday");
        System.out.print("\nEnter your choice:");
//      in.nextLine();
        char choice = in.next().charAt(0);
        switch(choice)
        {
            case '1':
                System.out.print("\nEnter the contact's name: ");
                in.nextLine();
                String name = in.nextLine();
                if (searchName(contacts_list.root,name) == null)
                    System.out.println("\nThe contact name is not exist!");
                else{
                    System.out.println("\nContact found!");
                    contacts_list.printBSTNode(searchName(contacts_list.root, name));
                    }
                break;
            
            case '2':
                System.out.print("Enter the contact's phone number:");
                in.nextLine();
                String phonenumber = in.nextLine();
                if (searchPhone(contacts_list.root,phonenumber) == null)
                    System.out.println("\nThe contact phone number is not exist!");
                else{
                    System.out.println("\nContact found!");
                    contacts_list.printBSTNode(searchPhone(contacts_list.root, phonenumber));
                    }
                break;
                
            case '3':
                System.out.print("Enter the contact's email:");
                in.nextLine();
                String email = in.nextLine();
                if (searchEmail(contacts_list.root,email) == null)
                    System.out.println("\nThe contact email is not exist!");
                else{
                    System.out.println("\nContacts found!");
                    searchPrintEmail(contacts_list.root, email); 
                }

                break;
            case '4':
                System.out.print("Enter the contact's address: ");
                String address = in.next();
                if (searchAddress(contacts_list.root,address) == null)
                    System.out.println("\nThe contact address is not exist!");
                else{
                    System.out.println("\nContacts found!");
                    searchPrintAddress(contacts_list.root, address); 
                    }   
                break;
            case '5':
                System.out.print("Enter the contact's Birthday: ");
                String birthday = in.next();
                if (searchBirthday(contacts_list.root,birthday) == null)
                    System.out.println("\nThe contact birthday is not exist!");
                else{
                    System.out.println("\nContacts found!");
                    searchPrintBirthday(contacts_list.root, birthday);
                }
                break;
            default:
                System.out.println("\nInvliad choice");      
            }
        }
    }
       
    public static BSTNode searchName(BSTNode p, String name){
        if (p==null)
            return null;
        else
            if((contacts_list.retrieve(p).getName().toLowerCase().compareTo(name.toLowerCase()))> 0) 
                return searchName(p.left,name);
            else 
                if ((contacts_list.retrieve(p).getName().toLowerCase().compareTo(name.toLowerCase()))< 0)
                    return searchName(p.right,name);
                else 
                    return p; 
       }
        
        
    public static BSTNode searchPhone(BSTNode p, String pn){
        BSTNode q;
        if (p==null) 
            return null;
        else 
            if (contacts_list.retrieve(p).getPhonenumber().equals(pn))
                return p;
            else
                q= searchPhone(p.left,pn);
            if(q!=null)
                return q;
            else
                return searchPhone(p.right,pn);     
      }
    
        
    public static BSTNode searchEmail(BSTNode p, String email){
        BSTNode q;
        if (p==null) 
            return null;
        else 
            if (contacts_list.retrieve(p).getEmail().equalsIgnoreCase(email))
                return p;
            else
                q= searchEmail(p.left,email);
            if(q!=null)
                return q;
            else 
                return searchEmail(p.right,email);          
    }
    
    //
    
    public static void searchPrintEmail(BSTNode p, String email){
        if (p!=null) {      
            if (p.left !=null) 
                searchPrintEmail(p.left,email);            
        if (contacts_list.retrieve(p).getEmail().equalsIgnoreCase(email))
            contacts_list.printBSTNode(p);           
        if (p.right !=null) 
            searchPrintEmail(p.right,email);}         
    }    
    //
    public static BSTNode searchAddress(BSTNode p, String address){
        BSTNode q;
        if (p==null) 
            return null;
        else 
            if (contacts_list.retrieve(p).getAddress().equalsIgnoreCase(address))
                return p;
            else      
                q= searchAddress(p.left,address);
            if(q!=null)
               return q;
            else 
                return searchAddress(p.right,address);       
    }     
    //
    
    public static void searchPrintAddress(BSTNode p, String address){
        if (p!=null) {       
            if (p.left !=null) searchPrintAddress(p.left,address);            
                if (contacts_list.retrieve(p).getAddress().equalsIgnoreCase(address))
                    contacts_list.printBSTNode(p);           
        if (p.right !=null) 
            searchPrintAddress(p.right,address);}
    }

    
    //
    
    public static BSTNode searchBirthday(BSTNode p, String birthday){
        BSTNode q;
        if (p==null) 
            return null;
        else 
            if (contacts_list.retrieve(p).getBirthday().equals(birthday))
                return p;
            else
                q= searchBirthday(p.left,birthday);
            if(q!=null)
                return q;
            else 
                return searchBirthday(p.right,birthday);        
   }   
   //    
    public static void searchPrintBirthday(BSTNode p, String birthday){
        if (p!=null) {
            if (p.left !=null) 
                searchPrintBirthday(p.left,birthday);
            
            if (contacts_list.retrieve(p).getBirthday().equals(birthday))
                contacts_list.printBSTNode(p);

           
            if (p.right !=null) 
                searchPrintBirthday(p.right,birthday);}         
    }    
    //   
    public static Event searchTitle(String n){
       
        if(events_list.empty())
            return null;
       
       events_list.findfirst();
       while(!events_list.last()){
            if (events_list.retrieve().getTitle().equalsIgnoreCase(n))
                return events_list.retrieve();
           
            events_list.findnext();
        }       
        if (events_list.retrieve().getTitle().equalsIgnoreCase(n))
            return events_list.retrieve();
       
        return null;     
    }
   
 
    public static void deleteContact(){
        
        if (contacts_list.isEmpty())
            System.out.println("No contacts are available!");
        else {
            BSTNode p; /* = new Contact();*/
            System.out.print("Enter the contact\'s name: ");
            in.nextLine();
            p = searchName(contacts_list.root, in.nextLine());
            if ( p == null)
                System.out.println("Contact does not exist!");
            else {
                contacts_list.remove_key(p.key);
                System.out.println("Contact deleted successfully!");
                if (!contacts_list.retrieve(p).getEvents().empty()){
                    Event e;               
                    contacts_list.retrieve(p).getEvents().findfirst();
                    while ( ! contacts_list.retrieve(p).getEvents().last()){
                        e =  contacts_list.retrieve(p).getEvents().retrieve();
                        if (events_list.search(e)){
                            Event c_event = events_list.retrieve();
                            c_event.getContacts_names().remove(p.key);
                            events_list.remove(e);
                            if (c_event.getContacts_names().empty()){
                                System.out.println("Contact's event "+e.getTitle() +" is also deleted");
                            }
                        }
                        contacts_list.retrieve(p).getEvents().findnext();
                    }
                    e =  contacts_list.retrieve(p).getEvents().retrieve();
                    if (events_list.search(e)){
                        Event c_event = events_list.retrieve();
                        c_event.getContacts_names().remove(p.key);
                        events_list.remove(e);
                        if (c_event.getContacts_names().empty()){
                            System.out.println("Contact's event "+e.getTitle() +" is also deleted");
                        }
                    } 

                }       
            }
        }
    }
   

    public static boolean is_conflict(Event e, Contact c){        
        LinkedList<Event> contact_events = c.getEvents();
        if (!contact_events.empty()){
            contact_events.findfirst();
            while(!contact_events.last()){
                if (e.getDate().equals(contact_events.retrieve().getDate()) && e.getTime().equals(contact_events.retrieve().getTime()))
                    return true;
                contact_events.findnext();
            }
            if (e.getDate().equals(contact_events.retrieve().getDate()) && e.getTime().equals(contact_events.retrieve().getTime()))
                return true;
            else              
                return false;
       }
       return false;            
    }
    
    public static void addEvent(Event e, Contact c){      
        events_list.sortedEvent(e);  
        c.getEvents().insert(e);       
    } 
    
    public static void scheduleEvent(){
        if (!contacts_list.isEmpty()){
            System.out.println("Enter type: \n1.Event \n2.Appointment");
            boolean type;
//          in.nextLine();
            System.out.print("\nEnter your choice:"); 
            char eventType= in.next().charAt(0);
            String title, cn,d,t,loc;
            Contact c;
            Event e;
            switch (eventType) {
                case '1':
                    type=true; //event
                    System.out.print("Enter the event title:");
                    in.nextLine();
                    title = in.nextLine() ;
                    System.out.print("Enter contact name or names seperated by a comma: ");
                    cn = in.nextLine();
                    String[] names = cn.split(",");
                    System.out.print("Enter event date and time(MM/DD/YYYY HH:MM):");
                    d = in.next();
                    t = in.next();
                    System.out.print("Enter event location:");
                    in.nextLine();
                    loc= in.nextLine();
                    if (names.length > 1) {
                        for (String n:names){
                            if (searchName(contacts_list.root,n)!=null)
                                c = contacts_list.retrieve(searchName(contacts_list.root,n));
                            else {
                                System.out.println("\n( "+n+" ) this contact does not exist!");
                                continue;
                            }
                            e = new Event(type,title,d,t,loc,n);
                            if (searchTitle(title) != null && searchTitle(title).getType() == type){
                                e.setContacts_names(searchTitle(title).getContacts_names());
                            }
                            if ( !is_conflict(e,c) ){
                                e.getContacts_names().insert(n);
                                addEvent(e,c);
                                System.out.println("\nEvent Scheduled successfully for the contact ( "+ n +" )!");
                            }
                            else  
                                System.out.println("\nThere is an event/appointment in the same date and time!");
                        }
                    } 
                    else{
                        if (searchName(contacts_list.root,cn)!=null)
                            c = contacts_list.retrieve(searchName(contacts_list.root,cn));
                        else {
                            System.out.println("( "+cn+" ) this contact does not exist!");
                            return;
                        }
                        e = new Event(type,title,d,t,loc,cn);
                        if (searchTitle(title) != null && searchTitle(title).getType() == type){
                            e.setContacts_names(searchTitle(title).getContacts_names());
                        }
                        if ( !is_conflict(e,c) ){
                            e.getContacts_names().insert(cn);
                            addEvent(e,c);
                            System.out.println("\nEvent Scheduled successfully!");
                        }
                        else  
                            System.out.println("There is an event/appointment in the same date and time!");  
                    }
                    break;
                  
                case '2':
                    type=false; // appointment
                    System.out.print("Enter the appointment title:");
                    in.nextLine();
                    title = in.nextLine() ;
                    if (!type && searchTitle(title)!=null && searchTitle(title).getType()==type)
                        System.out.print("The appointment ( "+title+" ) is already exists!");

                    else {
                        System.out.print("Enter contact name:");
                        cn = in.nextLine();
                        System.out.print("Enter appointment date and time(MM/DD/YYYY HH:MM):");
                        d = in.next();
                        t = in.next();
                        System.out.print("Enter appointment location:");
                        in.nextLine();
                        loc = in.nextLine();
                        if (searchName(contacts_list.root,cn)!=null)
                            c = contacts_list.retrieve(searchName(contacts_list.root,cn));
                        else {
                            System.out.println("This contact does not exist!");
                            return;
                        }
                        e = new Event(type,title,d,t,loc,cn);
                        if (searchTitle(title) != null && searchTitle(title).getType() == type){
                            e.setContacts_names(searchTitle(title).getContacts_names());
                        }
                        if ( !is_conflict(e,c) ){
                            e.getContacts_names().insert(cn);
                            addEvent(e,c);
                            System.out.println("\nAppointment Scheduled successfully!");
                        }
                        else  
                            System.out.println("\nThere is an event/appointment in the same date and time!");
                    }
                    break;
                default:
                    System.out.println("Invliad type");
//                  return;
            }
        } 
        else 
            System.out.println("the contact tree is empty");    
    }
 
    public static void printEventDetails(){
        if (!contacts_list.isEmpty() && !events_list.empty()){
            System.out.println("\nEnter search criteria:\n1.contact name \n2.Event title");
            System.out.print("\nEnter your choice:");
            int choice = in.nextInt();
            switch(choice){
                case 1:                 
                    System.out.print("\nEnter contact name:");
                    in.nextLine();
                    String cn = in.nextLine();

                    if (contacts_list.isEmpty()){                 
                        System.out.println("\nEmpty list");
                        return;
                    }
                    //if ( contacts_list.retrieve(searchName(contacts_list.root,cn)) == null)
                    if ( searchName(contacts_list.root,cn) == null)
                        System.out.println("\nContact is not exist!");
                    else{
                        System.out.println("\nContact found!");
                        Contact c = contacts_list.retrieve(searchName(contacts_list.root,cn));
                        c.getEvents().display();                                 
                    }
                    break;
                case 2:
                    System.out.print("\nEnter events title:");
                    in.nextLine();
                    String t = in.nextLine();
//                  Event e;
                    if (searchTitle(t) != null){
                        Event e = searchTitle(t);
                        System.out.println("\nEvent found!");
                        System.out.print("\nThe contacts attached with this event: ");
                        e.getContacts_names().display();
                        while(!events_list.last()){
                            if (events_list.retrieve().getTitle().equalsIgnoreCase(e.getTitle())) 
                                System.out.println(events_list.retrieve());
                            events_list.findnext();
                        }
                        if (events_list.retrieve().getTitle().equalsIgnoreCase(e.getTitle()))
                            System.out.println(events_list.retrieve());                                                      
                    }
                    else 
                        System.out.println("\nEvent not found");
                    break;
            }
        }
        else 
            System.out.println( "\nNo events have been scheduled yet!");         
    } 
    
    public static BSTNode searchFirstName(BSTNode p, String fname){
        if (p==null)
            return null;
        else {
            String names[] = contacts_list.retrieve(p).getName().split(" ");
           
            if((names[0].toLowerCase().compareTo(fname.toLowerCase()))> 0) 
                return searchFirstName(p.left,fname);
            else 
                if ((names[0].toLowerCase().compareTo(fname.toLowerCase()))< 0)
                    return searchFirstName(p.right,fname);
                else 
                    return p; 
         }

    }
   
    public static void printBSTFirstName(BSTNode p, String fname){
                
        if (p.left!=null)
            printBSTFirstName(p.left,fname);
       
        String names[] = contacts_list.retrieve(p).getName().split(" ");
        if (names[0].equalsIgnoreCase(fname)){
            System.out.println(contacts_list.retrieve(p) + "\n");            
        }
        
        if (p.right!=null)
         printBSTFirstName(p.right,fname);          
        //return printed;             
    }
  
    public static void printFirstName(){      
        if (contacts_list.isEmpty())
            System.out.println("No Contacts found !");
        else{
            System.out.print("Enter the first name:");
            in.nextLine();
            String fname = in.nextLine();
            
            printBSTFirstName(contacts_list.root, fname);
            
            if (searchFirstName(contacts_list.root,fname) == null)
                System.out.println("No name start with "+fname+" !");
        }
    }   
    
    public static void printEvents(){
        if (!events_list.empty())
        {
            events_list.findfirst();
            String t = events_list.retrieve().getTitle();
            System.out.println(t);
            if(events_list.last())
                return;
            events_list.findnext();
            while(!events_list.last()){
                if (!events_list.retrieve().getTitle().equalsIgnoreCase(t)){
                    System.out.println(events_list.retrieve().getTitle());
                    t = events_list.retrieve().getTitle();
                }
                events_list.findnext();
            }
            if (!events_list.retrieve().getTitle().equalsIgnoreCase(t))
                System.out.println(events_list.retrieve().getTitle());
        }
        else
            System.out.println("Empty list!");
    }
}

