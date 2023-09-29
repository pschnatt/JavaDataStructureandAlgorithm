import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution 
{
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    int len = nums.length;
    for (int i = 0; i < len - 3; i++) 
    {
      while (i > 0 && i < len - 3 && (nums[i] == nums[i - 1])) {i++;}
      for (int j = i + 1; j < len - 2; j++) 
      {
        while (j > i + 1 && j < len - 2 && (nums[j] == nums[j - 1])) {j++;}
        int k = j + 1;
        int l = len - 1;
        while (k < l && i < len - 3) 
        {
          long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
          if (sum == target) 
          {
            ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
            while (k < l && nums[k] == nums[k + 1]) {k++;}
            while (k < l && nums[l] == nums[l - 1]) {l--;}
            k++;
            l--;
          } 
          else if (sum < target) 
          {
            k++;
          } 
          else 
          {
            l--;
          }
        }
      }
    }
    return (ans);
  }
}