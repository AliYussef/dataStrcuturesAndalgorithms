package Linkedlist;

import Node.DoubleNode;

public class DoubleLinkedList {
    private DoubleNode head;
    private DoubleNode tail;
    private int size = 0;

    public DoubleNode getHead() {
        return head;
    }

    public void setHead(DoubleNode head) {
        this.head = head;
    }

    public DoubleNode getTail() {
        return tail;
    }

    public void setTail(DoubleNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public DoubleNode createDoubleLinkedList(int value) {
        DoubleNode newNode = new DoubleNode();
        newNode.setValue(value);
        newNode.setPrev(null);
        newNode.setNext(null);
        head = newNode;
        tail = newNode;
        size++;

        return head;
    }

    public boolean existsLinkedList() {
        return head != null;
    }

    public void insertInLinkedList(int nodeValue, int location) {
        DoubleNode node = new DoubleNode();
        node.setValue(nodeValue);

        if (!existsLinkedList()) {
            System.out.println("The linked list does not exist!!");
            return;
        } else if (location == 0) {
            node.setPrev(null);
            node.setNext(head);
            head.setPrev(node);
            head = node;
        } else if (location >= size) {
            tail.setNext(node);
            node.setNext(null);
            node.setPrev(tail);
            tail = node;
        } else {
            int index = 0;
            DoubleNode tempNode = head;
            while (index < location - 1) {
                tempNode = tempNode.getNext();
                index++;
            }
            node.setPrev(tempNode);
            node.setNext(tempNode.getNext());
            tempNode.setNext(node);
            node.getNext().setPrev(node);
        }
        size++;
    }

    public void traverseLinkedList() {
        if(existsLinkedList()) {
            //System.out.println("Linked List now: ");
            DoubleNode tempNode=head;
            for(int i =0; i<size;i++) {

                System.out.print(tempNode.getValue());
                if(i!=size-1) {
                    System.out.print(" -> ");
                }
                tempNode=tempNode.getNext();
            }
        }else {
            System.out.println("Linked List does not exists");
        }
        System.out.println("\n");
    }

    public void traverseLinkedListInReverseOrder() {
        if (existsLinkedList()) {
            DoubleNode tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.getValue());
                if (i != size-1) {
                    System.out.print(" <- ");
                }
                tempNode = tempNode.getPrev();
            }
        } else {
            System.out.println("Linked List does not exists");
        }
        System.out.println("\n");
    }

    //delete whole linked list
    public void deleteLinkedList() {
        System.out.println("\n\nDeleting Linked List...");
        DoubleNode tempNode = head;
        for (int i = 0; i < size; i++) {
            tempNode.setPrev(null);
            tempNode = tempNode.getNext();
        }

        head = null;
        tail = null;
        System.out.println("Linked List deleted successfully !");
    }

    //Search for a node in linked list
    public boolean searchNode(int nodeValue) {
        if(existsLinkedList()) {
            DoubleNode tempNode=head;
            for(int i =0; i<size;i++) {
                if(tempNode.getValue()==nodeValue) {
                    System.out.print("Found the node at locaiton: " + i);
                    return true;
                }
                tempNode=tempNode.getNext();
            }
        }
        System.out.print("Node not found!! ");
        return false;
    }

    // Deletes a node having a given location
    public void deletionOfNode(int location) {
        if (!existsLinkedList()) {
            System.out.println("The linked list does not exist!!");// Linked List does not exists
            return;
        } else if (location == 0) { // we want to delete first element
            if (getSize() == 1) { // if this is the only node in this list
                head = tail = null;
                setSize(getSize() - 1);
                return;
            }else {
                head = head.getNext();
                head.setPrev(null);
                setSize(getSize() - 1);
            }
        } else if (location >= getSize()) { // If location is not in range or equal, then delete last node
            DoubleNode tempNode = tail.getPrev(); // temp node points to 2nd last node
            if (tempNode == head) { // if this is the only element in the list
                tail = head = null;
                setSize(getSize() - 1);
                return;
            }
            tempNode.setNext(null);
            tail = tempNode;
            setSize(getSize() - 1);

        } else { // if any inside node is to be deleted
            DoubleNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.getNext(); // we need to traverse till we find the location
            }
            tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
            tempNode.getNext().setPrev(tempNode);
            setSize(getSize() - 1);
        }
    }

}
