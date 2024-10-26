class Solution {
    public long wonderfulSubstrings(String word) {
        //Approach -1 Find all sub strings then check each of one
        //time :O(n^2)  space:O(all substrings)

        //Approach -2 (Count Parity Prefixes)

        //time : O(len* no. of distinct character)
        //space:O(len)
        int N = word.length();

        // Create the frequency map
        // Key = bitmask, Value = frequency of bitmask key
        Map<Integer, Integer> freq = new HashMap<>();

        // The empty prefix can be the smaller prefix, which is handled like this
        //all frequemcies are even then xor of all becomes 0
        freq.put(0, 1);

        int mask = 0;
        long res = 0L;
        for (int i = 0; i < N; i++) {
            char c = word.charAt(i);
            int bit = c - 'a';

            // Flip the parity of the c-th bit in the running prefix mask

            //we used xor so that even number of frequency cancel each other
            mask ^= (1 << bit);
            
            // Count smaller prefixes that create substrings with no odd occurring letters
            res += freq.getOrDefault(mask, 0);

            // Increment value associated with mask by 1
            freq.put(mask, freq.getOrDefault(mask, 0) + 1);

            // Loop through every possible letter that can appear an odd number of times in a substring
            for (int odd_c=0; odd_c < 10; odd_c++) {
                res += freq.getOrDefault(mask ^ (1 << odd_c),0);
                //System.out.println(freq.getOrDefault(mask ^ (1 << odd_c),0)+" "+"Mask is "+mask);
                //System.out.println(mask ^ (1 << odd_c));
            }
        }
        return res;
    }
}