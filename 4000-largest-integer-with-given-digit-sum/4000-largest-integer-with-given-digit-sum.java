class Solution {
    public int largestInteger(int n, int s) {
        if((n*9)<s)return -1;
        int num=0;
        while(n>0 && s>0){
            if(9<=s){
                num=(num*10)+9;
                s-=9;
            }else{
                num=(num*10)+s;
                s=0;
            }
            n--;
        }

        while(n>0){
            num*=10;
            n--;
        }
        return num;
    }
}