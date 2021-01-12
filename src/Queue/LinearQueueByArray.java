package Queue;

public class LinearQueueByArray {
    private int[] queue;
    private int topOfQueue;
    private int beginningOfQueue;

    public LinearQueueByArray(int sizeOfQueue) {
        this.queue = new int[sizeOfQueue];
        topOfQueue = beginningOfQueue = -1;
    }

    private boolean isQueueFull() {
        return topOfQueue == queue.length - 1;
    }

    private boolean isQueueEmpty() {
        return topOfQueue == -1 || beginningOfQueue == queue.length;
    }

    public void enQueue(int value) {
        if (isQueueFull()) {
            System.out.println("Queue is already full!");
        } else if (isQueueEmpty()) {
            beginningOfQueue = 0;
            topOfQueue++;
            queue[topOfQueue] = value;
        } else {
            topOfQueue++;
            queue[topOfQueue] = value;
        }
    }

    public void deQueue() {
        if (isQueueEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println(queue[beginningOfQueue]);
            beginningOfQueue++;

            if (beginningOfQueue > topOfQueue) {  //If last element in the Queue is Dequeued
                topOfQueue = beginningOfQueue = -1;
            }
        }
    }

    public void peekOperation() {
        if (!isQueueEmpty()) {
            System.out.println(queue[beginningOfQueue]);
        } else {
            System.out.println("The queue is empty!!");
        }
    }

    public void deleteQueue() {
        queue = null;
        System.out.println("Queue is successfully deleted !");
    }


}
