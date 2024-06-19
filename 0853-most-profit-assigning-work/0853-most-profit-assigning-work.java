class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //Approach - 1(BruteForce) time:O(n*m)
        int n=difficulty.length;
        int m=worker.length;
        int ans=0;
        // for(int i=0;i<m;i++){
        //     int cur_max_pro=0;
        //     for(int j=0;j<n;j++){
        //         if(difficulty[j]<=worker[i]){
        //             cur_max_pro=Math.max(cur_max_pro,profit[j]);
        //         }
        //     }
        //     ans+=cur_max_pro;
        // }

        //Approach -2 Maximum Heap and sorting : time= O(log(n))+O(max(n,m))  space:O(n)
        PriorityQueue<int[]>max_heap=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<n;i++){
            max_heap.add(new int[]{profit[i],difficulty[i]});
        }
        Arrays.sort(worker);
        int ind=m-1;
        while(ind>=0 && !max_heap.isEmpty()){
            int work=worker[ind];
            int cur[]=max_heap.peek();
            if(work<cur[1]){
                max_heap.poll();
            }else{
                ans+=cur[0];
                ind--;
            }
        }

        return ans;
    }
}