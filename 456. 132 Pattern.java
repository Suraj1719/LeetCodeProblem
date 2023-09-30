Brute Force : O(n^3)
    class Solution {
    public boolean find132pattern(int[] nums) {
        //brute force - TLE :O(n^3)
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]<nums[k] && nums[k]<nums[j])
                    return true;
                }
            }
        }
        return false;
    }
}

Better approach : O(n^2)

    class Solution {
    public boolean find132pattern(int[] nums) {
        
        int num_i=nums[0];
        int n=nums.length;
        for(int j=1;j<n-1;j++){
            num_i=Math.min(num_i,nums[j]);
            for(int k=j+1;k<n;k++){
                if(num_i<nums[k] && nums[k]<nums[j])return true;
            }
        }
        return false;
    }
}

//Best approach : (stack):O(n)

class Solution {
    public boolean find132pattern(int[] nums) {
        //Stack & Left Approach
        //time :O(n)  == space
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third) return true;

            while (!stack.isEmpty() && stack.peek() < nums[i]) {
            //means there is a big number present
            //before third and when another number comes which is less then third condition satisfy
                third = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
