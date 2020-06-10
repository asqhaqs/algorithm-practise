package fxcheck.fxtre;

/**
 * Create by xudong
 * Author: xudong
 * Date: 2020-06-10
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class IsrightBST {

    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return helper(root, max, min);


    }

    public boolean helper(TreeNode root, long max, long min){
        if(root==null) return true;
        if(root.val <= min || root.val >= max) return false;
        if(! helper(root.left, root.val, min)) return false;
        if(! helper(root.right, max, root.val)) return false;

        return true;

    }

    public static void main(String[] args) {
        IsrightBST is = new IsrightBST();
        TreeNode treeNode = new TreeNode(2147483647);
        if(is.isValidBST(treeNode)){
            System.out.println("yes");
        }
    }
}
