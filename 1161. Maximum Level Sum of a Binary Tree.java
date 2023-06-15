class Solution {
    Map<Integer,Long>level_sum=new HashMap<>();
    Long max_sum=(long)Integer.MIN_VALUE;
    int ans=-1;
    public int maxLevelSum(TreeNode root) {
        findLevelSum(root,1);
        for(Map.Entry<Integer,Long>en:level_sum.entrySet()){
            int level=en.getKey();
            long value=en.getValue();
            System.out.println(level+" "+value);
            if(value>max_sum){
                max_sum=value;
                ans=level;
            }
        }
        return ans;
    }

    void findLevelSum(TreeNode root,int l){
        if(root==null)return;
        level_sum.put(l,level_sum.getOrDefault(l,0l)+root.val);
        findLevelSum(root.left,l+1);
        findLevelSum(root.right,l+1);
    }
}
