class Solution {
    public int longestStrChain(String[] words) {
        //dp solution
        //time complexity : O(n logn)+O(n^2)*O(max. length of string)
        //space com :O(n)
        Arrays.sort(words,(a,b)->a.length()-b.length());

        int n=words.length;
        int dp[]=new int[n];//length
        Arrays.fill(dp,1);
        int maxLen=1;
        for(int i=0;i<n;i++){

            for(int j=0;j<i;j++){
                if(checkPossible(words[i],words[j]) && dp[i]<1+dp[j]){
                    dp[i]=1+dp[j];
                }
            }
            if(dp[i]>maxLen)
                maxLen=dp[i];
        }

        return maxLen;
    }
    private boolean checkPossible(String s, String t) {//cur string , predecessor str.
        if(s.length()!=1+t.length()) return false;
        int start=0;
        int sec=0;
        while(start<s.length()){

            if(sec<t.length() && s.charAt(start)==t.charAt(sec)){
                start++;
                sec++;
            }else
                start++;

        }
        if(start==s.length() && sec==t.length()) return true;
        
        return false;
    }
}
