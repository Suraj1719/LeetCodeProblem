YT sol: https://www.youtube.com/watch?v=T-Fk9185a68

Note : LIS varient

Approach - 1
  class Solution {
    //Approach-1 (Using Brute Force same as LIS)
//T.C : O(2^n) without memoization
//S.C : O(n)  gives tle
    public List<Integer> largestDivisibleSubset(int[] nums) {
         Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        generate(0, nums, result, temp, -1);

        return result;
    }
    private void generate(int idx, int[] nums, List<Integer> result, List<Integer> temp, int prev) {
        if (idx >= nums.length) {
            if (temp.size() > result.size()) {
                result.clear();
                result.addAll(temp);
            }
            return;
        }

        if (prev == -1 || nums[idx] % prev == 0) {
            temp.add(nums[idx]);
            generate(idx + 1, nums, result, temp, nums[idx]);
            temp.remove(temp.size() - 1);
        }

        generate(idx + 1, nums, result, temp, prev);
    }
}


Approach - 2

  class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
//Approach-2 (Using Bottom Up same as LIS) - Just need to keep track of how to print LIS
//T.C : O(n^2)
//S.C : O(n)
        Arrays.sort(nums);

        int n = nums.length;
        int[] len = new int[n];
        Arrays.fill(len, 1);

        int[] prevIdx = new int[n];
        Arrays.fill(prevIdx, -1);

        int lastChosenIndex = 0;
        int maxL = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        prevIdx[i] = j;
                    }

                    if (len[i] > maxL) {
                        maxL = len[i];
                        lastChosenIndex = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (lastChosenIndex >= 0) {
            System.out.println(lastChosenIndex);
            result.add(nums[lastChosenIndex]);
            lastChosenIndex = prevIdx[lastChosenIndex];
        }

        return result;
    }
}
