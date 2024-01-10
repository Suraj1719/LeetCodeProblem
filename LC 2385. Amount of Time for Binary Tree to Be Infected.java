

//Use simple BFS traversal. So first make Adjacency list.
//LC: https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected
//YT Sol. : https://www.youtube.com/watch?v=JIlQvhrKuAk


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
    Map<Integer,List<Integer>>map;
    public int amountOfTime(TreeNode root, int start) {
        map=new HashMap<>();
        makeAdjList(root);
        Set<Integer>vis=new HashSet<>();
        vis.add(start);
        //BFS Traversal
        Queue<Integer>q=new LinkedList<>();
        q.add(start);
        int total_time=0;
        while(!q.isEmpty()){
            total_time++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int cur=q.poll();
                List<Integer> list=map.getOrDefault(cur,new ArrayList<>());
                for(int j=0;j<list.size();j++){
                    if(vis.contains(list.get(j)))
                        continue;
                    vis.add(list.get(j));
                    q.add(list.get(j));                   
                }
            }

        }
        return total_time-1;
        
    }

    void makeAdjList(TreeNode root){
        if(root==null)return;

        if(root.left!=null){
           List<Integer> list=map.getOrDefault(root.val,new ArrayList<>());
           list.add(root.left.val);
           map.put(root.val,list);
            
           list=map.getOrDefault(root.left.val,new ArrayList<>());
            list.add(root.val);
            map.put(root.left.val,list);
        }
        if(root.right!=null){
            List<Integer> list=map.getOrDefault(root.val,new ArrayList<>());
           list.add(root.right.val);
           map.put(root.val,list);
            
           list=map.getOrDefault(root.right.val,new ArrayList<>());
            list.add(root.val);
            map.put(root.right.val,list);
        }
        makeAdjList(root.left);
        makeAdjList(root.right);
    }
}
