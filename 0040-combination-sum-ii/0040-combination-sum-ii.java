class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,candidates,target,ans,new ArrayList<>());

        return ans;
    }
    void findCombinations(int ind,int[] candidates, int target,
                         List<List<Integer>> ans,List<Integer> cur){
        if(target==0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i=ind;i<candidates.length;i++){
            if(i>ind && candidates[i]==candidates[i-1])//skiping the duplicates
            continue;

            if(candidates[i]>target)//as array is sorted
            break;
            cur.add(candidates[i]);
            findCombinations(i+1,candidates,target-candidates[i],ans,cur);
            cur.remove(cur.size()-1);//backtrack
        }
    }
}