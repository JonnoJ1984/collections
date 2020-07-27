//Jonathan Jacka
//CS 304
//main method to test LinkedList class

package collections.list;

public class Test1
{
public static void main(String[] args)
   {
      List myList = new LinkedList();
      myList.add("Sue");
      myList.add("Bill");
      myList.add("George");
      myList.add("Sam");
      
      System.out.println("Size of list = " + myList.size());
      
      //a few text cases of methods
      System.out.println("List values at each index:");
      for(int i = 0; i < myList.size(); i++)
      {
         System.out.println(myList.get(i));
      }

      System.out.println("Insert value 'Jonathan' at index 2.");
      myList.insert(2, "Jonathan");
      
      for(int i = 0; i < myList.size(); i++)
      {
         System.out.println(myList.get(i));
      }
      System.out.println("Size of list = " + myList.size());
      
      System.out.println("Remove value at index 0.");
      myList.remove(0);
      for(int i = 0; i < myList.size(); i++)
      {
         System.out.println(myList.get(i));
      }
      System.out.println("Size of list = " + myList.size());
      
      System.out.println("Remove data value at if data equals George.");
      myList.remove("George");
      
      for(int i = 0; i < myList.size(); i++)
      {
         System.out.println(myList.get(i));
      }
      System.out.println("Size of list = " + myList.size());
      
      System.out.println("Set value at index 2 to 'Meghan'.");
      myList.set(2, "Meghan");
      
      System.out.println(myList.indexOf("Meghan"));
      System.out.println(myList.indexOf("George"));

      for(int i = 0; i < myList.size(); i++)
      {
         System.out.println(myList.get(i));
      }
   }
}