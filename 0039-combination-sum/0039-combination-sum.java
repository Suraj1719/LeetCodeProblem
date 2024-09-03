class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        findCom(0,candidates,target,ans,new ArrayList<>());

        return ans;
    }
    void findCom(int index,int can[],int tar,List<List<Integer>> ans,List<Integer> cur)
    {
        if(index==can.length){
            if(tar==0){
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        if(can[index]<=tar){
            cur.add(can[index]);
            findCom(index,can,tar-can[index],ans,cur);
            cur.remove(cur.size()-1);
        }
        findCom(index+1,can,tar,ans,cur);
    }
}