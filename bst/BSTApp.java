//Jonathan Jacka 
//CS 304 BST App

package collections.bst;
public class BSTApp
{
   public static void main(String[] args)
   {
      Node<Integer> n = new Node<>(100);
      n.right = new Node<>(200);   
      n.left = new Node<>(40);   
      n.left.left = new Node<>(20);
      n.left.left.right = new Node<>(35);
      n.left.left.right.left = new Node<>(28);
      n.left.left.right.right = new Node<>(37);

      int height = height(n);
      System.out.println("Height = " + height);
      int size = size(n);
      System.out.println("Size = " + size);
      
   }
   public static int height(Node<Integer> n)
   {
      if( n == null ) return 0;
      int hRight = 1 + height(n.right);
      int hLeft = 1 + height(n.left);
      return Math.max(hRight, hLeft);
   }
   public static int size(Node<Integer> n)
   {
      if( n==null ) return 0;
      return 1 + size(n.left) + size(n.right);
   }

}