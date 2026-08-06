class Solution {
    public int smallestNumber(int n, int t) {
        while(n<=100){
            int temp=n;
            int pro=1;
            while(temp>0){
                int r=temp%10;
                temp/=10;
                pro*=r;
            }
            if(pro%t==0)return n;

            n++;
        }
        return 0;
    }
}