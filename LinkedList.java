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
    

public void sorted(T c){
        
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

        public void insert(T val){

        Node<T> tmp;
        if (empty()) {
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

    Node<T> node = head;
    boolean found = false;
    
    while (node != null) {
        if (node.data.equals(val)) {
            current = node;
            found = true;
            break;  // Exit the loop when the value is found
        }
        node = node.getNext();
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
                Node tmp = head;

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

/*public void insertEvent(T e){
        
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
                
           
    }*/


//public boolean search(T c)
//    {
//       Node<T> tmp = head;
//        while (tmp != null){
//            if (((Contact)tmp.data).compareTo((Contact)c)==0)
//                return true;
//            else{
//                tmp = tmp.next;
//            }
//        }
//        return false;
//    }

//       public void printAll() {
//    Node<T> currentNode = head;
//    while (currentNode != null) {
//        System.out.print(currentNode.getData() + "    ");
//        currentNode = currentNode.getNext();
//    }
//    System.out.println();
//}

//    public void insertAtEnd (T val) {
//            if (empty()) {
//                    current = head = new Node (val);
//            }
//            else {
//                    while (current.next != null )
//                        current = current.next;
//                    
//                    current.next = new Node (val);
//                    current = current.next;
//            }
//            size++;
//    }

   /*public boolean insert(T val) {
    Node<T> tmp = new Node<>(val);

    if (empty()) {
        head = current = tmp;
    } else {
        current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(tmp);
        current = tmp;
    }

    size++;
    return true;
}*/
    
//    private Node<T> head;
//    private Node<T> current;
//    int size;
//    
//    public LinkedList () {
//        size = 0;
//        head = current = null;
//    }
//    public boolean empty () {
//        return head == null;
//    }
//    public boolean last () {
//        return current.next == null;
//    }
//    public boolean full () {
//            return false;
//    }
//    public void findFirst () {
//            current = head;
//    }
//    public void findNext () {
//            current = current.next;
//    }
//    public T retrieve () {
//            return current.data;
//    }
//    public void update (T val) {
//            current.data = val;
//    }
//    
//    public void insertAtEnd (T val) {
//            if (empty()) {
//                    current = head = new Node (val);
//            }
//            else {
//                    while (current.next != null )
//                        current = current.next;
//                    
//                    current.next = new Node (val);
//                    current = current.next;
//            }
//            size++;
//    }
//
//   /*public boolean insert(T val) {
//    Node<T> tmp = new Node<>(val);
//
//    if (empty()) {
//        head = current = tmp;
//    } else {
//        current = head;
//        while (current.getNext() != null) {
//            current = current.getNext();
//        }
//        current.setNext(tmp);
//        current = tmp;
//    }
//
//    size++;
//    return true;
//}*/
//
//public void insert(T c){
//        
//        Node<T> n = new Node<T> (c);
//        if (empty()){
//            current = head = n;  
//        }
//        else
//            { 
//                Node<T> p = head , q =null;
//                
//                if((((Contact)c).compareTo((Contact)p.data))< 0)    
//                {
//                    n.next = head;
//                    head = current =  n;
//                    
//                }
//                else
//                {
//                while(p!=null && (((Contact)c)).compareTo(((Contact)p.data))>= 0  )
//                {
//                    q = p;
//                    p = p.next;
//                 }
//                q.next = n;
//                n.next = p;
//                current = n;
//                } 
//            }
//
//}
//
//
//
//   public boolean search(T val) {
//    if (head == null)
//        return false;
//
//    Node<T> node = head;
//    boolean found = false;
//    
//    while (node != null) {
//        if (node.getData().equals(val)) {
//            current = node;
//            found = true;
//            break;  // Exit the loop when the value is found
//        }
//        node = node.getNext();
//    }
//    
//    return found;
//}
//            
//    public T remove (T r) {
//            
//        if (search (r) == false)
//         return null;
//
//        T data = current.getData();
//        
//        if (current == head) {
//                head = head.next;
//        }
//        else {
//                Node tmp = head;
//
//                while (tmp.next != current)
//                        tmp = tmp.next;
//               tmp.next = current.next;
//        }
//        if (current.next == null)
//                current = head;
//        else
//                current = current.next;
//        size -- ;
//        return data;    
//    }
//
//       public void printAll() {
//    Node<T> currentNode = head;
//    while (currentNode != null) {
//        System.out.print(currentNode.getData() + "    ");
//        currentNode = currentNode.getNext();
//    }
//    System.out.println();
//}
//}
//
//
