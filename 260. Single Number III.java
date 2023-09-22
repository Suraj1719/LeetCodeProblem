Optimal approach : time = O(n) space =O(1)
  
class Solution {
    boolean checkBit(int n,int ind){
        if((n & (1<<ind))==0)
        return false;

        return true;
    }
    public int[] singleNumber(int[] nums) {
        int n=nums.length;
        int xor=0;
        for(int x:nums)xor=xor^x;//same number cancels

        int index=0;
        for(int i=0;i<32;i++){
            if(checkBit(xor,i)==true){
                index=i;
                break;
            }
        }

        int num1=0;//set
        int num2=0;//off

        for(int i=0;i<n;i++){
            if(checkBit(nums[i],index)==true)
            num1=num1^nums[i];
            else
            num2=num2^nums[i];
        }

        return new int[]{num1,num2};
    }
}
