class Solution {
    public int countTriplets(int[] arr) {
        //Approach 2: Nested Prefix XOR  time:O(n^2)  space :O(n)

        int[] prefixXOR = new int[arr.length + 1];
        prefixXOR[0] = 0;
        System.arraycopy(arr, 0, prefixXOR, 1, arr.length);
        int size = prefixXOR.length;

        // Perform XOR on consecutive elements in the modified array
        for (int i = 1; i < size; i++) {
            prefixXOR[i] ^= prefixXOR[i - 1];
        }

        int count = 0;

        // Iterate through the modified array to count triplets
        for (int start = 0; start < size; start++) {
            for (int end = start + 1; end < size; end++) {
                if (prefixXOR[start] == prefixXOR[end]) {
                    // Increment the result by the count of valid triplets
                    count += end - start - 1;
                }
            }
        }

        return count;
    }
}