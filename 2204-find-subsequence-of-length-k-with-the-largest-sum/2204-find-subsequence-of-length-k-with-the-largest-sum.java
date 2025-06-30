class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int size=k;
        Queue<Integer>max=new PriorityQueue<>(Collections.reverseOrder());
        for(int x:nums){
            max.add(x);
        }
        Map<Integer,Integer>num_frq=new HashMap<>();
        while(k>0){
            int a=(int)max.poll();
            if(num_frq.containsKey(a)){
                num_frq.put(a,num_frq.get(a)+1);
            }else{
                num_frq.put(a,1);
            }
            k--;
        }

        int ans[]=new int[size];
        int ind=0;
        int i=0;
        while(i<nums.length){
            int number=nums[i];
            if(num_frq.containsKey(number)){
                ans[ind++]=number;
                num_frq.put(number,num_frq.get(number)-1);

                if(num_frq.get(number)==0)num_frq.remove(number);
            }
            i++;
        }
        return ans;
    }
}