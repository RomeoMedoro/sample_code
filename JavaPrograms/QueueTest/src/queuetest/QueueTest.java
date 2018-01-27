
package queuetest;
import java.util.*;

public class QueueTest {

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

class Queue{
    int[] elements;
    int size;
    
    Queue(){
        size = 8;
        elements = new int[size];
    }
    
    public void enqueue(int v){
        if (size >= elements.length){
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0 , temp, 0, elements.length);
            elements = temp;
        }
        
        elements[size ++] = v;
    }
    
    public int dequeue(){
        return elements[--size];
    }
    
    public boolean empty(){
        if (elements.length == 0){
            return true;
        }
        else 
            return false;
    }
    
    public int getSize(){
        int result;
        result = elements.length;
        
        return result;
    }
}