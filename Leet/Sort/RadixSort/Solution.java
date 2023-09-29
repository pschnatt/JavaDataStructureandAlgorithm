public class Solution
{
  public static void main(String[] args) 
  {
    int[] x = {321,845,968,875,245,361,272,457,911};
    radixsort(x, 3);
    for (int i : x)
    {
      System.out.println(i);
    }
  }

  public static void radixsort(int[] arr, int highestdigit)
  {
    for (int i = 0; i < highestdigit; i++)
    {
      countingsort(arr, (int)Math.pow(10, i));
    }
  }


  public static void countingsort(int[] arr, int exp) //counting sort is suit for subroutine sort because it work best at small range sorting
  {
    int len = arr.length;
    int max = (arr[0] / exp) % 10;
    int i = 1;
    int[] copyarr = new int[len];
    for (; i < len; i++)
    {
      if ((arr[i] / exp) % 10 > max) {max = (arr[i] / exp) % 10;}
    }
    int[] newarr = new int[max + 1];
    for (i = 0; i < len; i++)
    {
      newarr[(arr[i] / exp) % 10]++;
    }
    for (i = 1; i < max + 1; i++)
    {
      newarr[i] += newarr[i-1];
    }
    for (i = max; i > 0; i--)
    {
      newarr[i] = newarr[i - 1];
    }
    newarr[0] = 0;

    for (i = 0; i < len; i++)
    {
      copyarr[newarr[(arr[i] / exp) % 10]++] = arr[i];
    }
    for (i = 0; i < len; i++)
    {
      arr[i] = copyarr[i];
    }
  }
}