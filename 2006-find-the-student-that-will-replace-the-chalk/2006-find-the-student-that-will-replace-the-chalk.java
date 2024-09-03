class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        //Approach - 1 Basic  O(n* )
        while(k>=0){
            for(int i=0;i<chalk.length;i++){
                if(chalk[i]>k)return i;
                k-=chalk[i];
            }
        }
        return -1;
        // //prefix sum   O(n) O(1)
        //  // Find the sum of all elements.
        // long sum = 0;
        // for (int i = 0; i < chalk.length; i++) {
        //     sum += chalk[i];
        //     if (sum > k) {
        //         break;
        //     }
        // }
        // // Find modulo of k with sum.
        // k = k % (int) sum;
        // for (int i = 0; i < chalk.length; i++) {
        //     if (k < chalk[i]) {
        //         return i;
        //     }
        //     k = k - chalk[i];
        // }
        // return 0;
        // //Binary Search O(log n)
        // int n = chalk.length;

        // long[] prefixSum = new long[n];
        // prefixSum[0] = chalk[0];
        // for (int i = 1; i < n; i++) {
        //     prefixSum[i] = prefixSum[i - 1] + chalk[i];
        // }

        // long sum = prefixSum[n - 1];
        // long remainingChalk = (k % sum);

        // return binarySearch(prefixSum, remainingChalk);
    }

    private int binarySearch(long[] arr, long tar) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= tar) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }
}