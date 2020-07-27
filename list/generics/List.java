//Jonathan Jacka
//CS 304
//Generics

package collections.list.generics;

public interface List <T>
{   
   void add(T val);
   
   void insert(int idx, T val) throws IndexOutOfBoundsException;
   
   boolean remove(int idx) throws IndexOutOfBoundsException;

   boolean remove(T val);
   
   boolean contains(T val);
   
   int indexOf(T val);
   
   int lastIndexOf(T val);
   
   T get(int idx) throws IndexOutOfBoundsException;
   
   void set(int idx, T val) throws IndexOutOfBoundsException;
   
   boolean isEmpty();
   
   boolean isFull();
   
   void clear();

   int size();
}