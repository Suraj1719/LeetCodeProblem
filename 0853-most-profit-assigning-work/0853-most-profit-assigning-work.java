class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //Approach - 1(BruteForce) time:O(n*m)
        int n=difficulty.length;
        int m=worker.length;
        int ans=0;
        for(int i=0;i<m;i++){
            int cur_max_pro=0;
            for(int j=0;j<n;j++){
                if(difficulty[j]<=worker[i]){
                    cur_max_pro=Math.max(cur_max_pro,profit[j]);
                }
            }
            ans+=cur_max_pro;
        }
        return ans;
    }
}