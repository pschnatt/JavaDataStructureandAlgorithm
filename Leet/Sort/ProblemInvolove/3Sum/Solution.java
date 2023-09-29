// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{
  public List<List<Integer>> threeSum(int[] nums) 
  {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++)
    {
      if (i > 0 && nums[i] == nums[i - 1]){continue;} //if the adjacent value is the same, skip it
      
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k)
      {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0)
        {
          ans.add(Arrays.asList(nums[i],nums[j],nums[k]));

          while (j < k && nums[j] == nums[j + 1])
          {
            j++;
          }
          while (j < k && nums[k] == nums[k - 1])
          {
            k--;
          }
          j++;
          k--;
        }
        else if (sum < 0)
        {
          j++;
        }
        else //sum > 0
        {
          k--;
        }
      }
    }
    return (ans);
  }
}