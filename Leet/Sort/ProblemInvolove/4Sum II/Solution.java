// Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

// 1) 0 <= i, j, k, l < n
// 2) nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

import java.util.HashMap;

class Solution {
  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) 
  {
    int count = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    for (int i : nums1)
    {
      for (int j : nums2)
      {
        map.put(i + j, map.getOrDefault(i+j, 0) + 1);
      }
    }
    for (int k : nums3)
    {
      for (int l : nums4)
      {
        count += map.getOrDefault(-(k+l),0);
      }
    }
    return (count);
  }
}