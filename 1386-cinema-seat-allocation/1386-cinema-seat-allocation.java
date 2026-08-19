class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map to group reserved seats by row
        Map<Integer, Set<Integer>> rowToSeats = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            // We only care about seats 2 to 9
            if (col >= 2 && col <= 9) {
                rowToSeats.computeIfAbsent(row, k -> new HashSet<>()).add(col);
            }
        }
        
        // Start by assuming all rows are completely empty (2 families per row)
        
        // Then we subtract 2 for each row that has reservations, and calculate its actual capacity
        int totalFamilies = (n - rowToSeats.size()) * 2;
        
        for (Set<Integer> reserved : rowToSeats.values()) {
            boolean leftBlocked = reserved.contains(2) || reserved.contains(3) || reserved.contains(4) || reserved.contains(5);
            boolean rightBlocked = reserved.contains(6) || reserved.contains(7) || reserved.contains(8) || reserved.contains(9);
            boolean middleBlocked = reserved.contains(4) || reserved.contains(5) || reserved.contains(6) || reserved.contains(7);
            
            if (!leftBlocked && !rightBlocked) {
                totalFamilies += 2;
            } else if (!leftBlocked || !rightBlocked || !middleBlocked) {
                totalFamilies += 1;
            }
            // If all are blocked, we add 0
        }
        
        return totalFamilies;
    }
}