public class Solution {
    public void duplicateZeros(int[] arr) {
        //SPACEwise
        // for (int i = 0; i < arr.length; i++)
        // {
        //     if (arr[i] == 0)
        //     {
        //         for (int j = arr.length - 1; j > i; j--)
        //             arr[j] = arr[j-1];
        //         if (i+1 < arr.length)
        //             i++;
        //     }
        // }
        
        //RUNTIMEwise
        // int[] newarr = new int[arr.length];
        // int j = 0;
        // for (int i = 0; i < arr.length; i++)
        // {
        //     if (arr[j] != 0)
        //     {
        //         newarr[i] = arr[j];
        //     }
        //     else if (arr[j] == 0 && i+1 < arr.length)
        //     {
        //         i++;
        //     }
        //     j++;
        // }
        // for (int i = 0; i < arr.length; i++)
        // {
        //     arr[i] = newarr[i];
        // }
    }
}