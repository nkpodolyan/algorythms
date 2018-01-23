package com.positive.datastructures.tst

/**
 * Created by mykola on 16.05.15.
 */
class TSTSet<T> {

    private var root: Node<T>? = null

    private class Node<T> internal constructor(internal val c: Char) {
        internal var value: T? = null
        internal var left: Node<T>? = null
        internal var next: Node<T>? = null
        internal var right: Node<T>? = null

        internal val isLeaf: Boolean
            get() = left == null && right == null && next == null
    }

    fun put(key: String, value: T) {
        if (root == null) {
            root = Node(key[0])
        }
        var current: Node<T>? = null
        for (i in 0..key.length - 1) {
            if (current == null)
                current = root
            else {
                if (current.next == null) current.next = Node(key[i])
                current = current.next
            }
            val c = key[i]
            while (c != current!!.c) {
                var child: Node<T>? = if (current.c > c) current.left else current.right
                if (child == null) {
                    child = Node(c)
                    if (current.c > c)
                        current.left = child
                    else
                        current.right = child
                }
                current = child
            }
        }
        current!!.value = value
    }

    operator fun get(key: String): T? {
        if (root == null) {
            return null
        }
        var current: Node<T>? = null
        for (i in 0..key.length - 1) {
            if (current == null)
                current = root
            else
                current = current.next
            if (current == null) return null
            val c = key[i]
            while (c != current!!.c) {
                current = if (current.c > c) current.left else current.right
                if (current == null) return null
            }
        }
        return current!!.value
    }

    fun remove(key: String) {
        var parent = root
        var cIndex = 0
        var current: Node<T>? = null
        for (i in 0..key.length - 1) {
            if (current == null)
                current = root
            else
                current = current.next
            if (current == null) return

            if (current.value != null || current.right != null || current.left != null) {
                parent = current
                cIndex = i
            }
            val c = key[i]
            while (c != current!!.c) {
                parent = current
                cIndex = i
                current = if (current.c > c) current.left else current.right
                if (current == null) return
            }
        }
        if (current!!.isLeaf) {
            if (parent != null) {
                val c = key[cIndex]
                if (parent.next!!.c == c)
                    parent.next = null
                else if (parent.c > c)
                    parent.left = null
                else
                    parent.right = null
            }
        } else {
            current.value = null
        }

    }

}
