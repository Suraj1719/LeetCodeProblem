class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n==1) return true;
        int start=n-2;
        int loc=n-1;
        while(start>=0){
            if(nums[start]<(loc-start)){
                start-=1;
            }else {
                loc=start;
                start=loc-1;
            }
        }
        return loc==0?true:false;
    }
}