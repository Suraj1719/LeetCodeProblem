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
