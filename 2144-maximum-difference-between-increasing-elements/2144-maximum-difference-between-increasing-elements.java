class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int prefix_min[]=new int[n];
        int suff_max[]=new int[n];
        prefix_min[0]=nums[0];
        suff_max[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            prefix_min[i]=Math.min(prefix_min[i-1],nums[i]);
        }
        for(int i=n-2;i>=0;i--){
            suff_max[i]=Math.max(suff_max[i+1],nums[i]);
        }

        int ans=0;
        for(int i=1;i<n;i++){
            ans=Math.max(ans,suff_max[i]-prefix_min[i-1]);
        }
        return ans==0?-1:ans;
    }
}