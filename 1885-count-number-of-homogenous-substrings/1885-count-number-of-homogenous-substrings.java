class Solution {
    public int countHomogenous(String s) {
        // int mod=1000000007;
        // int total_sub_str=0;
        // int n=s.length();
        // for(int i=0;i<n;i++){
        //     int cur_len=0;
        //     char cur=s.charAt(i);
        //     int j=i;
        //     while(j<n && s.charAt(j)==cur){
        //         cur_len++;
        //         j++;
        //     }
        //     i=j-1;
        //     total_sub_str=(total_sub_str+(cur_len*(cur_len+1)/2))%mod;

        // }
        // return total_sub_str;

        int ans = 0;
        int currStreak = 0;
        int MOD = (int) 1e9 + 7;
        
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
                currStreak++;
            } else {
                currStreak = 1;
            }
            
            ans = (ans + currStreak) % MOD;
        }
        
        return ans;
    }
}