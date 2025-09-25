class Solution {
    int dp[][];
    public int minimumTotal(List<List<Integer>> triangle) {
        int level=triangle.size();
        dp=new int[level+1][level+1];
        for(int i=0;i<=level;i++){
            for(int j=0;j<=level;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        return solve(0,0,level,triangle);
    }
    int solve(int i, int l,int lev,List<List<Integer>> t){
        if(l==lev)return 0;

        if(dp[i][l]!=Integer.MAX_VALUE)return dp[i][l];
        int cur_min_path_sum=t.get(l).get(i);

        cur_min_path_sum+=Math.min(solve(i,l+1,lev,t),solve(i+1,l+1,lev,t));

        return dp[i][l]=cur_min_path_sum;
    }
}