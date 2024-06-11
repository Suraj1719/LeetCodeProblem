class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //Approach 1:Brute Force
        //time :O(n*m)  space:O(n)

        int len=arr1.length;
        int ans[]=new int[len];
        int ind=0;

        // int vis[]=new int[len];
        // for(int i=0;i<arr2.length;i++){
        //     int num=arr2[i];
        //     for(int j=0;j<len;j++){
        //         if(vis[j]==0){
        //             if(arr1[j]==num){
        //                 ans[ind++]=num;
        //                 vis[j]=1;
        //             }
        //         }
        //     }
        // }
        // List<Integer>sort=new ArrayList<>();
        // for(int i=0;i<len;i++){
        //     if(vis[i]==0)sort.add(arr1[i]);
        // }
        // Collections.sort(sort);
        // for(int x:sort){
        //     ans[ind++]=x;
        // }


        // Approach 2: Using Map
        Map<Integer,Integer>num_frq=new TreeMap<>();
        for(int i=0;i<len;i++){
            num_frq.put(arr1[i],num_frq.getOrDefault(arr1[i],0)+1);
        }

        for(int i=0;i<arr2.length;i++){
            int size=num_frq.get(arr2[i]);
            while(size-->0){
                ans[ind++]=arr2[i];
            }
            num_frq.remove(arr2[i]);
        }

        for(int key:num_frq.keySet()){
            int size=num_frq.get(key);
            while(size-->0){
                ans[ind++]=key;
            }
            
        }

        return ans;
    }
}