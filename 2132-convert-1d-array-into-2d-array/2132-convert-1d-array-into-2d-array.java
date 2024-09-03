class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int ans[][]=new int[m][n];
        int len=original.length;
        if(m*n != len)return new int[0][0];
        int r=0;
        for(int i=1;i<=len;i++){
            int ind=(i%n==0)?n-1:((i%n) -1);
            ans[r][ind]=original[i-1];
            if(i%n==0)r++;
        }
        return ans;
    }
}