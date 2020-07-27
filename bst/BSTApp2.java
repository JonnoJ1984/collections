//Jonathan Jacka 
//CS 304

package collections.bst;
import collections.list.generics.List;
import collections.list.generics.LinkedList;

public class BSTApp2
{
   public static void main(String[] args)
   {
      BST<Integer> bst = new BST<>();
      System.out.println("Size = " + bst.size());
      System.out.println("Height = " + bst.height());
      
      int numNodes = 50;
      for( int i=0; i<numNodes; i++ ) 
      {
         //bst.add((int)(Math.random()*numNodes*20));
         bst.add(i+1);
      }
      
      System.out.println("Size = " + bst.size());
      System.out.println("Height = " + bst.height());
      bst.balance();
      System.out.println("Size = " + bst.size());
      System.out.println("Height = " + bst.height());
      
      System.out.println(bst.contains(574));
      System.out.println(bst.contains(574));
      System.out.println(bst.contains(20));
   
      List<Integer> bstList = bst.traverse(Order.IN_ORDER);
      System.out.println("IN ORDER------\n" + bstList);
      bstList = bst.traverse(Order.PRE_ORDER);
      System.out.println("PRE ORDER------\n" + bstList);
      bstList = bst.traverse(Order.POST_ORDER);
      System.out.println("POST ORDER------\n" + bstList);
      
      bstList = bst.traverse(Order.DEPTH_FIRST);
      System.out.println("DEPTH FIRST------\n" + bstList);
      bstList = bst.traverse(Order.BREADTH_FIRST);
      System.out.println("BREADTH FIRST------\n" + bstList);
            
      while( bst.size() > 0 ) 
      {
         int val= (int)(Math.random()*numNodes+1);
         bst.remove(val);
      }
      System.out.println("Size = " + bst.size());
      System.out.println("Height = " + bst.height());
      
   }

}