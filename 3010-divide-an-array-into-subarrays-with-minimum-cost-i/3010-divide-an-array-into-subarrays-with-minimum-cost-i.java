class Solution {
    int restTwoEleSum(int l,int a[]){
        int n=a.length;
        int min=Integer.MAX_VALUE;
        int sec_min=Integer.MAX_VALUE;
        for(int i=l;i<n;i++){
            if(a[i]<min){
                sec_min=min;
                min=a[i];
            }else if(a[i]<sec_min){
                sec_min=a[i];
            }
        }
        return min+sec_min;
    }
    public int minimumCost(int[] nums) {
        int n=nums.length;
        int sum=nums[0];
        int sum_two_min=restTwoEleSum(1,nums);

        return sum+sum_two_min;
    }
}