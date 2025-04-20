package org.example.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesCode {
    static class Node {
        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildBinaryTree(int[] arr) {
            idx++;
            if (arr[idx] == -1) {
                return null;
            }

            Node newNode = new Node(arr[idx]);
            newNode.left = buildBinaryTree(arr);
            newNode.right = buildBinaryTree(arr);
            return newNode;
        }

        public static void preorder(Node root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null) return;
            inorder(root.left);

            System.out.print(root.data);
            inorder(root.right);

        }

        public static void postorder(Node root) {
            if (root == null) return;

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
            if (root == null) return;
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);

            while (!queue.isEmpty()) {
                Node curr = queue.remove();
                if (curr == null) {
                    System.out.println();
                    if (queue.isEmpty()) {
                        break;
                    } else {
                        queue.add(null);
                    }
                } else {
                    System.out.print(curr.data + " ");
                    if (curr.left != null) queue.add(curr.left);
                    if (curr.right != null) queue.add(curr.right);
                }
            }
        }

        public static int countOfNodes(Node root) {
            if (root == null) return 0;

            int leftNodes = countOfNodes(root.left);
            int rightNodes = countOfNodes(root.right);
            return leftNodes + rightNodes + 1;
        }


        public static int sumOfNodes(Node root) {
            if (root == null) return 0;

            int leftNodes = sumOfNodes(root.left);
            int rightNodes = sumOfNodes(root.right);
            return leftNodes + rightNodes + root.data;
        }

        public static int heightOfTree(Node root) {
            if(root == null) return 0;
            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        // Time Complexity: O(n^2)
        public static int diameter(Node root){
            if(root == null) return 0;
            int diam1 = diameter(root.left);
            int diam2 = diameter(root.right);
            int diam3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;

            return Math.max(diam3, Math.max(diam1, diam2));
        }

        static class TreeInfo{
            int height;
            int diam;

            public TreeInfo(int height, int diam) {
                this.height = height;
                this.diam = diam;
            }
        }
        public static TreeInfo diameter2(Node root) {
            if(root == null) {
                return new TreeInfo(0, 0);
            }


            TreeInfo leftTI = diameter2(root.left);
            TreeInfo rightTI = diameter2(root.right);

            int myHeight = Math.max(leftTI.height, rightTI.height) + 1;

            int diam1 = leftTI.height + rightTI.height + 1;
            int diam2 = leftTI.diam;
            int diam3 = rightTI.diam;
            int myDiam = Math.max(diam1, Math.max(diam2, diam3));
            return new TreeInfo(myHeight, myDiam);
        }
    }


    public static void main(String[] args) {
//        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//        Node root = BinaryTree.buildBinaryTree(nodes);
//        BinaryTree.preorder(root);
//        System.out.println("");
//        BinaryTree.inorder(root);
//        System.out.println("");
//        BinaryTree.postorder(root);
//        BinaryTree.levelOrder(root);
//        System.out.println(BinaryTree.countOfNodes(root));
//        System.out.println(BinaryTree.sumOfNodes(root));

 //       System.out.println(BinaryTree.heightOfTree(root));
//        System.out.println(BinaryTree.diameter(root));
//        System.out.println(BinaryTree.diameter2(root).diam);

        //System.out.println(root.data);
    }
}
