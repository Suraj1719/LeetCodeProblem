//we can say it is the follow up question of leetcode : 84


class Solution {
    public int maximalRectangle(char[][] matrix) {
        //simply we can change the question into largest rectangle area
        //and we  pass every row and find out max area
        int n=matrix.length;
        int m=matrix[0].length;
        int maxArea=0;
        int height[]=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1')
                height[j]++;
                else
                height[j]=0;
            }
            int cur_area=largestRectangleArea(height);
            System.out.println(cur_area);
            maxArea=Math.max(maxArea,cur_area);
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        //using stack to find left smaller and right smaller
        //time : O(n)   space :O(3*n)
        int n = heights.length;
        Stack < Integer > st = new Stack < > ();
        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) leftSmall[i] = 0;
            else leftSmall[i] = st.peek() + 1;
            st.push(i);
        }

        // clear the stack to be re-used
        while (!st.isEmpty()) st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) rightSmall[i] = n - 1;
            else rightSmall[i] = st.peek() - 1;

            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;
    }
}
