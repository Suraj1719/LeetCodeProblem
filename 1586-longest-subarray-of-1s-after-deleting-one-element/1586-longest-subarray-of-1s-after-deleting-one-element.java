class Solution {
    public int longestSubarray(int[] nums) {
        int len=nums.length;
        boolean one=false;
        int pre_con_one[]=new int[len];
        int con_one=0;

        for(int i=0;i<len;i++){
            if(nums[i]==1){
                con_one++;
                one=true;
            }else{
                pre_con_one[i]=con_one;
                con_one=0;
            }
        }
        int post_con_one[]=new int[len+1];
        con_one=0;

        for(int i=len-1;i>=0;i--){
            if(nums[i]==1){
                con_one++;
            }else{
                post_con_one[i]=con_one;
                con_one=0;
            }
        }

        int ans=0;
        for(int i=0;i<len;i++){
            ans=Math.max(ans,post_con_one[i]+pre_con_one[i]);
        }

        if(ans==0 && one==true)ans=len-1;
        
        return ans;
    }
}