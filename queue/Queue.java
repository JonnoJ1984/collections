//Jonathan Jacka  
//CS 304
//Queue using LinkedListGeneric1withRootAndEnd

package collections.queue;
import collections.list.generics.*;

public class Queue<T> implements QueueInt<T>
{  
   protected LinkedList<T> queue;
   
   public Queue()
   {
      this.queue = new LinkedList<>();
   }
   
   public void enqueue(T data) 
   {
      this.queue.add(data);
   }
   
   public T dequeue()
   {
      T result = queue.get(0);
      this.queue.remove(0);
      return result;
   }
   
   public boolean isEmpty()
   {
      boolean result = false;
      
      if(this.queue.size() == 0)
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
      this.queue.clear();
   }
   
   public int size()
   {
      return this.queue.size();
   }
}