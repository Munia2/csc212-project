/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author munia
 */

public class BST {
    BSTNode root, current;

    public BST() {
        root = current = null;
    }
    public boolean isEmpty() {
        return root == null;
    }

    public Contact retrieve (BSTNode node) {
        return node.data;
    }


    public String findkey(String tkey) {
        BSTNode p = root, q = root;
        if(isEmpty())
            return "";
        while(p != null) {
            q = p;
            if(p.key.equalsIgnoreCase(tkey)) {
                current = p;
                return p.key;
            }
            else if((tkey.compareToIgnoreCase(p.key)) < 0)
                p = p.left;
            else
                p = p.right;
        }
        current = q;
        return "";
    }
    
    public boolean insert(String k, Contact val) {
        BSTNode p, q = current;
        if(!findkey(k).equals("")) {
            current = q; // findkey() modified current
            return false; // key already in the BST
        }
        p = new BSTNode (k, val);
        if (isEmpty()) {
            root = current = p;
            return true;
        }
        else {
            // current is pointing to parent of the new key
            if (k.compareToIgnoreCase(current.key) < 0)
                current.left = p;
            else
                current.right = p;
            current = p;
            return true;
        }
    }
    
    public BooleanWrapper remove_key (String tkey){
        BooleanWrapper removed = new BooleanWrapper(false);
        BSTNode p;
        p = remove_aux(tkey, root, removed);
        current = root = p;
        return removed;
    }

    private BSTNode remove_aux(String key, BSTNode p, BooleanWrapper flag) {
        BSTNode q, child = null;
        if(p == null)
            return null;
        if(key.compareToIgnoreCase(p.key) < 0)
            p.left = remove_aux(key, p.left, flag); //go left
        else if(key.compareToIgnoreCase(p.key) > 0)
            p.right = remove_aux(key, p.right, flag); //go right
        else { // key is found
            flag.set( true);
            if (p.left != null && p.right != null){ //two children
                q = find_min(p.right);
                p.key = q.key;
                p.data = q.data;
                p.right = remove_aux(q.key, p.right, flag);
            }
            else {
                if (p.right == null) //one child
                child = p.left;
                else if (p.left == null) //one child
                child = p.right;
                return child;
            }
        }
        return p;
    }
    private BSTNode find_min(BSTNode p){
        if(p == null)
            return null;
        while(p.left != null){
            p = p.left;
        }
        return p;
    }
    public void printBSTNode(BSTNode node){
       System.out.println(node.data);
    }
    
//    public void traverse (){
//        traverseInOrder(root);
//    }
//
//    private void traverseInOrder(BSTNode node){
//        
//        if (node == null)
//            System.out.println("Empty tree");
//        if (node !=null){
//            traverseInOrder(node.left);
//            System.out.println(node.data);
//            traverseInOrder(node.right);
//        }
//    } 
}    
    
 
  