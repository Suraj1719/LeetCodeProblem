class Solution {

    int dp[][];
    public int maxMoves(int[][] grid) {

        //brute force time : exponential


        //dp   time :O(r*c)  space:O(r*c)+O(stack space)
        int row=grid.length;
        int col=grid[0].length;
        dp=new int[row][col];
        for(int i=0;i<row;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=0;
        for(int i=0;i<row;i++){
            ans=Math.max(ans,help(i,0,grid));
        }
        return ans;
    }
    int help(int r,int c,int g[][]){
        if(r>=g.length || c>=g[0].length)return 0;

        if(dp[r][c]!=-1)return dp[r][c];
        int cur_ans=0;
        //case 1
        if(r>0 && c+1<g[0].length && g[r-1][c+1]>g[r][c]){
            cur_ans=Math.max(cur_ans,1+help(r-1,c+1,g));
        }
        //case 2
        if(c+1<g[0].length && g[r][c+1]>g[r][c]){
            cur_ans=Math.max(cur_ans,1+help(r,c+1,g));
        }
        //case 3
        if(r+1<g.length && c+1<g[0].length && g[r+1][c+1]>g[r][c]){
            cur_ans=Math.max(cur_ans,1+help(r+1,c+1,g));
        }

        return dp[r][c]=cur_ans;
    }
}