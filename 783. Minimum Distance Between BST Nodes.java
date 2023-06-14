//brute force : compare all pair and find diff -O(n^2)


class Solution {
    //in binary search tree , left sub tree has value less than root and right subtree value greater than root
    TreeNode prev=null;
    int res=Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        //as bst , so inorder traversal gives sorted array
        dfs(root);
        return res;
    }
    
    void dfs(TreeNode node){
        if(node==null)
        return;

        dfs(node.left);

        if(prev!=null)
        res=Math.min(res,Math.abs(node.val-prev.val));

        prev=node;//update previous node as only adjacent value gives minimum diff
        //as bst 
        dfs(node.right);
    }
}


another : inorder traversal

class Solution {
    
    TreeNode prev=null;
    int res=Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        // inorder traversal gives sorted array
        inorder(root);
        return res;
    }

    void inorder(TreeNode root){
        if(root==null)return;

        inorder(root.left);
        if(prev!=null)
        res=Math.min(res,Math.abs(root.val-prev.val));
        prev=root;
        inorder(root.right);
    }
}
