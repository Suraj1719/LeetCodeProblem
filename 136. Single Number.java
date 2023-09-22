class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int x:nums)ans=ans^x;

        return ans;
    }
}
