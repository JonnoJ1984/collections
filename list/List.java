//Jonathan Jacka
//CS 304

package collections.list;

public interface List
{   
   void add(String val);
   
   void insert(int idx, String val) throws IndexOutOfBoundsException;
   
   boolean remove(int idx) throws IndexOutOfBoundsException;

   boolean remove(String val);
   
   boolean contains(String val);
   
   int indexOf(String val);
   
   int lastIndexOf(String val);
   
   String get(int idx) throws IndexOutOfBoundsException;
   
   void set(int idx, String val) throws IndexOutOfBoundsException;
   
   boolean isEmpty();
   
   boolean isFull();
   
   void clear();

   int size();
}