package org.example.binaryTree;

import apple.laf.JRSUIUtils;

import java.util.*;

public class ZigZag {
    public static void main(String[] args){

    }

    //Time and Space complexity: O(n)
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>(size);

            for(int i=0; i<size; i++){
                TreeNode node = q.poll();

                level.add(node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            if(!leftToRight){
                Collections.reverse(level);
            }
            res.add(level);
            leftToRight = !leftToRight;
        }
        return  res;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
