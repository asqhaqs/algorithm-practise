package fxcheck.fxtre;

/**
 * Create by xudong
 * Author: xudong
 * Date: 2020-06-10
 */
public class mirrowTree {

    public TreeNode mirrorTrees(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = mirrorTrees(right);
        root.right = mirrorTrees(left);
        return root;
    }

}
