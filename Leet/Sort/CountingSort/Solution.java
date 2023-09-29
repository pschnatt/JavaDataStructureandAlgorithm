public class Solution
{
  public static void main(String[] args) 
  {
    int[] s = {1,2,3,0,1,2,1,3,1,2,1,0,1,0,0,2,0,3,0,1,0,2,0,1,0,3,0,1,0,2};
    countingsort(s);
    for (int i : s)
    {
      System.out.println(i);
    }
  }

  public static void countingsort(int[] arr)
  {
    int len = arr.length;
    int max = arr[0];
    int[] copyarr = new int[len];
    for (int i = 1; i < len; i++)
    {
      if (arr[i] > max) {max = arr[i];}
    }
    int[] newarr = new int[max + 1];
    for (int i = 0; i < len; i++)
    {
      newarr[arr[i]]++;
    }
    for (int i = 1; i < max + 1; i++)
    {
      newarr[i] += newarr[i-1];
    }
    for (int i = max; i > 0; i--)
    {
      newarr[i] = newarr[i - 1];
    }
    newarr[0] = 0;

    for (int i = 0; i < len; i++)
    {
      copyarr[newarr[arr[i]]++] = arr[i];
    }
    for (int i = 0; i < len; i++)
    {
      arr[i] = copyarr[i];
    }
  }
}