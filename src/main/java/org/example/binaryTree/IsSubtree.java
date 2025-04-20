package org.example.binaryTree;

public class IsSubtree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println(isSubtree(root, subRoot));
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isIdentical(TreeNode root, TreeNode subtree){
        if(root == null && subtree == null) return true;
        if(root == null || subtree == null) return false;

        if(root.val == subtree.val){
            return isIdentical(root.left, subtree.left) && isIdentical(root.right, subtree.right);
        }
        return false;
    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot){
        if(subRoot == null) return true;
        if(root == null) return false;

        if(root.val == subRoot.val){
            if(isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
