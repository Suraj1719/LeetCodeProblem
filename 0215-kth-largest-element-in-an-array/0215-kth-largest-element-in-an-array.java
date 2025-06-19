class Solution {
    public int findKthLargest(int[] nums, int k) {
        //time : O(n logn)  space"O(1)
        int n=nums.length;
        Arrays.sort(nums);
        return nums[n-k];
    }
}