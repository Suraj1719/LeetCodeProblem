class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer>num_frq=new HashMap<>();
        int ans=0; int cur_sum=0;
        num_frq.put(cur_sum,1);
        for(int i=0;i<n;i++){
            cur_sum+=nums[i];
            if(num_frq.containsKey((cur_sum-k))){
                ans+=num_frq.get((cur_sum-k));

            }

            if(num_frq.containsKey(cur_sum)){
                num_frq.put(cur_sum,num_frq.get(cur_sum)+1);
            }else num_frq.put(cur_sum,1);
        }

        return ans;
    }
}