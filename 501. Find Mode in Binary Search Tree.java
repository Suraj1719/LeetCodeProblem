/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] findMode(TreeNode root) {

        Map<Integer,Integer>val_frq=new HashMap<>();

        traversal(root,val_frq);

        int max_frq=0;
        for(Map.Entry<Integer,Integer>en:val_frq.entrySet()){
            if(max_frq<en.getValue()){
                max_frq=en.getValue();
            }
        }

        List<Integer>num=new ArrayList<>();
        for(Map.Entry<Integer,Integer>en:val_frq.entrySet()){
            if(max_frq==en.getValue()){
                num.add(en.getKey());
            }
        }
        
        int ans[]=new int[num.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=num.get(i);
        }
        return ans;
    }
    void traversal(TreeNode root,Map<Integer,Integer>val_frq){
        if(root==null)return;
        if(val_frq.containsKey(root.val))
        val_frq.put(root.val,val_frq.get(root.val)+1);
        else
        val_frq.put(root.val,1);

        traversal(root.left,val_frq);
        traversal(root.right,val_frq);
    }
}
