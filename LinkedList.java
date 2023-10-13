/**
 * LinkedList ADT: This class will represent the linked list data structure used to store the contacts. 
 It should have methods for adding, searching, and deleting contacts from the list.
**/

/**
 * @param <T>
 */

 public class LinkedList<T> {
    
    private Node<T> head;
    private Node<T> current;
    
    public LinkedList() {
        head = current = null;
        }
    
    public boolean empty() {
        return head == null;
        }
    
    public boolean last () {
        return current.next == null;
        }
    
    public boolean full () {
        return false; }
    
    public void findfirst () {
        current = head;
        }
    
    public void findnext () {
        current = current.next; }
    
    public T retrieve () {
        return current.data; }
    
    public void update (T val) {
        current.data = val; }
    
    public void insert(T c){
        
        Node<T> n = new Node<T> (c);
        if (empty()){
            current = head = n;  
        }
        else
            { 
                Node<T> tmp = head , ptmp =null;
                if((((Contact)c).compareTo((Contact)tmp.data))< 0)
                {
                    n.next = head;
                    head = current =  n;
                    
                }
                else
                {
                while(tmp!=null && (((Contact)c)).compareTo(((Contact)tmp.data))>= 0  )
                {
                    ptmp = tmp;
                    tmp = tmp.next;
                 }
                ptmp.next = n;
                n.next = tmp;
                current = n;
                } 
            }    
                
           
    }
    
    public void remove(){
        if (current == head)
        {
            head = head.next;
        }
        else
        {
            Node<T> tmp = head;
            
            while(tmp.next != current)
            {
                tmp = tmp.next;
            }
            tmp.next = current.next;
            
        }
        if (current.next == null)
        {
            current = head;
        }
        else
        {
            current = current.next;
        }
        
        
    }
    
    public boolean search(T c)
    {
                
    {
        Node<T> tmp = head;
        while (tmp != null){
            if (((Contact)tmp.data).compareTo((Contact)c)==0)
                return true;
            else{
                tmp = tmp.next;
            }
        }
        return false;
    }
    }
       

    
    
    public void insertAtEnd (T val) {
            if (empty()) {
                    current = head = new Node (val);
            }
            else {
                    while (current.next != null )
                        current = current.next;
                    
                    current.next = new Node (val);
                    current = current.next;
            }
           
    }

    
    public void tmp(Contact c){
        
        if (empty())
            System.out.println("empty");;
        
        Node<T> tmp  = head;
        System.out.println("tmp data"+tmp.data); 
        System.out.println(c);
        while ((tmp != null) && (tmp.data.equals(c))){
            tmp = tmp.next; 
           System.out.println(tmp.data);
        }
            
        
        if ((tmp != null) && (tmp.data.equals(c)))
        {
            current = tmp;
            System.out.println(tmp.data);;
        }
        
     
    }
    public void display() {
            findfirst();
            while(!last()){
                System.out.println(retrieve());
                findnext();
            }
            System.out.println(retrieve());
    }    
        
 }