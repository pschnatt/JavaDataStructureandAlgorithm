// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// You must solve this problem without using the library's sort function.

// Follow up: Could you come up with a one-pass algorithm using only constant extra space?

class Solution {
  public void sortColors(int[] nums) 
  {
      int leftindex = 0;
      int rightindex = nums.length - 1;
      int index = 0;

      while (index <= rightindex)
      {
          if (nums[index] == 0)
          {
              if (nums[leftindex] != 0)
                  swap(nums, leftindex, index);
              leftindex++;
              index++;
          }
          else if (nums[index] == 2)
          {
              if (nums[rightindex] != 2)
                  swap(nums, rightindex, index);
              rightindex--;
          }
          else
          {
              index++;
          }
      }
  }
  public static void swap(int[] num, int a, int b)
  {
      int temp = num[a];
      num[a] = num[b];
      num[b] = temp; 
  }
}