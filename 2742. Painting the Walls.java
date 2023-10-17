Brute Force : TLE (time :exponential)
class Solution {
    public int paintWalls(int[] cost, int[] time) {

        //recursion : TLE
        int n=cost.length;
        return solve(0,n,cost,time);//index,rem_walls,cost array,time array
    }
    int solve(int ind,int rem_walls,int c[],int []t){
        //base case
        if(rem_walls<=0)return 0;
        if(ind>=c.length)return 100000000;

        int painted=c[ind]+solve(ind+1,rem_walls-1-t[ind],c,t);
        int not_paint=solve(ind+1,rem_walls,c,t);

        return Math.min(painted,not_paint);
    }
}


(Recursion + Memo )

  class Solution {
    int dp[][];
    public int paintWalls(int[] cost, int[] time) {

        //recursion : TLE
        int n=cost.length;
        dp=new int[501][501];
        for(int i=0;i<501;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,n,cost,time);//index,rem_walls,cost array,time array
    }
    int solve(int ind,int rem_walls,int c[],int []t){
        //base case
        if(rem_walls<=0)return 0;
        if(ind>=c.length)return (int)1000000000;

        if(dp[ind][rem_walls]!=-1)return dp[ind][rem_walls];

        int painted=c[ind]+solve(ind+1,rem_walls-1-t[ind],c,t);
        int not_paint=solve(ind+1,rem_walls,c,t);

        return dp[ind][rem_walls]=Math.min(painted,not_paint);
    }
}
