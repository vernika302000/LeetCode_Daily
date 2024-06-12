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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> q = new ArrayDeque<>();
        boolean flag = true;
        q.offer(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            ArrayList<Integer> ds = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode node = q.peek(); 
                q.remove();
                ds.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            if(!flag ) Collections.reverse(ds);
            ans.add(ds);
            flag = !flag;
                
        }
       return ans; 
    }
}