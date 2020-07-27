package collections.bst;

public class BST<T extends Comparable<T>> implements BSTInt<T>
{
   Node<T> root;  //root is an attribute of data type Node
    
    
   public void remove(T val)
   {
       
   }
    
   private void remove(Node<T> parent, Node<T> curNode)
   {
       if(curNode.left == null)
       {
               //right child of current attaches to parent 
                if(parent == null )
                {
                    root = curNode.right;   
                }
                else
                {
                    if(parent.data.compareTo(curNode.data) < 0)
                    {
                        parent.right = curNode.right;   
                    }
                    else
                    {
                        parent.left = curNode.right;   
                    }
                }
       }
       else if (curNode.right == null)
       {
            //left child of current attaches to parent  
           if(parent == null)
           {
                root = curNode.left;   
           }
           else
           {
               if(parent.data.compareTo(curNode.data) < 0)
               {
                       parent.right = curNode.left;
               }
               else
               {
                        parent.left = curNode.left;   
               }
           }    
       }
       else
       {
           //curNode has two children 
           T predessor = max(curNode.left);   
           curNode.val = predecessor;
           removeRec(curNode, curNode.left, predecessor);
       }
   }
    
   private void remove(Node<T> parent, Node<T> curNode, T val)
   {
       if (curNode == null) // value is not contained in the tree
       {
            return;    
       }
       
       int ct = curNode.compareTo(val)
       
       if(ct == 0) //equals
       {
           remove(prent, curNode);
           return;
       }
       else if(ct < 0) //greater than ?
       {
           removeRec(curNode, curNode.right, val);
       }
       else
       {
            removeRec( curNode, curNode.left, val);   
       }
   }
   
   private T max(Node<T> r) //this to find the predecessor of the node we want to delete - the predecessor of the parent(the one before the one we want to delete
   {
       if(r.right == null)
       {
           return r.data;
       }
       else
       {
            return max(r.right);
       }
   }
   
   public int size()
   {
      return sizeRec(root);
   }
   private int sizeRec(Node<T> r)
   {
      if( r==null )
      {
         return 0;
      }
      else
      {
         return 1 + sizeRec(r.left) + sizeRec(r.right);
      }
   }
   public void clear()
   {
   
   }
   
   public int height()
   {
      return heightRec(root);
   }
   
   private int heightRec(Node<T> r)
   {
      if( r == null )
      {
         return 0;
      }
      else if( r.left == null && r.right == null )
      {
         return 0;
      }
      return 1 + Math.max(heightRec(r.left), heightRec(r.right));
   }
   
   public boolean isFull()
   {
      return false;
   }
   
   public boolean isEmpty()
   {
      return root == null;
   }
   
   public void add(T data)
   {
      Node<T> n = new Node<>(data);
      if( root == null )
      {
         root = n;
      }
      else 
      {
         add(root, n);
      }
   }
   private void add(Node<T> r, Node<T> n)
   {
      //compare r.data to n.data
      //compareTo returns a negative, positive, or 0.
      
      int diff = r.data.compareTo(n.data);
      if( diff == 0 ) return;
      if( diff < 0 ) //add to the right side
      {
         if( r.right == null )
         {
            r.right = n;
         }
         else
         {
            add(r.right, n);
         }
      }
      else
      {
         if( r.left == null)
         {
            r.left = n;
         }
         else
         {
            add(r.left, n);
         }
      }
   }
   
   public static void main(String[] args)
   {
      BST<Integer> bst = new BST<>();
      
      System.out.println("Size = " + bst.size());
      System.out.println("Height = " + bst.height());
      /*
      bst.add(20);
      bst.add(10);
      bst.add(30);
      */
      int numNodes = 32;
      for( int i=0; i<numNodes; i++ )
      {
         bst.add((int)(Math.random()*numNodes*2));
      }
      
      System.out.println("Size = " + bst.size());
      System.out.println("Height = " + bst.height());
  }

}