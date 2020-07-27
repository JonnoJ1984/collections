package collections.stack;
import collections.list.generics.*;


public interface StackInt<T>
{
   T pop();
   T peek();
   void push(T val);
   boolean isEmpty();
   boolean isFull();
   void clear();
   int size();
}