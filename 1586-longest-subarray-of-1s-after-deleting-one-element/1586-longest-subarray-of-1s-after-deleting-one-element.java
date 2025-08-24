// class Solution {
//     public int longestSubarray(int[] nums) {
//         int len=nums.length;
//         boolean one=false;
//         int pre_con_one[]=new int[len];
//         int con_one=0;

//         for(int i=0;i<len;i++){
//             if(nums[i]==1){
//                 con_one++;
//                 one=true;
//             }else{
//                 pre_con_one[i]=con_one;
//                 con_one=0;
//             }
//         }
//         int post_con_one[]=new int[len+1];
//         con_one=0;

//         for(int i=len-1;i>=0;i--){
//             if(nums[i]==1){
//                 con_one++;
//             }else{
//                 post_con_one[i]=con_one;
//                 con_one=0;
//             }
//         }

//         int ans=0;
//         for(int i=0;i<len;i++){
//             ans=Math.max(ans,post_con_one[i]+pre_con_one[i]);
//         }

//         if(ans==0 && one==true)ans=len-1;

//         return ans;
//     }
// }



//approach - 2 sliding window

class Solution {
    public int longestSubarray(int[] nums) {
        // Number of zero's in the window.
        int zeroCount = 0;
        int longestWindow = 0;
        // Left end of the window.
        int start = 0;
        
        for (int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0 ? 1 : 0);
                          
            // Shrink the window until the count of zero's
            // is less than or equal to 1.
            while (zeroCount > 1) {
                zeroCount -= (nums[start] == 0 ? 1 : 0);
                start++;
            }
              
            longestWindow = Math.max(longestWindow, i - start);
        }

        return longestWindow;
    }
}