YT : https://www.youtube.com/watch?v=QlQOq3SMR1w

Approach - 1

  class Solution {
    public int[] countBits(int n) {
        //time :O(n logn)
        int ans[]=new int[n+1];
        for(int i=0;i<=n;i++){
            int count=0;
            int j=i;
            while(j>0){
                int r=j%2;
                if(r==1)count++;
                j=j/2;
            }
            ans[i]=count;
        }
    return ans;
    }
}

Approach -2
  class Solution {
    //Method 1: Dynamic Programming with Bit Manipulation
    public int[] countBits(int n) {

        //time = space =O(n)
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
        
    }
}
