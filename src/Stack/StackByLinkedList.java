package Stack;

import Linkedlist.SingleLinkedList;
import Node.SingleNode;

public class StackByLinkedList {
    private SingleLinkedList stack;

    public StackByLinkedList() {
        stack = new SingleLinkedList();
    }

    private boolean isStackEmpty() {
        return stack.getHead() == null;
    }

    public void push(int value) {
        if (isStackEmpty()) {
            stack.createSingleLinkedList(value);
        } else {
            stack.insertInLinkedList(value, 0);
        }
    }

    public int pop() {
        if (isStackEmpty()) {
            System.out.println("Stack underflow error!!");
            return -1;
        } else {
            int value = stack.getHead().getValue();
            stack.deletionOfNode(0);
            return value;
        }
    }

    public int peek() {
        if (isStackEmpty()) {
            System.out.println("Stack underflow error!!");
            return -1;
        } else {
            return stack.getHead().getValue();
        }
    }

    public void deleteStack() {
        stack.setHead(null);
    }
}
