//Jonathan Jacka
//CS 304

package collections.list;

public class Node
{
   public Node(String data)
   {
      this.data = data;
   }  
   String data;
   Node next;
   
   @Override
   public String toString()
   {
      return data;
   }

   /* our main method for testing out our Node class */
   public static void main(String[] args)
   {
      Node a = new Node("Node A");  
      Node b = new Node("Node B");   
      Node c = new Node("Node C");
      Node d = new Node("Node D");
      a.next = b;
      a.next.next = c;   
      a.next.next.next = d;
      /* we now have a linked chain of 4 nodes, 
          variable a references the first node.
          using only our a reference, 
          how do we remove a node from the chain? 
          how would we count the number of nodes? */
      //a.next.next = a.next.next.next;
      int size = 0;
      Node temp;
      temp = a;
      
      while( temp != null )
      {
         size = size + 1;
         temp = temp.next;
      }
      System.out.println( "Size of list = " + size );
   }
}