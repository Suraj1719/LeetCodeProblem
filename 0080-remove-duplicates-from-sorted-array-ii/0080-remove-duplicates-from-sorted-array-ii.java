class Solution {
    public int removeDuplicates(int[] nums) {
        int l=0;int r=0;
        int n=nums.length;
        while(r<n){
            int num=nums[r];
            int cur_frq=0;
            while(r<n && nums[r]==num){
                cur_frq++;
                nums[l++]=nums[r++];

                if(cur_frq==2)break;
            }
            while(r<n && nums[r]==num)r++;
        }
        return l;
    }
}