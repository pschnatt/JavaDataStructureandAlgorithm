import java.util.Arrays;

class Solution {
  public int threeSumClosest(int[] nums, int target) {
      int closest = nums[0] + nums[1] + nums[2];
      int len = nums.length;
      Arrays.sort(nums);
      if (len == 3) {return closest;}
      for (int i = 0; i < len - 2; i++)
      {
        int j = i + 1;
        int k = len - 1;
        while(j < k)
        {
          int sum = nums[i] + nums[j] + nums[k];
          if (sum == target)
          {
            return target;
          }
          else if (sum > target)
          {
            k--;
          }
          else
          {
            j++;
          }

          if (Math.abs(closest - target) > Math.abs(sum - target))
          {
            closest = sum;
          }
        }
      }
      return closest;
  }
}