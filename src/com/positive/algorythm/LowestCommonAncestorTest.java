package com.positive.algorythm;

import org.junit.Assert;
import org.junit.Test;

import static com.positive.algorythm.LowestCommonAncestor.Node;
import static com.positive.algorythm.LowestCommonAncestor.findLca;

public class LowestCommonAncestorTest {

    @Test
    public void testRegularCase() {
        Node root = new Node(0, new Node(11), new Node(12));
        Node lca = findLca(root, 11, 12);
        Assert.assertEquals(0, lca.val);
    }


    @Test
    public void testComplicatedCase() {
        Node root = new Node(0, new Node(11), new Node(12));
        root.left.left =  new Node(21);
        root.left.right =  new Node(22);
        root.left.left.left = new Node(31);
        root.right.right = new Node(23);

        Node lca = findLca(root, 31, 23);
        Assert.assertEquals(0, lca.val);
    }

    @Test
    public void testSearchNodesSame() {
        Node root = new Node(0, new Node(11), new Node(12));
        root.left.left =  new Node(21);
        root.left.right =  new Node(22);
        root.left.left.left = new Node(31);
        root.right.right = new Node(23);

        Node lca = findLca(root, 31, 31);
        Assert.assertEquals(31, lca.val);
    }

    @Test
    public void testSearchNodesIsLca() {
        Node root = new Node(0, new Node(11), new Node(12));
        root.left.left =  new Node(21);
        root.left.right =  new Node(22);
        root.left.left.left = new Node(31);
        root.right.right = new Node(23);

        Node lca = findLca(root, 31, 21);
        Assert.assertEquals(21, lca.val);
    }

    @Test
    public void testSearchNodesSameWithRoot() {
        Node root = new Node(0, new Node(11), new Node(12));

        Node lca = findLca(root, 0, 0);
        Assert.assertEquals(0, lca.val);
    }
}
