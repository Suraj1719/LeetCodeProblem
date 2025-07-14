class Solution {
    public boolean search(int[] nums, int target) {
        int len=nums.length;
        int s=0;
        int e=len-1;
        int pivot_pos=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(nums[mid]==target)return true;

            if(nums[mid]==nums[s] && nums[mid]==nums[e]){
                s++;
                e--;
                continue;
            }

            if(nums[s]<=nums[mid]){
                if(target>=nums[s] && target<=nums[mid]){
                    e=mid-1;
                }else s=mid+1;
            }else{
                if(nums[mid]<=target && target<=nums[e]){
                    s=mid+1;
                }else e=mid-1;
            }
        }

        return false;
    }
}