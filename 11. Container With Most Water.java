Approach -1 :
Brute force two for loop . Time :O(n^2)  space:O(1)

Approach - 2(Two pointer)
  class Solution {
    public int maxArea(int[] height) {
        //brute force : use two loop : O(n^2)
        //two pointer approach
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        
        while(l< r){
            
            if(height[l] < height[r]){
                
                ans = Math.max(ans, height[l] * (r - l)); 
                l += 1; 
            }
            else{
                ans = Math.max(ans, height[r] * (r - l)); 
                r -= 1; 
            }
        }
        return ans;
    }
}
