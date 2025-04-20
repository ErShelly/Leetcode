package org.example.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class IsValidBST {

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(8);

        IsValidBST isValidBST = new IsValidBST();
        System.out.println("DFS: "+ isValidBST.isValidDFS(treeNode));
        System.out.println("BFS: "+ isValidBST.isValidBFS(treeNode));
    }

    public boolean isValidDFS(TreeNode treeNode){
       return isValid(treeNode, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    //DFS
    // Time Complexity: O(n)
    //Space Complexity: O(n)

    public boolean isValid(TreeNode treeNode, long left, long right){
        if(treeNode == null) return true;

        if(!(treeNode.val > left && treeNode.val < right)) return false;

        return isValid(treeNode.left, left, treeNode.val) && isValid(treeNode.right, treeNode.val, right);
    }

    //BFS
    // Time Complexity: O(n)
    //Space Complexity: O(n)

    public boolean isValidBFS(TreeNode treeNode){
        if(treeNode == null) return true;

        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{treeNode, Long.MIN_VALUE, Long.MAX_VALUE});

        while(!queue.isEmpty()){
            Object[] obj = queue.poll();
            TreeNode node = (TreeNode) obj[0];
            long left = (long) obj[1];
            long right = (long) obj[2];

            if(!(left < node.val && right > node.val)) return false;

            if(node.left != null) queue.offer(new Object[]{node.left, left, (long) node.val});
            if(node.right != null) queue.offer(new Object[]{node.right, (long) node.val, right});
        }

        return true;
    }
}
