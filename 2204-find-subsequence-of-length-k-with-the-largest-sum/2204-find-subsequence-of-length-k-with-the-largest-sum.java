// class Solution {
//     public int[] maxSubsequence(int[] nums, int k) {
//         int size=k;
//         Queue<Integer>max=new PriorityQueue<>(Collections.reverseOrder());
//         for(int x:nums){
//             max.add(x);
//         }
//         Map<Integer,Integer>num_frq=new HashMap<>();
//         while(k>0){
//             int a=(int)max.poll();
//             if(num_frq.containsKey(a)){
//                 num_frq.put(a,num_frq.get(a)+1);
//             }else{
//                 num_frq.put(a,1);
//             }
//             k--;
//         }

//         int ans[]=new int[size];
//         int ind=0;
//         int i=0;
//         while(i<nums.length){
//             int number=nums[i];
//             if(num_frq.containsKey(number)){
//                 ans[ind++]=number;
//                 num_frq.put(number,num_frq.get(number)-1);

//                 if(num_frq.get(number)==0)num_frq.remove(number);
//             }
//             i++;
//         }
//         return ans;
//     }
// }

class Solution {

    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] vals = new int[n][2]; // two-dimensional array stores index and value
        for (int i = 0; i < n; ++i) {
            vals[i][0] = i; // store index
            vals[i][1] = nums[i]; // store value
        }
        // sort by numerical value in descending order
        Arrays.sort(vals, (x1, x2) -> Integer.compare(x2[1], x1[1]));
        // select the first k elements and sort them in ascending order by index
        Arrays.sort(vals, 0, k, (x1, x2) -> Integer.compare(x1[0], x2[0]));
        int[] res = new int[k]; // target subsequence
        for (int i = 0; i < k; ++i) {
            res[i] = vals[i][1];
        }
        return res;
    }
}