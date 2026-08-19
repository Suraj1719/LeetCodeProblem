class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map row number to its bitmask representing reserved seats
        Map<Integer, Integer> rowToMask = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            // We only care about seats 2 to 9
            if (col >= 2 && col <= 9) {
                int currentMask = rowToMask.getOrDefault(row, 0);
                rowToMask.put(row, currentMask | (1 << col));
            }
        }
        
        // Assume 2 families for all completely empty rows
        int totalFamilies = (n - rowToMask.size()) * 2;
        
        // Define our target masks
        int leftMask = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int rightMask = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);
        int middleMask = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        
        for (int mask : rowToMask.values()) {
            boolean leftFree = (mask & leftMask) == 0;
            boolean rightFree = (mask & rightMask) == 0;
            boolean middleFree = (mask & middleMask) == 0;
            
            if (leftFree && rightFree) {
                totalFamilies += 2;
            } else if (leftFree || rightFree || middleFree) {
                totalFamilies += 1;
            }
        }
        
        return totalFamilies;
    }
}