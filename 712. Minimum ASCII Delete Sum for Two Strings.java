//similar to fing longest common subsequence

approach - 1
  
  class Solution {
    int n,m;
    //like longest increasingSubsequence
    public int minimumDeleteSum(String s1, String s2) {

        //brute force : time :O(2^n)
        n=s1.length();
        m=s2.length();

        return solve(0,0,s1,s2);
    }
    int solve(int i,int j,String s1, String s2){
        if(i>=n && j>=m)
        return 0;

        if(i>=n)//first string is empty
        return (int)s2.charAt(j)+solve(i,j+1,s1,s2);

        if(j>=m)//second string end
        return (int)s1.charAt(i)+solve(i+1,j,s1,s2);

        //same charecter
        if(s1.charAt(i)==s2.charAt(j))
        return solve(i+1,j+1,s1,s2);
        //diff charecter
        return Math.min((int)s2.charAt(j)+solve(i,j+1,s1,s2),
                       (int)s1.charAt(i)+solve(i+1,j,s1,s2));
    }
    
}

approach - 2

  class Solution {
    int n,m;
    public int minimumDeleteSum(String s1, String s2) {

        //dp
        //time :O(n*m) == space
        n=s1.length();
        m=s2.length();

        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,s1,s2,dp);
    }
    int solve(int i,int j,String s1, String s2,int dp[][]){
        if(i>=n && j>=m)
        return 0;

        if(dp[i][j]!=-1)
        return dp[i][j];

        if(i>=n)//first string is empty
        return (int)s2.charAt(j)+solve(i,j+1,s1,s2,dp);

        if(j>=m)//second string end
        return (int)s1.charAt(i)+solve(i+1,j,s1,s2,dp);

        //same charecter
        if(s1.charAt(i)==s2.charAt(j))
        return solve(i+1,j+1,s1,s2,dp);
        //diff charecter
        return dp[i][j]=Math.min((int)s2.charAt(j)+solve(i,j+1,s1,s2,dp),
                       (int)s1.charAt(i)+solve(i+1,j,s1,s2,dp));
    }
    
}


approach - 3

  //Bottom-up Dynamic Programming

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        
        // Prepare the two-dimensional array
        int m = s1.length(), n = s2.length();
        int[][] computeCost = new int[m + 1][n + 1];

        // Fill in the base case values
        for (int i = 1; i <= m; i++) {
            computeCost[i][0] = computeCost[i-1][0] + s1.charAt(i-1);
        }
        for (int j = 1; j <= n; j++) {
            computeCost[0][j] = computeCost[0][j-1] + s2.charAt(j-1);
        }
        
        // Fill the remaining cells using the Bellman Equation
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    computeCost[i][j] = computeCost[i-1][j-1];
                } else {
                    computeCost[i][j] = Math.min(
                        s1.charAt(i-1) + computeCost[i-1][j],
                        s2.charAt(j-1) + computeCost[i][j-1]
                    );
                }
            }
        }
        
        // Return the answer for entire input strings
        return computeCost[m][n];
    }
}
