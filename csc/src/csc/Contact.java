package csc;

import java.util.*;
public class Contact implements Comparable{
 String name;
 int phoneNumber;
 String emaiAddress;
 String address;
 String birthday;
 String notes;
public Contact(String name,int pn,String eadd, String add ,String bday, String note){
this.name=name;
phoneNumber=pn;
emaiAddress=eadd;
address=add;
birthday=bday;
notes=note;
}
public int compareTo(Contact cnt){ 
 // compare two names
        int len1 = name.length();
        int len2 = cnt.name.length();
        int shortest = Math.min(len1, len2);
  
        for (int i = 0; i < shortest; i++) {
            int name1ch = (int)name.charAt(i);
            int name2ch = (int)cnt.name.charAt(i);
  
            if (name1ch != name2ch) {
                return name1ch - name2ch;
            }
        }
  
        // Edge case for strings like
        // String 1="Geeks" and String 2="Geeksforgeeks"
        if (len1 != len2) {
            return len1 - len2;
        }
  
        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            return 0;
        }
    }
 }
