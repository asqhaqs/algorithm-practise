package fxcheck.fxtre;

/**
 * Create by xudong
 * Author: xudong
 * Date: 2020-06-10
 */
public class BalanceTwoTree {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    public int height(TreeNode root){
         if(root == null) return 0;
         return 1 + Math.max(height(root.left), height(root.right));

    }
    public boolean isBalanced(TreeNode root) {
         if(root == null) return true;
         if(Math.abs(height(root.left) - height(root.right)) > 1){
             return false;
         }
         return isBalanced(root.left)&&isBalanced(root.right);
    }
}
