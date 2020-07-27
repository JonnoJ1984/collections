//Awe Da've this is the test file!

package collections.bst;
import collections.list.generics.List;
import collections.list.generics.LinkedList;

public class BSTApp3
{
   public static void main(String[] args)
   {
      BST<Integer> bst = new BST<>();
      System.out.println("Size = " + bst.size());
      System.out.println("Height = " + bst.height());
      
      int numNodes = 7;
      for( int i=0; i<numNodes; i++ ) 
      {
         bst.add((int)(Math.random()*numNodes*20));
         //bst.add(i+1);
      }
      
      System.out.println("Size = " + bst.size());
      System.out.println("Height = " + bst.height());
      bst.isBST();
      bst.isBalanced();
   }

}