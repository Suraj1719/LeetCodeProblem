class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length;
        int max_score=0;
        int cur_score=0;
        Set<Integer>unique=new HashSet<>();
        int right=0;
        int left=0;
        while(right<n){
            int cur_num=nums[right];
            if(unique.contains(cur_num)){
                while(left<right && unique.contains(cur_num)){
                    cur_score-=nums[left];
                    unique.remove(nums[left]);
                    left++;
                }
            }
            unique.add(cur_num);
            cur_score+=cur_num;
            max_score=Math.max(max_score,cur_score);
            right++;
        }
        return max_score;
    }
}