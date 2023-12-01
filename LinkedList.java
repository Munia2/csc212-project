/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author munia
 */
public class LinkedList<T> {
    private Node<T> head;
    private Node<T> current;
    
    public LinkedList () {
        head = current = null;
    }
    public boolean empty () {
        return head == null;
    }
    public boolean last () {
        return current.next == null;
    }
    public void findfirst () {
        current = head;
    }
    public void findnext () {
        current = current.next;
    }
    public T retrieve () {
        return current.data;
    }
    public void update (T val) {
        current.data = val;
    }
    

    public void sortedContact(T c){
        
        Node<T> n = new Node<T> (c);
        if (empty()){
            current = head = n;  
        }
        else
            { 
                Node<T> p = head , q =null;
                
                if((((Contact)c).compareTo((Contact)head.data))< 0)    
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

    public void sortedEvent(T e){
        
        Node<T> n = new Node<T> (e);
        if (empty()){
            current = head = n;  
        }
        else
            { 
                Node<T> p = head , q =null;
                
                if((((Event)e).compareTo((Event)head.data))< 0)    
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

    public void insert(T val){

        Node<T> tmp;
        if (head == null) {
            current = head = new Node<T> (val);
        }
        else {
            tmp = current.next;
            current.next = new Node<T> (val);
            current = current.next;
            current.next = tmp;
        }
    }
            
    
        
    public boolean search(T val) {
        if (head == null)
            return false;

        Node<T> tmp = head;
        boolean found = false;

        while (tmp != null) {
            if (tmp.data.equals(val)) {
                current = tmp;
                found = true;
                break;          }
            tmp = tmp.next;
        }

        return found;
    }
            
    public T remove (T r) {
            
        if (!search (r))
            return null;

        T data = current.data;
        
        if (current == head) {
            head = head.next;
        }
        else {
            Node<T> tmp = head;

            while (tmp.next != current)
                tmp = tmp.next;
            tmp.next = current.next;
        }
        if (current.next == null)
            current = head;
        else
            current = current.next;
        return data;    
    }
        

    public void display(){
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

