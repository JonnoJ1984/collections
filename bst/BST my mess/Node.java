package collections.bst;

public class Node<T>
{
   public Node() {}
   public Node(T data)
   {
      this.data = data;
      this.left = null;
      this.right = null;
   }
   T data;
   Node<T> left;
   Node<T> right;
   
   public static void main(String[] args)
   {
      /*
      Node<Integer> n = new Node<>(100);
      Node<Integer> n2 = new Node<>(200);
      Node<Integer> n3 = new Node<>(40);
      n.left = n3;
      n.right = n2;
      */
      
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
      int hLeft = 1 + height(n.left);
      int hRight = 1 + height(n.right);
      return Math.max(hRight, hLeft);
   }

   public static int size(Node<Integer> n)
   {
      if ( n == null ) return 0;
      return 1 + size(n.left) + size(n.right);
   
   }

}