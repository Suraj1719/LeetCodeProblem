class Solution {
    public int findKthLargest(int[] nums, int k) {
        //using heap : min heap  or max heap
        int n=nums.length;
        Queue<Integer>minheap=new PriorityQueue<>();
        for(int x:nums){
            minheap.add(x);

        }

        int ind=0;
        while(ind<n-k){
            minheap.poll();
            ind++;
        }
        return minheap.peek();
    }
}