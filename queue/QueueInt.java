package collections.queue;
import collections.list.generics.*;

public interface QueueInt<T>
{
   void enqueue(T data);
   T dequeue();
   boolean isEmpty();
   boolean isFull();
   void clear();
   int size();
}