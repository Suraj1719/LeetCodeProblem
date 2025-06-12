class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int len=wall.size();
        Map<Long,Integer>frq=new HashMap<>();
        for(int i=0;i<len;i++){
            List<Integer>cur=wall.get(i);
            long c_sum=0;
            // if(frq.containsKey(c_sum))frq.put(c_sum,frq.get(c_sum)+1);
            // else frq.put(c_sum,1);

            for(int j=0;j<cur.size();j++){
                c_sum+=cur.get(j);
                if(j==cur.size()-1)continue;
                if(frq.containsKey(c_sum))frq.put(c_sum,frq.get(c_sum)+1);
                else frq.put(c_sum,1);
            }
        }
        int ans=len;

        for(Map.Entry<Long,Integer>e:frq.entrySet()){
            int frequency=e.getValue();
            System.out.println(frequency);
            ans=Math.min(ans,len-frequency);
        }
        return ans;
    }
}