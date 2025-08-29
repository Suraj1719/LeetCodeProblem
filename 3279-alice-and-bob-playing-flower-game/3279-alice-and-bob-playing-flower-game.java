class Solution {
    public long flowerGame(int n, int m) {
        //we can see that Alice can only win the game when x+y is an odd number
        return ((long) m * n) / 2;
    }
}