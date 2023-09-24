Approach - 1 (Recursion)(time : exponential giving tle)

  class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
      //gives tle  :time :O(exponential)
        return Math.min(1.0,solve(poured,query_row,query_glass));
    }
    double solve(int p,int r,int c){
      if(r<0 || c<0 || r<c)
      return 0.0;

      if(r==0 && c==0)return p;

      double up_left=(solve(p,r-1,c-1)-1)/2.0;
      double up_right=(solve(p,r-1,c)-1)/2.0;

      if(up_left<0)up_left=0.0;
      if(up_right<0)up_right=0.0;

      return up_right+up_left;
    }
}

Approach - 2(recursion + memo) time :O(n*m) space :O(n*m)+O(extra stack space)

  class Solution {
  double dp[][];
    public double champagneTower(int poured, int query_row, int query_glass) {
      //memoization
      dp=new double[101][101];
      for(int i=0;i<101;i++){
        Arrays.fill(dp[i],-1);
      }
        return Math.min(1.0,solve(poured,query_row,query_glass));
    }
    double solve(int p,int r,int c){
      if(r<0 || c<0 || r<c)
      return 0.0;

      if(r==0 && c==0)return p;
      if(dp[r][c]!=-1)return dp[r][c];

      double up_left=(solve(p,r-1,c-1)-1)/2.0;
      double up_right=(solve(p,r-1,c)-1)/2.0;

      if(up_left<0)up_left=0.0;
      if(up_right<0)up_right=0.0;

      return dp[r][c]=up_right+up_left;
    }
}


Approach - 3 ( Bottomup) (time :O(n*m)  space :O(n*m)

  class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        //bottom up
        //time O(n*m)== space
        double dp[][]=new double[101][101];
        dp[0][0]=poured;
        for(int i=0;i<=query_row;i++){
          for(int col=0;col<=i;col++){
            double extra=(dp[i][col]-1)/2.0;

            if(extra>0){
              dp[i+1][col]+=extra;
              dp[i+1][col+1]+=extra;
            }
          }
          
        }
        return Math.min(1.0,dp[query_row][query_glass]);
    }
}
