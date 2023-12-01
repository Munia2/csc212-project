/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author munia
 */

public class BSTNode {
    
    public String key;
    public Contact data;
    public BSTNode left, right;
    /** Creates a new instance of BSTNode */
    public BSTNode(String k, Contact val) {
        key = k;
        data = val;
        left = right = null;
    }
    public BSTNode(String k, Contact val, BSTNode l, BSTNode r) {
        key = k;
        data = val;
        left = l;
        right = r;
    }
}