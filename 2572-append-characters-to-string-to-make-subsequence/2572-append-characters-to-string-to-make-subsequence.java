class Solution {
    public int appendCharacters(String s, String t) {
        //brute force : O(n*m)
        int n=s.length();
        int m=t.length();
        
        return help(0,m,0,n,s,t);
    }
    int help(int i,int m,int j,int n,String s,String t){
        if(i>=m)return 0;

        if(j>=n)return (m-i);

        char ch1=t.charAt(i);
        char ch2=s.charAt(j);
        int ans=0;
        return (ch1==ch2)?help(i+1,m,j+1,n,s,t):help(i,m,j+1,n,s,t);
    }
}