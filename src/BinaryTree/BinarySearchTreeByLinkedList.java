package BinaryTree;

import Node.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeByLinkedList {
    private BinaryNode root;

    public BinaryNode getRoot() {
        return root;
    }

    public void setRoot(BinaryNode root) {
        this.root = root;
    }

    public BinarySearchTreeByLinkedList() {
        root = null;
    }

    public BinaryNode searchForValue(int value) {
        return searchForValue(root, value);
    }

    private BinaryNode searchForValue(BinaryNode node, int value) {
        if (node == null) {
            return null;
        } else if (value == node.getValue()) {
            return node;
        } else if (value < node.getValue()) {
            return searchForValue(node.getLeft(), value);
        } else {
            return searchForValue(node.getRight(), value);
        }
    }

    public void levelOrderTraversal() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);

        if (root == null) {
            System.out.println("Tree does not exists !");
            return;
        }

        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.println(presentNode.getValue() + "->");
            if (presentNode.getLeft() != null)
                queue.add(presentNode.getLeft());
            if (presentNode.getRight() != null)
                queue.add(presentNode.getRight());
        }
    }

    public void deleteTree() {
        System.out.println("Deleting entire Tree...");
        root = null;
        System.out.println("Tree deleted successfully !");
    }

    public BinaryNode createNewNode(int value) {
        BinaryNode node = new BinaryNode();
        node.setValue(value);
        return node;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private BinaryNode insert(BinaryNode currentNode, int value) {
        if (currentNode == null) {
            return createNewNode(value);
        } else if (value <= currentNode.getValue()) {
            currentNode.setLeft(insert(currentNode.getLeft(), value));
            return currentNode;
        } else {
            currentNode.setRight(insert(currentNode.getRight(), value));
            return currentNode;
        }
    }

    public void deleteNodeOfBST(int value) {
        System.out.println("\n\nDeleting " + value + " from BST...");
        deleteNodeOfBST(root, value);
    }

    private BinaryNode getMinimumTreeElement(BinaryNode root) {
        if (root.getLeft() == null) {
            return root;
        } else {
            return getMinimumTreeElement(root.getLeft());
        }
    }

    private BinaryNode deleteNodeOfBST(BinaryNode root, int value) {
        if (root == null) {
            return null;
        } else if (value < root.getValue()) {
            root.setLeft(deleteNodeOfBST(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(deleteNodeOfBST(root.getRight(), value));
        } else { // If currentNode is the node to be deleted

            if (root.getLeft() != null && root.getRight() != null) {  // if nodeToBeDeleted have both children

                BinaryNode temp = root;
                BinaryNode minNodeForRight = getMinimumTreeElement(temp.getRight());// Finding minimum element from right subtree
                root.setValue(minNodeForRight.getValue()); // Replacing current node with minimum node from right subtree
                root.setRight(deleteNodeOfBST(root.getRight(), minNodeForRight.getValue()));  // Deleting minimum node from right now

            } else if (root.getLeft() != null) { // if nodeToBeDeleted has only left child
                root = root.getLeft(); // replace it with its left child

            } else if (root.getRight() != null) { // if nodeToBeDeleted has only right child
                root = root.getRight();  // replace it with its right child

            } else { // if nodeToBeDeleted do not have child (Leaf node)
                root = null;
            }
        }
        return root;
    }

    public void printTreeGraphically() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        Queue<Integer> level = new LinkedList<Integer>();

        int CurrentLevel = 1;
        boolean previousLevelWasAllNull = false;
        queue.add(root);
        level.add(1);

        System.out.println("\nPrinting Level order traversal of Tree...");
        if (root == null) {
            System.out.println("Tree does not exists !");
            return;
        }

        while (!queue.isEmpty()) {
            if (CurrentLevel == level.peek()) { //if we are in the same level
                if (queue.peek() == null) {
                    queue.add(null);
                    level.add(CurrentLevel + 1);
                } else {
                    queue.add(queue.peek().getLeft());
                    level.add(CurrentLevel + 1);
                    queue.add(queue.peek().getRight());
                    level.add(CurrentLevel + 1);
                    previousLevelWasAllNull = false;
                }
                System.out.print(queue.remove() + "  ");
                level.remove();
            } else { //level has changed
                System.out.println("\n");
                CurrentLevel++;
                if (previousLevelWasAllNull == true) {
                    break;
                }
                previousLevelWasAllNull = true;
            }
        }
    }

}
