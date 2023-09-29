public class MergeSorting
{
  public static void main(String[] args)
  {
    int[] arr = {5,8,7,2,3,4,9,1,6};

    mergeSort(arr);

    for (int i : arr)
    {
      System.out.println(i);
    }
  }
  public static void mergeSort(int[] arr)
  {
    int length = arr.length;
    if (length <= 1)
      return ;
    int leftlength = length / 2;
    int rightlength = length - leftlength;

    int[] leftarr = new int[leftlength];
    int[] rightarr = new int[rightlength];

    int i = 0;
    int j = 0;

    for (; i < length; i++)
    {
      if (i < leftlength)
        leftarr[i] = arr[i];
      else
      {
        rightarr[j] = arr[i];
        j++;
      }
    }
    mergeSort(rightarr);
    mergeSort(leftarr);
    merge(leftarr,rightarr,arr);
  }

  public static void merge(int[] leftarr, int[] rightarr, int[] arr)
  {
    int l = 0;
    int r = 0;
    int i = 0;

    int lengthleft = leftarr.length;
    int lengthright = rightarr.length;

    while (l < lengthleft && r  < lengthright)
    {
      if (leftarr[l] > rightarr[r])
        arr[i++] = rightarr[r++];
      else
        arr[i++] = leftarr[l++];
    }
    while (l < lengthleft)
      arr[i++] = leftarr[l++];
    while (r < lengthright)
      arr[i++] = rightarr[r++];
  }
}