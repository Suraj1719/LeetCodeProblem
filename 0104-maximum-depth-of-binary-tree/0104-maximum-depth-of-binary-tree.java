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
    public int maxDepth(TreeNode root) {
        //recursive approach
        if(root==null)return 0;

        // int left_height=maxDepth(root.left);
        // int right_height=maxDepth(root.right);

        // return 1+Math.max(left_height,right_height);


        //level order traversal
        Queue<TreeNode>que=new LinkedList<>();
        que.add(root);
        int height=0;
        while(!que.isEmpty()){
            int size=que.size();
            height++;
            for(int i=0;i<size;i++){
                TreeNode cur=que.poll();
                if(cur.left!=null)que.add(cur.left);
                if(cur.right!=null)que.add(cur.right);
            }
        }
        return height;
    }
}