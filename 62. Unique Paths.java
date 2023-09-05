Approach : 1 (Recursion + Memo)

class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				dp[i][j]=-1;
			}
		}
		
		return totalPath(0,0,m,n,dp);
    }
    private static int totalPath(int x, int y, int n, int m, int[][] dp){
		
		if(x==n-1 && y==m-1)
           return 1;
        if(x>=n || y>=m)
            return 0;
        if(dp[x][y]!=-1)
        	return dp[x][y];
        
        else
        
        return dp[x][y]=totalPath(x+1,y,n,m,dp)+totalPath(x,y+1,n,m,dp);
		
	}
}

Approach -2 (Bottom Up Approach -DP)
class Solution {
    public int uniquePaths(int n, int m) {
        //tabulation approach
        //time = O(n*m)  =space
        int ans[][]=new int[n][m];
        //here [i][j] standes for no. of ways to reach (i,j) from (0,0)
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<m;j++) {
	    		if(i==0 && j==0)
	    			ans[i][j]=1;
	    		else {
	    			int up=0;
	    			int left=0;
	    			if(i>0)
	    			    up=ans[i-1][j];//oposite of down
	    			if(j>0)
	    				left=ans[i][j-1];//oposite of right move
	    			
	    			ans[i][j]=up+left;
	    		}
	    	}
	    }
	    return ans[n-1][m-1];
    }
}

		
	
