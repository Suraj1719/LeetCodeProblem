class Solution {
    public boolean canPartition(int[] nums) {
        //brute force 
        //time complexity : O(n*sum)
        //space complexity :O(n*sum)+O(n) 
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2==1)
            return false;
        sum/=2;
        int dp[][]=new int[n][sum+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            dp[i][0]=1;//1 denote true and 0 as false  and -1 as not visited
        }

        return isPossible(n-1,nums,sum,dp)==1;
    }
    private static int isPossible(int n, int[] nums, int sum,int dp[][]) {
        if(sum==0)//base case
            return 1;
        if(n==0)
            return nums[0]==sum?1:0;
        if(dp[n][sum]!=-1)
        return dp[n][sum];
        int take=0;
        int notTake=isPossible(n-1,nums,sum,dp);
        if(nums[n]<=sum)
            take=isPossible(n-1,nums,sum-nums[n],dp);

        return dp[n][sum]=take | notTake;
    }
}