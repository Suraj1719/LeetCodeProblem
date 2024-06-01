class Solution {
    public int scoreOfString(String s) {
        int ans=0;
        int prev=(int)s.charAt(0);
        int n=s.length();
        for(int i=1;i<n;i++){
            int cur=(int)(s.charAt(i));
            ans+=Math.abs(prev-cur);
            prev=cur;
        }
    return ans;
    }
}