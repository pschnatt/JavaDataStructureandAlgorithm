public class Solution
{
  public static void main(String[] args) 
  {
    int[] some_random_array = {27, 12, 18, 54, 91, 62, 23, 87, 41, 52, 79};
    bubblesort(some_random_array, 11);
    for (int i: some_random_array)
    {
      System.out.println(i);
    }
  }
  public static void bubblesort(int[] arr, int length)
  {
    for (int i = length; i > 1; i--)
    {
      for (int j = 0; j < length - 1; j++)
      {
        if (arr[j] > arr[j+1])
        {
          swap(arr, j, j+1);
        }
      }
    }
  }

  public static void swap(int[] arr, int index1, int index2)
  {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }
}