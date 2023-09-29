public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        solve2(nums1,m,nums2,n);
    }
    void solve(int[] nums1, int m, int[] nums2, int n){
        int[] merge = new int[m+n]; 
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < m && j < n)
        {
            if (nums1[i] < nums2[j])
                merge[k++] = nums1[i++];
            else
                merge[k++] = nums2[j++];
        }
        while (i < m){ merge[k++] = nums1[i++];}
        while (j < n){ merge[k++] = nums2[j++];}
        for (i = 0; i < m+n; i++){ nums1[i] = merge[i];}

        // time: o(m+n) + o(m) = O(2m+n) = O(m+n);
        // space: o(m)
    }
    void solve2(int[] nums1, int m, int[] nums2, int n){

        int p1 = m-1, p2 = n-1, i = m+n-1;

        // O(m+n - k) where k is the leftovers.
        while (p1 >= 0 && p2 >= 0){
            if (nums1[p1] >= nums2[p2]) nums1[i--] = nums1[p1--];
            else nums1[i--] = nums2[p2--];
        }

        // the k leftovers.
        while (p1 >= 0) nums1[i--] = nums1[p1--];
        while (p2 >= 0) nums1[i--] = nums2[p2--];

        // Time complexity is O(m+n), space: constant
    }
    
}