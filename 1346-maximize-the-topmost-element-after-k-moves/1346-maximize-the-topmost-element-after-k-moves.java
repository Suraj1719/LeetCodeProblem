class Solution {
    public int maximumTop(int[] nums, int k) {
        int ans=-1;
        int n=nums.length;
        if(n==1 && k%2==1)return ans;
        int cur_op=0;
        for(int i=0;i<n;i++){
            if(k-cur_op<=1)break;
            cur_op++;
            ans=Math.max(ans,nums[i]);
        }
        if(k<n)ans=Math.max(ans,nums[k]);
        return ans;
    }
}