class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int n=basket1.length;
        Map<Integer,Integer>ele_frq=new HashMap<>();
        int min_ele=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min_ele=Math.min(min_ele,basket1[i]);
            min_ele=Math.min(min_ele,basket2[i]);
            if(ele_frq.containsKey(basket1[i])){
                ele_frq.put(basket1[i],ele_frq.get(basket1[i])+1);
            }else{
                ele_frq.put(basket1[i],1);
            }

            if(ele_frq.containsKey(basket2[i])){
                ele_frq.put(basket2[i],ele_frq.get(basket2[i])-1);
                //if(ele_frq.get(basket2[i])==0)ele_frq.remove(basket2[i]);
            }else{
                ele_frq.put(basket2[i],-1);
            }
        }
        
        List<Integer>unsort_val=new ArrayList<>();
        for(Map.Entry<Integer,Integer>e:ele_frq.entrySet()){
            int val=Math.abs(e.getValue());
            int key=e.getKey();
            //System.out.println(key+" "+val);
            if(val==0)continue;
            if(val%2==1)return -1*1l;

            for(int i=1;i<=(val/2);i++){
                unsort_val.add(key);
            }
        }

        //here we cn not just directly swap, we have to swap using minimum element
        Collections.sort(unsort_val);
        long ans=0;
        int size=unsort_val.size();
        int ind=0;
        while(ind<(size/2)){
            ans+=Math.min(unsort_val.get(ind),2*min_ele);//via minimum element
            
            ind++;
        }
        return ans;
    }
}