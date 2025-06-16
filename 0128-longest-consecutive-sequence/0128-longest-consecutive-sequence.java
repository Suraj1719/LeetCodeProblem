class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        int ans=0;
        Set<Integer>num=new HashSet<>();
        Set<Integer>vis=new HashSet<>();
        for(int x:nums){
            num.add(x);
        }
        for(int i=0;i<n;i++){
            int cur_num=nums[i];
            if(vis.contains(cur_num))continue;

            boolean small_present=true;
            while(small_present){
                if(num.contains(cur_num-1)){
                    cur_num--;
                }else small_present=false;
            }

            int cur_con_arr=0;
            while(true){
                if(num.contains(cur_num)){
                    cur_con_arr++;
                    vis.add(cur_num);
                    cur_num++;

                }else break;
            }

            ans=Math.max(ans,cur_con_arr);
        }

        return ans;
    }
}