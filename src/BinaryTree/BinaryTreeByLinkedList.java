package BinaryTree;

import Node.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeByLinkedList {
    private BinaryNode root;

    public BinaryTreeByLinkedList() {
        this.root = null;
    }

    private boolean isRootNull(BinaryNode root) {
        return root == null;
    }

    private void printRootValue(int value) {
        System.out.println(value + "->");
    }

    public void preOrderTraversal(BinaryNode root) {
        if (isRootNull(root)) {
            return;

        } else {
            printRootValue(root.getValue());
            preOrderTraversal(root.getLeft());
            preOrderTraversal(root.getRight());
        }
    }

    public void inOrderTraversal(BinaryNode root) {
        if (isRootNull(root)) return;
        inOrderTraversal(root.getLeft());
        printRootValue(root.getValue());
        inOrderTraversal(root.getRight());
    }

    public void postOrderTraversal(BinaryNode root) {
        if (isRootNull(root)) return;
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        printRootValue(root.getValue());
    }

    public void levelOrderTraversal() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.getValue() + " ");
            if (presentNode.getLeft() != null) {
                queue.add(presentNode.getLeft());
            }
            if (presentNode.getRight() != null)
                queue.add(presentNode.getRight());
        }
    }

    public void search(int value) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.getValue() == value) {
                System.out.println("Value-" + value + " is found in Tree !");
                return;
            } else {
                if (presentNode.getLeft() != null)
                    queue.add(presentNode.getLeft());
                if (presentNode.getRight() != null)
                    queue.add(presentNode.getRight());
            }
        }
        System.out.println("Value-" + value + " is not found in Tree !");
    }

    public void insert(int value) {
        BinaryNode node = new BinaryNode();
        node.setValue(value);

        if (root == null) {
            root = node;
            System.out.println("Successfully inserted new node at Root !");
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.getLeft() == null) {
                presentNode.setLeft(node);
                System.out.println("Successfully inserted new node !");
                return;
            } else if (presentNode.getRight() == null) {
                presentNode.setRight(node);
                System.out.println("Successfully inserted new node !");
                return;
            } else {
                queue.add(presentNode.getLeft());
                queue.add(presentNode.getRight());
            }
        }
    }

    public BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode presentNode = null;
        while (!queue.isEmpty()) {
            presentNode = queue.remove();
            if (presentNode.getLeft() != null)
                queue.add(presentNode.getLeft());
            if (presentNode.getRight() != null)
                queue.add(presentNode.getRight());
        }
        return presentNode;
    }

    public void deleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode previousNode, presentNode = null;
        while (!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();
            if (presentNode.getLeft() == null) {
                previousNode.setRight(null);
                return;
            } else if ((presentNode.getRight() == null)) {
                presentNode.setLeft(null);
                return;
            }
            queue.add(presentNode.getLeft());
            queue.add(presentNode.getRight());
        }
    }

    public void deleteNodeOfBinaryTree(int value) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.getValue() == value) {
                presentNode.setValue(getDeepestNode().getValue());
                deleteDeepestNode();
                System.out.println("Deleted the node !!");
                return;
            } else {
                if (presentNode.getLeft() != null)
                    queue.add(presentNode.getLeft());
                if (presentNode.getRight() != null)
                    queue.add(presentNode.getRight());
            }
        }
        System.out.println("Did not find the node!!");
    }

    public void deleteTree() {
        root = null;
        System.out.println("Binary Tree has been deleted successfully");
    }
}
