class Solution {
    int ans=Integer.MAX_VALUE;
    TreeNode prev=null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return ans;
    }
    void inorder(TreeNode root){
        if(root==null)return;

        inorder(root.left);
        if(prev!=null)
        ans=Math.min(ans,Math.abs(root.val-prev.val));
        prev=root;
        inorder(root.right);
    }
}
