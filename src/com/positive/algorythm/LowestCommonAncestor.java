package com.positive.algorythm;

class LowestCommonAncestor {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static Node findLca(Node root, int firstVal, int secondVal) {
        if (root == null) {
            return null;
        }

        if (root.val == firstVal || root.val == secondVal) {
            return root;
        }

        Node leftLca = findLca(root.left, firstVal, secondVal);
        Node rightLca = findLca(root.right, firstVal, secondVal);

        if (leftLca != null && rightLca != null) {
            return root;
        }
        return leftLca != null ? leftLca : rightLca;
    }

    static Node findLca(Node root, Node first, Node second) {
        return findLca(root, first.val, second.val);
    }
}
