class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        int left_max[]=new int[n];
        int right_max[]=new int[n];
        int cur_max=nums[0];
        for(int i=0;i<n;i++){
            cur_max=Math.max(cur_max,nums[i]);
            left_max[i]=cur_max;
        }
        cur_max=nums[n-1];
        for(int i=n-1;i>=0;i--){
            cur_max=Math.max(cur_max,nums[i]);
            right_max[i]=cur_max;
        }
        
        long ans=0;
        for(int i=1;i<n-1;i++){
            long temp=left_max[i-1]-nums[i];
            temp*=right_max[i+1];
            ans=Math.max(ans,temp);
        }
        return ans;
        
    }
}
