class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zero=0;
        int len=nums.length;
        int mul=1;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                zero++;
            }else{
                mul*=nums[i];
            }
        }
        int ans[]=new int[len];
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                if(zero>1)ans[i]=0;
                else ans[i]=mul;
            }else{
                if(zero>0){
                    ans[i]=0;
                }else{
                    ans[i]=mul/nums[i];
                }
            }
        }
        return ans;
    }
}