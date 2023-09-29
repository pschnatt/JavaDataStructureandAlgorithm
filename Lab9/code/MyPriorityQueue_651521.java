package code;

import java.util.NoSuchElementException;

interface MyQueueInterface 
{
  public void enqueue(int d);

  public int dequeue();

  public int front();

  public boolean isFull();

  public boolean isEmpty();
}

public class MyPriorityQueue_651521 implements MyQueueInterface 
{
  MyMinHeap heap = new MyMinHeap();

  @Override
  public void enqueue(int d)
  {
    if (isFull()){return ;}
    heap.insert(d);
  }

  @Override
  public int dequeue()
  {
    if (isEmpty()){throw new NoSuchElementException("The heap is empty");}
    return (heap.remove());
  }

  @Override
  public int front()
  {
    if (isEmpty()){throw new NoSuchElementException("The heap is empty");}
    return (heap.peek());
  }

  @Override
  public boolean isFull()
  {
    return (heap.size == heap.MAX_SIZE);
  }

  @Override
  public boolean isEmpty()
  {
    return (heap.size == 0);
  }

  @Override
  public String toString() {
    return "MyPriorityQueue_651521 [heap=" + heap + "]";
  }

  
}
