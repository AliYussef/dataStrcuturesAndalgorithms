package Linkedlist;

import Node.SingleNode;

public class SingleLinkedList {
    private SingleNode head;
    private SingleNode tail;
    private int size;

    public SingleNode createSingleLinkedList(int nodeValue) {
        head = new SingleNode();
        SingleNode node = new SingleNode();
        node.setValue(nodeValue);
        node.setNext(null);
        head = node;
        tail = node;
        size = 1;

        return head;
    }

    public SingleNode getHead() {
        return head;
    }

    public void setHead(SingleNode head) {
        this.head = head;
    }

    public SingleNode getTail() {
        return tail;
    }

    public void setTail(SingleNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void insertInLinkedList(int nodeValue, int location) {
        SingleNode node = new SingleNode();
        node.setValue(nodeValue);

        if (!existsLinkedList()) {
            System.out.println("The linked list does not exist!!");
            return;
        } else if (location == 0) {
            node.setNext(head);
            head = node;
        } else if (location >= size) {
            node.setNext(null);
            tail.setNext(node); // tail and last node they have same reference location in memory (same object)
            tail = node;
        } else {
            int index = 0;
            SingleNode tempNode = head;
            while (index < location - 1) {
                tempNode = tempNode.getNext();
                index++;
            }
            //tempNode currently references to node after which we should insert new node
            SingleNode nextNode = tempNode.getNext();  //this is the immediate next node after new node
            tempNode.setNext(node); //update reference of tempNode to reference to new node
            node.setNext(nextNode); //update newly added nodes' next.
        }
        size++;
    }

    public boolean existsLinkedList() {
        return head != null;
    }

    public void traverse() {
        if (!existsLinkedList()) {
            System.out.println("The linked list does not exist!!");
            return;
        } else {
            SingleNode tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.getValue());
                if (i != getSize() - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.getNext();
            }
        }
    }

    //Searches a node with given value
    public boolean searchNode(int nodeValue) {
        if (existsLinkedList()) {
            SingleNode tempNode = head;
            for (int i = 0; i < getSize(); i++) {
                if (tempNode.getValue() == nodeValue) {
                    System.out.print("Found the node at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.getNext();
            }
        }
        System.out.print("Node not found!! \n");
        return false;
    }

    public void deletionOfNode(int location) {
        if (!existsLinkedList()) {
            System.out.println("The linked list does not exist!!");// Linked List does not exists
            return;
        } else if (location == 0) { // we want to delete first element
            head = head.getNext();
            setSize(getSize() - 1);
            if (getSize() == 0) { // if there are no more nodes in this list
                tail = null;
            }
        } else if (location >= getSize()) { //If location is not in range or equal, then delete last node
            SingleNode tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.getNext(); //temp node points to 2nd last node
            }
            if (tempNode == head) { //if this is the only element in the list
                tail = head = null;
                setSize(getSize() - 1);
                return;
            }
            tempNode.setNext(null);
            tail = tempNode;
            setSize(getSize() - 1);

        } else { //if any inside node is to be deleted
            SingleNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.getNext(); // we need to traverse till we find the location
            }
            tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
            setSize(getSize() - 1);
        }
    }


}
