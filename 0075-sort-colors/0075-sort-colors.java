class Solution {
    public void sortColors(int[] nums) {
        //Approach - 1 Using sorting
        //time O(n logn)
        //Arrays.sort(nums);

        //Approach - 2 : counting
        int zero=0;
        int one=0;
        int two=0;
        for(int x:nums){
            if(x==0)zero++;
            else if(x==1)one++;
            else two++;
        }
        for(int i=0;i<nums.length;i++){
            if(zero>0){
                nums[i]=0;
                zero--;
            }else if(one>0){
                nums[i]=1;
                one--;
            }else{
                nums[i]=2;
                two--;
            }
        }
    }
}