class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n=nums.length;
        if(n%k!=0)return false;
        Map<Integer,Integer>min_heap=new TreeMap<>();
        for(int x:nums){
            min_heap.put(x,min_heap.getOrDefault(x,0)+1);
        }

        while(min_heap.size()>0){
            int cur=min_heap.entrySet().iterator().next().getKey();
            for(int i=0;i<k;i++){
                if (!min_heap.containsKey(cur + i)) return false;

                min_heap.put(cur + i,min_heap.get(cur + i) - 1);

                // Remove the card value if its occurrences are exhausted
                if (min_heap.get(cur + i) == 0)
                    min_heap.remove(cur + i);
            }
        }
    return true;
    }
}