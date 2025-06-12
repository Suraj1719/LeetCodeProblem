class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n=nums.length;
        int max_adj_abs_diff=Math.abs(nums[0]-nums[n-1]);
        for(int i=1;i<n;i++){
            max_adj_abs_diff=Math.max(max_adj_abs_diff,Math.abs(nums[i]-nums[i-1]));
        }
        return max_adj_abs_diff;
    }
}