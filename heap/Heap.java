package collections.heap;

import collections.list.generics.LinkedList;

public class Heap<T extends Comparable<T>>{
   LinkedList<T> data;
   
   public Heap(){
      data = new LinkedList<>();
   }

   public int size(){
      return data.size();
   }
   
   public boolean contains(T val){
      return data.contains(val);
   }

   public int getParent(int idx){
      return (int)((idx-1)/2);
   }

   public void add(T val){
      data.add(val);
      int currIdx=data.size()-1;
      boolean isHeap=false;   
      while(!isHeap){
         int parentIdx=getParent(currIdx);
         T parentVal = data.get(parentIdx);
         if(parentVal.compareTo(val)>0){
            data.set(parentIdx,val);
            data.set(currIdx, parentVal);
            currIdx=parentIdx;
         }
         else{isHeap=true;}
      }
   }
   
   public int getLeftChild(int idx){return 2*idx+1;}

   public int getRightChild(int idx){return 2*idx+2;}

   public T remove() throws IndexOutOfBoundsException{
   
      IndexOutOfBoundsException IOB = new IndexOutOfBoundsException("Heap is empty.");
      if(data.isEmpty()){throw IOB;}

      T ret = data.get(0);
      data.set(0,data.get(data.size()-1));
      data.removeIdx(data.size()-1);
      
      int curIdx=0;
      boolean isHeap=false;
      while(!isHeap){
         int leftIdx=getLeftChild(curIdx);
         int rightIdx=getRightChild(curIdx);
         
         if(leftIdx>=data.size()){return ret;}      

         if(rightIdx>=data.size() || data.get(leftIdx).compareTo(data.get(rightIdx))<0){
            if(data.get(curIdx).compareTo(data.get(leftIdx))>0){
               T temp = data.get(curIdx);
               data.set(curIdx,data.get(leftIdx));
               data.set(leftIdx,temp);
               curIdx=leftIdx;
            }
            else{return ret;}
         }
         else{     
            if(data.get(curIdx).compareTo(data.get(rightIdx))>0){
               T temp = data.get(curIdx);
               data.set(curIdx,data.get(rightIdx));
               data.set(rightIdx,temp);
               curIdx=rightIdx;
            }
            else{return ret;}
         }
      }
      return ret;
   }

   public T peek(){
      return data.get(0);
   }
   
   public boolean isEmpty(){
      return data.size()==0;
   }
       
   public static void main(String[] args){
   
      Heap<Integer> myHeap = new Heap<>();

      try{myHeap.remove();}
      catch(IndexOutOfBoundsException ex){System.out.println(ex);}       

      for(int i=0;i<10;i++){
         myHeap.add((int)(Math.random()*60+1));
      }
      
      System.out.println(myHeap.peek());      
      for(int i=0;i<10;i++){
        System.out.println(myHeap.remove());
      }
   }
}