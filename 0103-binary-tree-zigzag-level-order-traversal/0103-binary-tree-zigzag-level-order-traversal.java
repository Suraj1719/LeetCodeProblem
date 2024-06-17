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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode>q=new LinkedList<>();
        boolean leftRight=true;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer>temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur=q.peek();
                q.poll();
                if(cur.left!=null)q.add(cur.left);
                if(cur.right!=null)q.add(cur.right);
                if(leftRight==true){
                    temp.add(cur.val);
                }else{
                    temp.add(0,cur.val);//adding first position
                }
            }
            ans.add(temp);
            if(leftRight==true)
            leftRight=false;
            else leftRight=true;
        }
    return ans;
    }
}