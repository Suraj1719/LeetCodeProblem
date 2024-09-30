class Solution {
    //int ans;
    int dp[];
    public int jump(int[] nums) {
        //ans=Integer.MAX_VALUE;
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return help(0,nums);//index, no. of jumps,array
        //return ans;
    }
    int help(int ind,int a[]){
        if(ind==a.length-1){
            // System.out.println(jumps);
            // ans=Math.min(ans,jumps);
            return 0;
        }

        if(dp[ind]!=-1)return dp[ind];
        int min_jump=Integer.MAX_VALUE;
        int max_jump=a[ind];
        for(int i=1;i<=max_jump;i++){
            if(ind+i<a.length){
                min_jump=Math.min(min_jump,1+help(ind+i,a));
            }
        }
        return dp[ind]=(min_jump==Integer.MAX_VALUE)?1000000:min_jump;
    }
}