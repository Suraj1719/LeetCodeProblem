class Solution {
    public void sortColors(int[] nums) {
        //Approach - 1 Using sorting
        //time O(n logn)
        //Arrays.sort(nums);

        //Approach - 2 : counting
        // int zero=0;
        // int one=0;
        // int two=0;
        // for(int x:nums){
        //     if(x==0)zero++;
        //     else if(x==1)one++;
        //     else two++;
        // }
        // for(int i=0;i<nums.length;i++){
        //     if(zero>0){
        //         nums[i]=0;
        //         zero--;
        //     }else if(one>0){
        //         nums[i]=1;
        //         one--;
        //     }else{
        //         nums[i]=2;
        //         two--;
        //     }
        // }

        //Approach -3 : In place 
        int low=0;
        int mid=0;
        int high=nums.length-1;
        int temp;
        while(mid<=high){
            switch(nums[mid]){
                case 0:
                    {
                    temp=nums[mid];
                    nums[mid]=nums[low];
                    nums[low]=temp;
                    low++;mid++;
                    break;
                    }
                case 1:{
                    mid++;
                    break;
                }
                case 2:{
                    temp=nums[mid];
                    nums[mid]=nums[high];
                    nums[high]=temp;
                    high--;
                    break;
                }
            }
            
        }
    }
}