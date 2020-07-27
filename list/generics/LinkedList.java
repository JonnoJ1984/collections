//Jonathan Jacka  
//CS 304
//LinkedListGeneric1withRootAndEnd

package collections.list.generics;

public class LinkedList<T> implements List<T>
{
   private Node<T> root;
   private Node<T> end;
   
   public LinkedList()
   {
      root = null;
   }
   
   //find the size of list
   public int size()
   {
      int count = 0;
      Node<T> tmp = root;
      
      while( tmp != null )
      {
         count++;
         tmp = tmp.next;
      }      
      return count;
   }
   
   //clear all data from list  
   public void clear()
   {
      root = null;
      System.out.println("List is now empty.");
   }
   
   //Check: List full?
   public boolean isFull()
   {
      return false;
   }
   
   //Check: List empty?
   public boolean isEmpty()
   {
      if( root == null)
      { 
         return true;
      }
      else
      {
         return false;
      }
   }
   
   //add to end of list
   public void add(T val)
   {

      Node<T> n = new Node<>(val); 
      // special case - if list is empty
      if(root == null) 
      {
         root = n;
      }      
      else
      {      
         Node<T> tmp = this.root;
         while(tmp.next != null) // find end of list
         {
            tmp = tmp.next;
         }
         tmp.next = n;

      }
   }
   
   //insert data val at index idx, shift all values after insert to right 
   public void insert(int idx, T val)
   {     
      if(root == null)
      {
         Node<T> n = new Node<T>(val);
         root = n;
      }
      
      else if(idx >= this.size() || idx < 0)
      {
         throw new IndexOutOfBoundsException("Index " + idx + " is out of bounds!");
      }
      else
      {
         Node<T> temp = root;
         Node<T> replace = new Node<>(val);
         int count = 0;
         
         if(idx == 0)
         {
            replace.next = temp;
            root = replace;
         }
         
         else
         {
            while(count != idx - 1)
            {
               temp = temp.next;
               count++;
            }
            
            replace.next = temp.next;
            temp.next = replace;
         }       
      }
   }
   
   //REPLACE String val at given index idx
   public void set(int idx, T val)
   {
     if(idx >= this.size() || idx < 0)
     {
         throw new IndexOutOfBoundsException("Index " + idx + " is out of bounds!");
     }
     else
     {
         Node<T> temp = this.root;
         int count = 0;
         
         while(count < idx)
         {
            temp = temp.next;
            count++;
         }
         temp.data = val;
     }
   }
   
   //Get a specific data at chosen index
   public T get(int idx)
   {
     if(idx >= this.size() || idx < 0)
     {
         throw new IndexOutOfBoundsException("Index " + idx + " is out of bounds!");
     }
     else 
     {
         Node<T> temp = this.root;
         int count = 0;
         
         while(count < idx)
         {
            temp = temp.next;
            count++;
         }
         return temp.data;    
     }
   }
   
   //Find the index of the last occurance of given value
   public int lastIndexOf(T val)
   {
      int result = -1;
      Node<T> temp = root;
      int count = 0;
      
      while(temp != null)
      {
         if(val.equals(temp.data))
         {
            result = count;
         }
         temp = temp.next;
         count++;
      }
      return result;
   }
   public int indexOf(T val)
   {
      int count = -1;
      int result = -1;
      
      Node<T> temp = root;
      
      while(temp != null)
      {
         count++;
         if(val.equals(temp.data))
         {
            result = count;
         }   
         temp = temp.next;
      }
      return result;
   }
   
   //Check to see if list contains a specific value
   public boolean contains(T val)
   {
      boolean result = false;
      Node<T> temp = root;
      
      while(temp != null)
      {
         if(val.equals(temp.data))
         {
            result = true;
         }
         temp = temp.next;
      } 
      return result;
   }

   //Delete an index and its data from list completely; indexes are shifted up and list size 
   //is now size -1
   public boolean remove(int idx)
   {
      boolean result = false;
      
      if(idx >= this.size() || idx < 0)
      {
         throw new IndexOutOfBoundsException("Index " + idx + " is out of bounds!");
      }
      else
      {
         if(idx == 0)
         {
            root = root.next;
            result = true;
         }
         else
         {
            Node<T> temp = root;
            int count  = 0;
            while(count != idx - 1)
            {
               temp = temp.next;
               count++;
            }  
            temp.next = temp.next.next;
            result = true;      
         }
      }
      return result;
   }
   
   //Remove the a given String data from an index; index remains
   public boolean remove(T val)
   {
      boolean result = false;
      
      Node<T> temp = root;
      
      while(temp != null)
      {
         if(temp.data.equals(val))
         {
            temp.data = null;
            result = true;
         }
         temp = temp.next;
      }
      return result;
   }

   @Override
   public String toString()
   {
      String result = "";
      
      Node<T> temp = root;
      
      while(temp != null)
      {
         result += " " + temp.data;
         temp = temp.next;
      }
      
      return result;
   }
}