class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int mod[]=new int[k];
        mod[0]=1;
        int cur_sum=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            cur_sum+=nums[i];
            cur_sum=cur_sum%k;
            
            if(cur_sum<0)
            cur_sum+=k;

            ans+=mod[cur_sum];
            mod[cur_sum]++;
        }
        return ans;
    }
}