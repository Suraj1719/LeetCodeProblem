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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode>cur_level=new LinkedList<>();
        Queue<TreeNode>next_level=new LinkedList<>();
        cur_level.add(root);
        List<Long>level_sum=new ArrayList<>();
        while(!cur_level.isEmpty()){
            int size=cur_level.size();
            long sum=0;
            for(int i=0;i<size;i++){
                TreeNode par=cur_level.poll();
                sum+=par.val;
                if(par.left!=null)next_level.add(par.left);
                if(par.right!=null)next_level.add(par.right);
            }
            level_sum.add(sum);
            cur_level=next_level;
        }

        Collections.sort(level_sum);
        if(level_sum.size()-k<0)return -1;
        return level_sum.get(level_sum.size()-k);
    }
}