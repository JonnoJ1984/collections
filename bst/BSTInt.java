package collections.bst;
import collections.list.generics.List;

public interface BSTInt<T extends Comparable<T>>
{
   int size();
   int height();
   void clear();
   boolean isEmpty();
   boolean isFull();
   void add(T data);
   List<T> traverse(Order o);
   void balance();
   void remove(T data);
}