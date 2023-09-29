package code;

import java.util.Arrays;

public class MyMinHeap
{
  int MAX_SIZE = 100;
  int[] heap = new int[MAX_SIZE];
  int size = 0;

  public void swap(int index1, int index2)
  {
    heap[index1] = heap[index1] ^ heap[index2];
    heap[index2] = heap[index1] ^ heap[index2];
    heap[index1] = heap[index1] ^ heap[index2];
  }

  public void insert(int d)
  {
    int p = size++;
    heap[p] = d;
    int parent = (p - 1) / 2;

    while (p > 0 && heap[parent] > heap[p])
    {
      swap(p,parent);
      p = parent;
      parent = (p - 1) / 2;
    }
  }

  public int remove()
  {
    int d = heap[0];
    heap[0] = heap[--size];
    int p = 0;
    while (true)
    {
      int left = 2 * p + 1;
      if (left >= size){return (d);}
      int right = 2 * p + 2;
      if (right == size)
      {
        if (heap[left] < heap[p]){swap(p, left);}
        return (d);
      }
      else 
      {
        int q = (heap[left] < heap[right]) ? left : right;
        if (heap[q] < heap[p]){swap(p, q);}
        else{return (d);}
        p = q;
      }
    } 
  }

  public int peek()
  {
    return (heap[0]);
  }

  @Override
  public String toString() {
    return "MyMinHeap [MAX_SIZE=" + MAX_SIZE + ", heap=" + Arrays.toString(heap) + ", size=" + size + "]";
  }
  
}