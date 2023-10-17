Brute force :

  class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(solve(0,cost),solve(1,cost));
    }
    int solve(int ind,int c[]){
        if(ind>=c.length)return 0;

        int one_step=c[ind]+solve(ind+1,c);
        int two_step=c[ind]+solve(ind+2,c);

        return Math.min(one_step,two_step);
    }

}


Optimised :

class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        dp=new int[1010];
        Arrays.fill(dp,-1);
        return Math.min(solve(0,cost),solve(1,cost));
    }
    int solve(int ind,int c[]){
        if(ind>=c.length)return 0;

        if(dp[ind]!=-1)return dp[ind];

        int one_step=c[ind]+solve(ind+1,c);
        int two_step=c[ind]+solve(ind+2,c);

        return dp[ind]=Math.min(one_step,two_step);
    }

}
