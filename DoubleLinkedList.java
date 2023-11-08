import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ILinkedList {
/**
* Inserts a specified element at the specified position in the list.
* @param index
* @param element
*/
public void add(int index, Object element);
/**
* Inserts the specified element at the end of the list.
* @param element
*/
public void add(Object element);
/**
* @param index
* @return the element at the specified position in this list.
*/
public Object get(int index);

/**
* Replaces the element at the specified position in this list with the
* specified element.
* @param index
* @param element
*/
public void set(int index, Object element);
/**
* Removes all of the elements from this list.
*/
public void clear();
/**
* @return true if this list contains no elements.
*/
public boolean isEmpty();
/**
* Removes the element at the specified position in this list.
* @param index
*/
public void remove(int index);
/**
* @return the number of elements in this list.
*/
public int size();
/**
* @param fromIndex
* @param toIndex
* @return a view of the portion of this list between the specified fromIndex and toIndex, inclusively.
*/
public ILinkedList sublist(int fromIndex, int toIndex);
/**
* @param o
* @return true if this list contains an element with the same value as the specified element.
*/
public boolean contains(Object o);
}


public class DoubleLinkedList implements ILinkedList {
	/* Implement your linked list class here*/
    Node head = null;
    Node lastN = null;
    int size = 0;
    private class Node
    {
        Object data;
        Node next;
        Node prev;
        Node(Object data)
        {
            this.data = data;
        }
    }
    
    public void add(Object element)
    {
       Node n = new Node(element);
        if(size==0)
        {
            head = n;
            lastN = n;
        }
        else
        {
            n.prev = lastN;
            lastN.next = n;
            lastN = n ;
        }
        size++;
    }
    
    public Object get(int index)
    {
        Node temp;
        temp = head;
        for(int i=0; i<index; i++)
        {
            temp = temp.next;
        }
        return temp.data;
    }
    
    public void add(int index, Object element)
    {
        Node n = new Node(element);
        
        if(index == 0)
        {
            n.next = head;
            head = n;
        }
        else if(index == size)
        {
            add(element);
        }
        else
        {
            Node temp;
            temp = head;
            for(int i=0; i<(index-1); i++)
            {
                // prev
                temp = temp.next;     
            }
            Node bf = temp;
            Node af = temp.next;
            
            bf.next = n;
            af.prev = n;
            n.next = af;
            n.prev = bf;
            
        }
        size++;
    }
    
    public void remove(int index)
    {
        Node temp;
        temp = head;
        if(size!=0)
        {
            if(index == 0)
            {
                head.next.prev = null;
                head = head.next;
            }
            else
            {
                for(int i=0; i<(index-1); i++)
                {
                    // prev
                    temp = temp.next;
                }
                if(index == size -1)
                {
                    temp.next.prev = null;
                    temp.next.next = null;
                    lastN = temp.next;
                }
                else
                {
                    temp.next = temp.next.next;    
                    temp.next.next.prev = temp;
                }
                
            }
        }
        
    }
    
    public void set(int index, Object element)
    {
        Node temp;
        temp = head;
        for(int i=0; i<index; i++)
        {
            temp = temp.next;
        }
        temp.data = element;
    }
    
    public void clear()
    {
        if(size!=0)
        {
            head.next = null;
            lastN.prev = null;
            head = null;
            lastN = null;
            size = 0;
        }
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }
    
    public DoubleLinkedList sublist(int fromIndex, int toIndex)
    {
        DoubleLinkedList subls = new DoubleLinkedList();
        int temp = 0;
        int subsize = toIndex - fromIndex;
        for(int i=0; i<=subsize; ++i)
        {
            temp = (Integer)get(fromIndex + i);
            subls.add(temp);
        }
        
        return subls;
        
    }
    
    public boolean contains(Object o)
    {
        Node temp;
        temp = head;
        boolean isThere = false;
        for(int i=0; i<size; i++)
        {
            if(temp.data == o)
            {
                isThere = true;
                break;
            }
            temp = temp.next;
        }
        return isThere;
    }
    
    public static void display(DoubleLinkedList l)
    {
        System.out.print("[");
        for(int i = 0; i < l.size(); i++)
        {
            System.out.print(l.get(i));
            if(i != l.size() - 1)
                System.out.print(", ");
        }
        System.out.print("]");
    }
    
    public static void main(String[] args) {
       /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String op = sc.nextLine();
        String[] s = sin.split(", ");
        DoubleLinkedList slst = new DoubleLinkedList();
        if (s.length == 1 && s[0].isEmpty())
        {
            // List entered is empty
        }
         else
         {
             //Fill List
             for(int i=0; i<s.length; i++)
            {
                slst.add(Integer.parseInt(s[i]));
            }
         }
    
          try
          {
          if(op.equals("add") )
          {
              int elementt = sc.nextInt();
              slst.add(elementt);
              display(slst);
          }
          else if( op.equals("addToIndex"))
          {
              int index = sc.nextInt();
              int elementt = sc.nextInt();
              if(index<=slst.size() && index>=0)
              {
                slst.add(index, elementt);
                  display(slst);
              }
              else
              {
                  System.out.println("Error");
              }    
          }
          else if(op.equals("get")) 
          {
              int index = sc.nextInt();
              if(index<slst.size() && index>=0)
              {
                int element = (Integer)slst.get(index);
                System.out.println(element);
              }
              else
              {
                  System.out.println("Error");
              }    
              
          }
         else if(op.equals("set"))
         {
             int index = sc.nextInt();
             int elementt = sc.nextInt();
              if(index<slst.size() && index>=0)
              {
                slst.set(index, elementt);
                display(slst);
              }
              else
              {
                  System.out.println("Error");
              }    
         }
        else if(op.equals("clear"))
        {
            slst.clear();
            display(slst);
        }
       else if( op.equals("isEmpty"))
       {
           if(slst.isEmpty())
               System.out.println("True");
           else
               System.out.println("False");
       }
       else if(op.equals("remove"))
       {
           int index = sc.nextInt();
              if(index< slst.size() && index>=0)
              {
                slst.remove(index);
                display(slst);
              }
              else
              {
                  System.out.println("Error");
              }    
       }
      else if(op.equals("size"))
      {
          System.out.println((Integer)slst.size());
      }
      else if(op.equals("sublist")) 
      {
          int from = sc.nextInt();
          int to   = sc.nextInt();
          if(to>=from && to<=slst.size() && from>=0)
          {
              DoubleLinkedList sub = slst.sublist(from, to);
              display(sub);
          }
          else
          {
              System.out.println("Error");
          }
          
      }
      else if(op.equals("contains"))
      {
          int elementt = sc.nextInt();
          if(slst.contains(elementt))
              System.out.println("True");
          else
              System.out.println("False");
      }
            
          }
        catch(Exception e)
        {
            System.out.println("Error");
        }
            
    }
}