//leetcode : 84. Largest Rectangle in Histogram(hard)

//brute force approach

//time complexity : (n^2)   space : O(1)
class Solution {
    public int largestRectangleArea(int[] arr) {
        //brute force time : O(n^2)
        int n=arr.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, arr[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }
}

//using stack we find left smallest bar and right smallest bar for cur bar

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        if(n==1){
            return heights[0];
        }
        int left_nearest_small[]=new int[n];
        int right_nearest_small[]=new int[n];

        Stack<Integer>stack=new Stack<>();

        //left nearest bar index
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }

            if(stack.isEmpty())
            left_nearest_small[i]=0;
            else left_nearest_small[i]=stack.peek()+1;

            stack.push(i);
        }
        // clear the stack to be re-used
        while (!stack.isEmpty()) stack.pop();
        
        //right nearest bar index
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) 
            right_nearest_small[i] = n - 1;
            else 
            right_nearest_small[i] = stack.peek() - 1;

            stack.push(i);
        }

        int maxArea=0;
        for(int i=0;i<n;i++){
    maxArea=Math.max(maxArea,heights[i]*(right_nearest_small[i]-left_nearest_small[i]+1));
        }
        return maxArea;
    }
}
