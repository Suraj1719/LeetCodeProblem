Approach - 1 (without using any space + swaping technique(two pointer)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        while(l<r){

            if(nums[l]%2==0){
                l++;
            }else{
                if(nums[r]%2==0){
                    int temp=nums[l];
                    nums[l]=nums[r];
                    nums[r]=temp;
                    l++;
                }
                r--;
            }
        }
    return nums;
    }
}

Approach - 2 (using extra space)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        //extra space
        int n=nums.length;
        int ans[]=new int[n];
        int index=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0)ans[index++]=nums[i];
        }
        for(int i=0;i<n;i++){
            if(nums[i]%2==1)ans[index++]=nums[i];
        }
        return ans;
    }
}

