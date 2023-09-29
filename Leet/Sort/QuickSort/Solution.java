import java.util.Random;

public class Solution
{
  public static void main(String[] args) 
  {
    int[] some_random_array = {27, 12, 18, 54, 91, 62, 23, 87, 41, 52, 79};
    quicksort(some_random_array, 0, some_random_array.length - 1);
    for (int i: some_random_array)
    {
      System.out.println(i);
    }
  }

  public static void quicksort(int[] array, int lowestindex, int highestindex)
  {
    if (lowestindex >= highestindex){return ;} // if range of sort value is 1, don't need to do anything

    int pivotindex = new Random().nextInt(highestindex - lowestindex) +lowestindex; //Choosing pivot randomly will make this perfrom better 
    int pivot = array[pivotindex];
    swap(array, highestindex, pivotindex);

    int leftpointer = lowestindex;
    int rightpointer = highestindex;

    while (leftpointer < rightpointer) // purpose : leftside value of pivot is less than pivot & rightside is greater than pivot
    {
      while (array[leftpointer] <= pivot && leftpointer < rightpointer) //find the value greater than pivot
      {
        leftpointer++;
      }
      while (array[rightpointer] >= pivot && leftpointer < rightpointer) //find the value lower than pivot
      {
        rightpointer--;
      }
      swap(array, leftpointer, rightpointer); //swap both value
    }
    swap(array, leftpointer, highestindex); // after 2 pointer met, swap it with pivot
    quicksort(array, lowestindex, leftpointer - 1); // sort the leftside 
    quicksort(array, leftpointer + 1, highestindex); // sort the rightside
  }


  public static void swap(int[] array, int index1, int index2)
  {
    int temp = array[index2];
    array[index2] = array[index1];
    array[index1] = temp;
  }
}