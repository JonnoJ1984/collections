//Jonathan Jacka  
//CS 304
//Stack using LinkedListGeneric1withRootAndEnd

package collections.stack;
import collections.list.generics.LinkedList;

public class Stack<T> implements StackInt<T>
{
   protected LinkedList<T> stack;
   
   public Stack()
   {
      this.stack = new LinkedList<T>();
   }
   
   public T pop() 
   {
      T result = stack.get(0);
      this.stack.remove(0);
      
      return result;
   }
   
   public T peek()
   {
      T result;
      
      if(this.stack.size() == 0)
      {
         System.out.println("Stack is empty.");
         result = null;
      }
      else
      {
         result = this.stack.get(0);
      }
      
      return result;
   }
   
   public void push(T val)
   {
      this.stack.insert(0, val);
   }
   
   public boolean isEmpty()
   {
      boolean result = false;
      
      if(this.stack.size() == 0)
      {
         result = true;
      }
    
      return result;
   }
   
   public boolean isFull()
   {
      return false;
   }

   public void clear()
   {
      this.stack.clear();
   }
   
   public int size()
   {
      return this.stack.size();
   }
}