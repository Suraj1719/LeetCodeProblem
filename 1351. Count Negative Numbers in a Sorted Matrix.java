java code :

Brute force approach :  time :O(n^2)  space:O(1)
  
  class Solution {
    public int countNegatives(int[][] grid) {
        //naive approach
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]<0)count++;
            }
        }
        return count;
    }
}

Binary Search: time :O(row * log(col size))  space :O(1)
  
  class Solution {
    public int countNegatives(int[][] grid) {
        //binary search
        //time :O(row log(col))
        int count = 0;
        int n = grid[0].length;
        // Iterate on all rows of the matrix one by one.
        for (int[] row : grid) {
            // Using binary search find the index
            // which has the first negative element.
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (row[mid] < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;  
                }
            }
            // 'left' points to the first negative element,
            // which means 'n - left' is the number of all negative elements.
            count += (n - left);
        }
        return count;
    }
}
