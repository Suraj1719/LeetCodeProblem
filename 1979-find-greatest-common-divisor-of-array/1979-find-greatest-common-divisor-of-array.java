class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int min=nums[0];
        int max=nums[nums.length-1];
        return gcd(min,max);
    }
    int gcd(int min,int max){
        int ans=1;
        for(int i=2;i<=min;i++){
            if(min%i==0 && max%i==0){
                ans=i;
            }
        }
        return ans;
    }
}