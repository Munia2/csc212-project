public class LinkedList {
    public class LinkedList_ADT<T> {
    
    private Node<T> head;
    private Node<T> current;
    
    public LinkedList_ADT () {
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
 
    public void addContact(T contact){
        
        Node<T> tmp;
        if (empty()) {
        current = head = new Node<T> ();
        }
        else {
        tmp = current.next;
        current.next = new Node<T> ();
        current = current.next;
        current.next = tmp;
        }
        
    }
    public boolean searchContact(T critria){
        
        Node<T> tmp = current;
        current = head;
        while(current != null) {
        if(current.data.equals(critria))
        return true;
        current = current.next;
        }
        current = tmp;
        return false;
        }


        /*    Node<T> tmp = head;
        while(tmp != null) {
        if(tmp.data.equals(critria)) {
        current = tmp;
        return true;
        }
        tmp = tmp.next;
        }
        return false


        if(empty() == false) {
        findFirst();
        while(last() == false) {
        if(retrieve().equals(critria))
        return true;
        findNext();
        }
        if(retrieve().equals(critria))
        return true;
        }
        return false;

        
        Node<T> tmp = current;
        current = head;
        while(current != null) {
            if(current.data.equals(critria))
                return true;
        current = current.next;
        }
        current = tmp;
            return false;
            
     
        }*/
    
    public void deleteContact(){
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
        
        
    }
        
    }
}
