class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long max=0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    long cur=(nums[i] - nums[j]);
                    cur*= nums[k]*1l;
                    System.out.println(cur);
                    max=Math.max(max,cur);
                }
            }
        }
        return max;
        
    }
}
