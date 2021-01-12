package Queue;

import Linkedlist.SingleLinkedList;

public class QueueByLinkedList {
    private SingleLinkedList queue;

    public QueueByLinkedList() {
        this.queue = new SingleLinkedList();
    }

    private boolean isQueueEmpty() {
        return queue.getHead() == null;
    }

    public void enQueue(int value) {
        if (isQueueEmpty()) {
            queue.createSingleLinkedList(value);
        } else {
            // push a value on last of queue, update list tail too
            queue.insertInLinkedList(value, queue.getSize());
        }
    }

    public int deQueue() {
        int value = -1;
        if (isQueueEmpty()) {
            System.out.println("Queue underflow error!!");
        } else {
            value = queue.getHead().getValue();
            queue.deletionOfNode(0);
        }
        return value;
    }

    public int peek() {
        if (!isQueueEmpty())
            return queue.getHead().getValue();
        else {
            System.out.println("The queue is empty!!");
            return -1;
        }
    }

    public void deleteQueue() {
        queue.setHead(null);
    }
}
