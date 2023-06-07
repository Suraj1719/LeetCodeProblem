class Solution {
    public int minFlips(int a, int b, int c) {
        int s_a[]=new int[30];
        int s_b[]=new int[30];
        int s_c[]=new int[30];
        convertToString(a,s_a);
        convertToString(b,s_b);
        convertToString(c,s_c);
        int ans=0;
        int i=0;
        while(i<s_c.length){
            if(s_c[i]==0){
                if(s_a[i]==1)ans++;
                if(s_b[i]==1)ans++;
            }else{
                if(s_a[i]==0 && s_b[i]==0)ans++;
            }
            i++;
        }
        return ans;      
    }
    void convertToString(int n,int c[]){
        int i=0;
        while(n>0){
            int r=n%2;
            n/=2;
            c[i++]=r;
        }
    }
}
