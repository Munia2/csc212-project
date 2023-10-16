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
    
    public void findfirst () {
        current = head;
        }
    
    public void findnext () {
        current = current.next; }
    
    public T retrieve () {
        return current.data; }
    
        public void insert(T c){
        
        Node<T> n = new Node<T> (c);
        if (empty()){
            current = head = n;  
        }
        else
            { 
                Node<T> p = head , q =null;
                
                if((((Contact)c).compareTo((Contact)p.data))< 0)    
                {
                    n.next = head;
                    head = current =  n;
                    
                }
                else
                {
                while(p!=null && (((Contact)c)).compareTo(((Contact)p.data))>= 0  )
                {
                    q = p;
                    p = p.next;
                 }
                q.next = n;
                n.next = p;
                current = n;
                } 
            }    
                
           
    }
        
        public void insertEvent(T e){
        
        Node<T> n = new Node<T> (e);
        if (empty()){
            current = head = n;  
        }
        else
            { 
                Node<T> p = head , q =null;
                
                if((((Event)e).compareTo((Event)p.data))< 0)    
                {
                    n.next = head;
                    head = current =  n;
                    
                }
                else
                {
                while(p!=null && (((Event)e)).compareTo(((Event)p.data))>= 0  )
                {
                    q = p;
                    p = p.next;
                 }
                q.next = n;
                n.next = p;
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

    
    public void display() {
        
        if (empty()){
            System.out.println("the list is empty");
            return;
        }
            findfirst();
            while(!last()){
                System.out.println(retrieve());
                findnext();
            }
            System.out.println(retrieve());
    }    
        
 }