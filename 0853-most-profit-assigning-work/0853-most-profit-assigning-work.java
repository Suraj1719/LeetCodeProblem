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
        // PriorityQueue<int[]>max_heap=new PriorityQueue<>((a,b)->b[0]-a[0]);
        // for(int i=0;i<n;i++){
        //     max_heap.add(new int[]{profit[i],difficulty[i]});
        // }
        // Arrays.sort(worker);
        // int ind=m-1;
        // while(ind>=0 && !max_heap.isEmpty()){
        //     int work=worker[ind];
        //     int cur[]=max_heap.peek();
        //     if(work<cur[1]){
        //         max_heap.poll();
        //     }else{
        //         ans+=cur[0];
        //         ind--;
        //     }
        // }

        //Approach - 3 (Sorting + Binary Search)
        List<int[]>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new int[]{difficulty[i],profit[i]});
        }
        //sort according to difficulty in Ascending order
        Collections.sort(list, new Comparator<int[]>() {    
        @Override
        public int compare(int[]o1, int[] o2) {
            return o1[0]-o2[0];
        }               
});
        int max_profit[]=new int[n];
        max_profit[0]=list.get(0)[1];
        for(int i=1;i<n;i++){
            max_profit[i]=Math.max(max_profit[i-1],list.get(i)[1]);
        }
        for(int i=0;i<m;i++){
            int index=BS(list,worker[i]);
            if(index!=-1)
            ans+=max_profit[index];
        }

        return ans;
    }
    int BS(List<int[]>ls,int work){
        int l=0;
        int r=ls.size()-1;
        int res=-1;
        while(l<=r){
            int mid=(l+r)/2;
            int cur[]=ls.get(mid);
            if(cur[0]>work){
                r=mid-1;
            }else{
                res=mid;
                l=mid+1;
            }
        }
        return res;
    }
}