Brute force (using extra space) : - time :O(n)  space=O(n)
  class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : nums)
        {
            if(map.get(num) != 3)
                return num;
        }

        return 0;
    }
}


without using space : time:O(n)

  class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        int n=nums.length;
        for(int i=0;i<32;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(checkBit(nums[j],i)==true){
                    count++;
                }
            }
            if(count%3==1){
                ans=ans+(1<<i);
            }
        }
        return ans;
    }
    boolean checkBit(int n,int ind){
        if((n & (1<<ind))==0)
        return false;

        return true;
    }
}
