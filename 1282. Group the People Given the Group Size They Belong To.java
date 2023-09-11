class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        //time :O(n^2)  space:O(n)

        int n=groupSizes.length;

        List<List<Integer>>group_size_index=new ArrayList<>();
        for(int i=0;i<=n;i++){
            group_size_index.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){//store index acc. their group size
            int group_size=groupSizes[i];
            group_size_index.get(group_size).add(i);
        }

        List<List<Integer>>ans=new ArrayList<>();
        
        for(int i=1;i<=n;i++){//O(n)
            if(group_size_index.get(i).size()==0)
            continue;

            int size=0;
            List<Integer>cur=new ArrayList<>();
            for(int x:group_size_index.get(i)){//O(n)
                size++;
                cur.add(x);
                if(size%i==0){
                    ans.add(new ArrayList<>(cur));
                    cur=new ArrayList<>();
                }
            }
        }
    return ans;

    }
}
