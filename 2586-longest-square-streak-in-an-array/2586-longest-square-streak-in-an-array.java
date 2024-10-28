class Solution {
    public int longestSquareStreak(int[] nums) {
        //Arrays.sort(nums);
        int max_pos_len=-1;
        int len=nums.length;
        Set<Long>vis=new HashSet<>();
        Set<Long>ele=new HashSet<>();
        for(int e:nums){
            ele.add(e*1l);
        }
        for(int i=0;i<len;i++){  //O(n)
            long temp=nums[i]*1l;
            //System.out.println(temp);
            if(vis.contains(temp))continue;
            vis.add(temp);
            int cur_size=0;
            while(ele.contains(temp*temp)){ //O(log n)
                cur_size++;
                System.out.println("inside "+temp);
                temp=temp*temp;
                System.out.println("inside 2 ="+temp);
                vis.add(temp);
                max_pos_len=Math.max(max_pos_len,cur_size+1);
            }
            
        }
        return max_pos_len;
    }
}