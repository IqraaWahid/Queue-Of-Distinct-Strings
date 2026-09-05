/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author i2wahid
 */
public class QueueOfDistinctStrings {
    // Overview: QueueOfDistinctStrings are mutable, bounded
    // collection of distinct strings that operate in
    // FIFO (First-In-First-Out) order.
    //
    // The abstraction function is:
    // a) Write the abstraction function here
    // AF(c) maps the concerete representation of the object to its abstract repersentaton
    //
    // AF(c) = an abstract object q representing a queue of distinct strings <s0, s1, ..., s(n-1)> such that
    // n = c.items.size()
    // for all i, 0<=i<n : si = c.items.get(i)
    // q.front = s0, if n > 0
    // q.end = s(n-1), if n > 0
    
    // The rep invariant is:
    // b) Write the rep invariant here
    // RI (c) = true if 
    // c.items != null &&
    // for all i, 0 <= i < c.items.size(): c.items.get(i) != null && 
    // for all i, j, 0<= i < j < c.items.size() =>
    //      !c.items.get(i).equals(c.items.get(j))
    // = false otherwise
    
    //the rep
    private ArrayList<String> items;
    
    // constructor
    public QueueOfDistinctStrings () {
        // EFFECTS: Creates a new QueueOfDistinctStrings object
        items = new ArrayList<String>();
    }
    
    // MODIFIES: this
    // EFFECTS: Appends the element at the end of the queue
    // if the element is not in the queue, otherwise
    // does nothing.
    public void enqueue(String element) throws Exception {
        if(element == null) throw new Exception();
        if(false == items.contains(element)){
            items.add(element);
        }
    }

    public String dequeue() throws Exception {
        // MODIFIES: this
        // EFFECTS: Removes an element from the front of the queue
        if (items.size() == 0) throw new Exception();
        return items.remove(0);
    }
    
    public boolean repOK() {
        // EFFECTS: Returns true if the rep invariant holds for this
        // object; otherwise returns false
        // c) Write the code for the repOK() here   
        
        //checking if the array exists
        if(items == null){
            return false;
        }
        
        //checking if all String exist
        for(int i=0;i<items.size();i++){
            if(items.get(i)==null){
                return false;
            }
        }
        
        // checking for duplicates
        for(int i=0;i<items.size();i++){
            for(int j=i+1; j<items.size();j++){
                if(items.get(i).equals(items.get(j))){
                return false;
                }
            }
        }
        return true;
    }

    public String toString() {
        // EFFECTS: Returns a string that contains the strings in the
        // queue, the front element and the end element.
        // Implements the abstraction function.
        // d) Write the code for the toString() here
        if(items.size()==0){
            return "Queue: "+ items + "\nFront element: none \n End element: none";
        }
        return "Queue: " + items + "\nFront element: " + items.get(0) + "\nEnd element: " + items.get(items.size()-1);
    }
    
    //main method:
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        
        try{
            QueueOfDistinctStrings d = new QueueOfDistinctStrings();
            System.out.println("Enter the string to add into the arraylist (enter 'stop' to stop adding): ");
            
            //filling the array
            while(true){
                System.out.println("Enter string: ");
                String s = input.nextLine();
                
                if(s.equals("stop")) break;
                
                 d.enqueue(s);
            }
            
            System.out.println("\n" + d); //outputting toString()
            System.out.println("repOK:" + d.repOK());
            
            System.out.println("\nDequeuing everything: ");
            while(true){//will run until exception is thrown
                System.out.println("Dequeuing: " + d.dequeue());
            }
        }
        
        //when exception is thrown
        catch(Exception e){
            System.out.println("Queue is empty now!");
        }
    }
}