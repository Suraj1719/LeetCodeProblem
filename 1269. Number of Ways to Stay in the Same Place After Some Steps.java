Brute Force : TLE (time : exponential)

  class Solution {
    int mod=1000000007;
    public int numWays(int steps, int arrLen) {
        return solve(0,steps,arrLen)%mod;
    }
    int solve(int ind,int s,int a){
        if(ind<0 || ind>=a)return 0;
        if(ind==0 && s==0)return 1;
        if(s==0)return 0;

        int same_pos=solve(ind,s-1,a)%mod;
        int left=solve(ind-1,s-1,a)%mod;
        int right=solve(ind+1,s-1,a)%mod;

        return (same_pos+left+right)%mod;
    }
}

Memoization + DP (memori exeded)

  class Solution {
    int mod=1000000007;
    int dp[][];
    public int numWays(int steps, int arrLen) {
        dp=new int[arrLen+1][steps+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,steps,arrLen)%mod;
    }
    int solve(int ind,int s,int a){
        if(ind<0 || ind>=a)return 0;
        if(ind==0 && s==0)return 1;
        if(s==0)return 0;

        if(dp[ind][s]!=-1)return dp[ind][s];

        int same_pos=solve(ind,s-1,a)%mod;
        int left=solve(ind-1,s-1,a)%mod;
        int right=solve(ind+1,s-1,a)%mod;

        return dp[ind][s]=(((same_pos+left)%mod)+right)%mod;
    }
}


Optimised :
class Solution {
    int mod=1000000007;
    long dp[][];
    public int numWays(int steps, int arrLen) {
        //important 
        int len=Math.min(arrLen,steps);//as if steps less then arrlen then we do not 
        //move till last arrlen
        dp=new long[len+1][steps+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,steps,len)%mod;
    }
    int solve(int ind,int s,int a){
        if(ind<0 || ind>=a || s<0)return 0;
        if(ind==0 && s==0)return 1;
        if(s==0)return 0;

        if(dp[ind][s]!=-1)return (int)dp[ind][s];

        int same_pos=solve(ind,s-1,a)%mod;
        int left=solve(ind-1,s-1,a)%mod;
        int right=solve(ind+1,s-1,a)%mod;

        dp[ind][s]=(((same_pos+left)%mod)+right)%mod;
        return (int)dp[ind][s];
    }
}
