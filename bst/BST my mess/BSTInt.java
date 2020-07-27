package collections.bst;

public interface BSTInt<T extends Comparable<T>>
//Comparable is another generic interface. 
//Do not say T "implements" Comparable b/c idk, just use extends.  
{
   int size();
   int height();
   void clear();
   boolean isEmpty();
   boolean isFull();
   void add(T data);
   List<T> traverse(ORDER);
   void balance();
   void remove(T val);

}