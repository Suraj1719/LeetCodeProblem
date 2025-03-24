class Solution {
    public int countDays(int days, int[][] meetings) {
        //Brute force    time:O(days*len(meetings))   space:O(days)
        //create a present meeting array of size [days] and try to fill manually from starting meeting days to last 

        // int pre_meet[]=new int[days+1];
        // for(int i=0;i<meetings.length;i++){
        //     int temp[]=meetings[i];
        //     int s=temp[0];
        //     int e=temp[1];
        //     while(s<=e){
        //         pre_meet[s]++;
        //         s++;
        //     }
        // }
        // int ans=0;
        // for(int i=1;i<pre_meet.length;i++){
        //     if(pre_meet[i]==0)ans++;
        // }
        // return ans;



        //Approach - 2  (sorting + merging intervals)

        PriorityQueue<int[]>min_heap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<meetings.length;i++){
            min_heap.add(meetings[i]);
        }
        List<int[]>list_merge=new ArrayList<>();
        while(!min_heap.isEmpty()){
            int m[]=min_heap.poll();
            while(!min_heap.isEmpty() && min_heap.peek()[0]<=m[1]){
                m[0]=Math.min(m[0],min_heap.peek()[0]);
                m[1]=Math.max(m[1],min_heap.peek()[1]);
                min_heap.poll();
            }
            list_merge.add(new int[]{m[0],m[1]});
        }

        int no_meet_days=0;
        for(int i=0;i<list_merge.size();i++){
            System.out.println(list_merge.get(i)[0]+" "+list_merge.get(i)[1]);
            int temp=0;
            if(i==0){
                no_meet_days+=(list_merge.get(i)[0]-1);
                
            }else{
                temp=(list_merge.get(i)[0]-list_merge.get(i-1)[1]);
                no_meet_days+=(temp-1);
            }
        }
        no_meet_days+=(days-list_merge.get(list_merge.size()-1)[1]);
        return no_meet_days;
    }
}