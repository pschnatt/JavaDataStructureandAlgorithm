public class Solution
{
  public static void main(String[] args)
  {
    int[] some_random_array = {27, 12, 18, 54, 91, 62, 23, 87, 41, 52, 79};
    mergesort(some_random_array);
    for (int i: some_random_array)
    {
      System.out.println(i);
    }
  }
  public static void mergesort(int arr[])
  {
    int len = arr.length;
    if (len <= 1){return ;}

    int[] left = new int[len/2];
    int[] right = new int[len - len/2];

    int j = 0;
    for (int i = 0; i < len; i++)
    {
      if (i < len/2)
        left[i] = arr[i];
      else 
      {
        right[j] = arr[i];
        j++;
      }
    }
    mergesort(left);
    mergesort(right);
    merge(left, right, arr);
  }

  public static void merge(int[] left, int[] right, int[] arr)
  {
    int l_index = 0;
    int r_index = 0;
    int arrindex = 0;

    int l_len = left.length;
    int r_len = right.length;

    while (l_index < l_len && r_index < r_len)
    {
      if (left[l_index] < right[r_index])
      {
        arr[arrindex++] = left[l_index++];
      }
      else
      {
        arr[arrindex++] = right[r_index++];
      }
    }
    while (l_index < l_len) {arr[arrindex++] = left[l_index++];}
    while (r_index < r_len) {arr[arrindex++] = right[r_index++];}
  }
}