package collections.bst;
import collections.list.generics.List;
import collections.list.generics.LinkedList;
import collections.stack.Stack;
import collections.queue.Queue;


public class BST<T extends Comparable<T>> implements BSTInt<T>
{
   Node<T> root;
   
   //PROBLEM 1!
   //Determine if tree is in fact a binary search tree - node to left is smaller than root and node to right is larger.
   public boolean isBST()
   {
      return isBSTRec(root);
   }
   
   private boolean isBSTRec(Node<T> r)
   {
      if(r == null)
         return true;
      
      if(r.data.compareTo(r.left.data) > 0 && r.left != null)
         return isBSTRec(r.left);
         
      if(r.data.compareTo(r.right.data) < 0 && r.right != null)
         return isBSTRec(r.right);
      
      return false;     
   }
   
   
   //Problem 2!
   //check to see if tree is balanced; not sure if this is the most effective method in terms of time but it does work
   //Actually this doesn't work.  Either nothing is returned (?!?!) or I get a runtime exception.  
   public boolean isBalanced()
   {
      return isBalancedRec(root);
   }
   
   private boolean isBalancedRec(Node<T> r)
   {
      int lh;
      int rh;
      
      if(root == null)
         return true;
         
      lh = heightRec(r.left);
      rh = heightRec(r.right);
      
      if(Math.abs(lh - rh) <= 1 && isBalancedRec(r.left) && isBalancedRec(r.right))
      {
         return true;
      }
      else 
         return false;
   }
   
   //contains method that uses containsRec to search for data; if found returns true; if not, returns false.
   public boolean contains(T data)
   {
      return containsRec(root, data); 
   }
   private boolean containsRec(Node<T> r, T data)
   {  
      if(r == null)
         return false;
      
      else if(r.data.compareTo(data) > 0)
         return containsRec(r.left, data);
         
      else if(r.data.compareTo(data) < 0)
         return containsRec(r.right, data); 
         
      else
         return true;
   }
   
   public void remove(T val)
   {
      removeRec( null, root, val ); 
   }
   public void remove(Node<T> parent, Node<T> curNode)
   {
      if( curNode.left == null ) 
      {
         //right child of current attaches to parent
         if( parent == null )  
         {
            root = curNode.right;
         }
         else
         {
            if( parent.data.compareTo(curNode.data) < 0 ) 
            {
               parent.right = curNode.right;
            }
            else
            {
               parent.left = curNode.right;
            }
         }
      }
      else if( curNode.right == null ) 
      {
         //left child of current attaches to parent
         if( parent == null ) 
         {
            root = curNode.left;
         }
         else
         {
            if( parent.data.compareTo(curNode.data) < 0 ) 
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
         // curNode has two children
         T pred = max(curNode.left);
         curNode.data = pred;
         removeRec(curNode, curNode.left, pred);         
      }
   }
   private void removeRec(Node<T> parent, Node<T>curNode, T val)
   {
      if( curNode == null ) 
      {
         return;
      }
      int ct = curNode.data.compareTo(val);
      if( ct == 0 )
      {
         remove(parent, curNode);
      }
      else if( ct < 0 )
      {
         removeRec( curNode, curNode.right, val );        
      }
      else
      {
         removeRec( curNode, curNode.left, val );
      }
   }
   private T max(Node<T> r)
   {
      if( r.right == null ) 
      {
         return r.data;
      }
      else
      {
         return max(r.right);
      }
   }
      
   public void balance()
   {
      List<T> list = traverse(Order.IN_ORDER);
      clear();
      balanceRec(list, 0, list.size()-1);      
   }
   private void balanceRec(List<T> list, int low, int high)
   {
      if( low > high ) return;
      int mid = (low+high)/2;
      add(list.get(mid));   
      balanceRec(list, low, mid-1);
      balanceRec(list, mid+1, high);
   }
   
   //TRAVERSE!
   
   public List<T> traverse(Order o)
   {
      List<T> list = new LinkedList<>();
      if( o == Order.IN_ORDER ) 
      {
         inOrder(root, list);
      }
      else if( o == Order.PRE_ORDER )
      {
         preOrder(root, list);
      }
      else if( o == Order.POST_ORDER )
      {
         postOrder(root, list);
      }
      /* depth and breadth first traversals do not necessarily have
            to be recursive */
            
      else if( o == Order.DEPTH_FIRST )
      {
         depthFirst(root, list);
      }
      else
      {
         breadthFirst(root, list);
      }
      return list;
   }

   public void inOrder(Node<T> r, List<T> list)
   {
      if( r == null ) return;
      inOrder(r.left, list);
      list.add(r.data);
      inOrder(r.right, list);
   }
   public void preOrder(Node<T> r, List<T> list)
   {
      if( r==null ) return;
      list.add(r.data);
      preOrder(r.left, list);
      preOrder(r.right, list);
   }
   public void postOrder(Node<T> r, List<T> list)
   {
      if( r==null ) return;
      postOrder(r.left, list); 
      postOrder(r.right, list);
      list.add(r.data);
   }
   public void depthFirst(Node<T> r, List<T> list)
   {
      if(r == null)
         return;
      
      Stack<Node<T>> s1 = new Stack<>();

      Node<T> temp = r;
      s1.push(temp);
      
      while(s1.size() > 0)
      {
         temp = s1.pop();
         list.add(temp.data);
         
         if(temp.left != null)
         {
            s1.push(temp.left);
         }
         if(temp.right != null)
         {
            s1.push(temp.right);
         }
      }

   }
   public void breadthFirst(Node<T> r, List<T> list)
   {
      if(r == null)
         return;
      
      Queue<Node<T>> q1 = new Queue<>();
      
      Node<T> temp = r;
      q1.enqueue(temp);
      
      while(q1.size() > 0)
      {
         temp = q1.dequeue();
         list.add(temp.data);
         
         if(temp.left != null)
         {
            q1.enqueue(temp.left);
         }
         if(temp.right != null)
         {
            q1.enqueue(temp.right);
         }
      }
   }  
   public int size()
   {
      return sizeRec(root);
   }
   private int sizeRec(Node<T> r)
   {
      if( r == null ) 
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
      root = null;
      System.out.println("List has been cleared and is now empty.");
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
      int diff = r.data.compareTo(n.data);  
      if( diff == 0 ) return;
      if( diff < 0 ) // add to the right side
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
         if( r.left == null ) 
         {
            r.left = n;
         }
         else
         {
            add(r.left, n);
         }
      }
   }

}