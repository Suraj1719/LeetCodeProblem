class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=queries.length;
        int []ans=new int[n];
        int xor_cal[]=new int[arr.length];
        xor_cal[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            xor_cal[i]=xor_cal[i-1]^arr[i];
        }
        for(int i=0;i<n;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            if(l==0)ans[i]=xor_cal[r];
            else ans[i]=xor_cal[r]^xor_cal[l-1];
        }
        return ans;
    }
}