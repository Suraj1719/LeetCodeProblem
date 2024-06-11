class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //Approach 1:Brute Force
        //time :O(n*m)  space:O(n)
        int len=arr1.length;
        int ans[]=new int[len];
        int ind=0;

        int vis[]=new int[len];
        for(int i=0;i<arr2.length;i++){
            int num=arr2[i];
            for(int j=0;j<len;j++){
                if(vis[j]==0){
                    if(arr1[j]==num){
                        ans[ind++]=num;
                        vis[j]=1;
                    }
                }
            }
        }
        List<Integer>sort=new ArrayList<>();
        for(int i=0;i<len;i++){
            if(vis[i]==0)sort.add(arr1[i]);
        }
        Collections.sort(sort);
        for(int x:sort){
            ans[ind++]=x;
        }
        return ans;
    }
}