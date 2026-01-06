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
    public int maxLevelSum(TreeNode root) {
        int ans=1;
        int max_lev_sum=root.val;
        Queue<TreeNode>par=new LinkedList<>();
        par.add(root);
        int cur_lev=0;
        while(!par.isEmpty()){
            cur_lev++;
            int size=par.size();
            int cur_lev_sum=0;
            Queue<TreeNode>child=new LinkedList<>();
            while(size>0){
                TreeNode node=par.peek();
                par.poll();
                cur_lev_sum+=node.val;
                size--;
                if(node.left!=null)child.add(node.left);
                if(node.right!=null)child.add(node.right);
            }
            if(cur_lev_sum>max_lev_sum){
                max_lev_sum=cur_lev_sum;
                ans=cur_lev;
            }
            par=child;
        }

        return ans;
    }
}