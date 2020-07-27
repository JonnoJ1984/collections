//Jonathan Jacka
//CS 304
//Generics - Node

package collections.list.generics;

public class Node <T>
{
   public Node(T data)
   {
      this.data = data;
   }  
   
   T data;
   Node <T> next;

   
   @Override
   public String toString()
   {
      return (String)this.data;
   }
   
}