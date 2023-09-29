// You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
// Given the integer n, return the number of complete rows of the staircase you will build.


//binary search

class Solution {
  public static void main(String[] args) {
    System.out.println(arrangeCoins(1804289383));
  }
    public static int arrangeCoins(int n) {
      long min = 0, max = n;
      long mid;
      long ans;

      while (min <= max)
      {
        mid = min + (max-min)/2;
        ans = (mid*(mid+1))/2;
        if (ans == n)
        {
          return ((int) mid);
        }
        if (ans < n)
        {
          min = mid + 1;
        }
        else
        {
          max = mid - 1;
        }
      }
      return ((int)min - 1); //this means that there's incomplete staircase
    }
}