Brute Force Approach :
time complexxity :O(n^3)
  space complexity :O(1)
    
    class Solution {
    public int equalPairs(int[][] grid) {
        int n=grid.length;
        int ans=0;

        for(int i=0;i<n;i++){
            
            for(int j=0;j<n;j++){
                int count=0;
                for(int k=0;k<n;k++){
                    if(grid[i][k]!=grid[k][j])
                    break;

                    count++;
                }
                System.out.println(count);
                if(count==n)ans++;
            }
        }
    return ans;
    }
}

Optimisation using HashMap :
time complexity :O(n^2)
space complexity :O(n^2)
    
    class Solution {
    public int equalPairs(int[][] grid) {
        //using hashmap  
        //time :O(n^2)  space:O(n^2)

        int ans = 0;
        int n = grid.length;

        // Keep track of the frequency of each row.
        Map<String, Integer> rowVal_frq = new HashMap<>();
        for (int[] row : grid) {
            String rowString = Arrays.toString(row);
            rowVal_frq.put(rowString, 1 + rowVal_frq.getOrDefault(rowString, 0));
        }

        // Add up the frequency of each column in map.
        for (int c = 0; c < n; c++) {
            int[] colVal = new int[n];
            for (int r = 0; r < n; ++r) {
                colVal[r] = grid[r][c];
            }
            ans += rowVal_frq.getOrDefault(Arrays.toString(colVal), 0);
        }

        return ans;
    }
}
