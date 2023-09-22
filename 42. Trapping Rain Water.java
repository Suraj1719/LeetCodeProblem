Using Extra Space time O(n) + space O(n)
  
class Solution {
    public int trap(int[] height) {
        //p - 0 1 1 2 2 2 2 3 3 3 3 3
        //s - 3 3 3 3 3 3 3 3 2 2 2 1
        int n=height.length;
        int ans=0;
        int prefix_max[]=new int[n];
        prefix_max[0]=height[0];
        int suffix_max[]=new int[n];
        suffix_max[n-1]=height[n-1];
        int cur_max=height[0];
        for(int i=1;i<n;i++){
            cur_max=Math.max(cur_max,height[i]);
            prefix_max[i]=cur_max;
        }
        cur_max=height[n-1];
        for(int i=n-2;i>=0;i--){
            cur_max=Math.max(cur_max,height[i]);
            suffix_max[i]=cur_max;
        }

        //calculate total water
        for(int i=0;i<n;i++){
            ans+=Math.min(prefix_max[i],suffix_max[i])-height[i];
        }
        return ans;
    }
}


Without using space : time O(n)

  
  class Solution {
    public int trap(int[] height) {
        //two pointer
        int n = height.length;
        int l = 0;
        int r = n-1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;

        while(l < r){
            if(height[l] <= height[r]){

                if(height[l] >= leftMax){
                    leftMax = height[l];
                }else{
                    res += leftMax - height[l];
                }
                
                l++;
            }else {
                
                if(height[r] >= rightMax){
                    rightMax = height[r];
                }else{
                    res += rightMax - height[r];
                }
                r--;                
            }
        }
        return res;
    }
}
