package Queue;

public class CircularQueueByArray {
    private int[] queue;
    private int topOfQueue;
    private int beginningOfQueue;

    public CircularQueueByArray(int size) {
        queue = new int[size];
        topOfQueue = beginningOfQueue = -1;
    }

    private boolean isQueueFull() {
        if (topOfQueue + 1 == beginningOfQueue) { //If we have completed a circle, then we can say that Queue is full
            return true;
        } else if ((beginningOfQueue == 0) && (topOfQueue + 1 == beginningOfQueue)) { //Trivial case of Queue being full
            return true;
        } else {
            return false;
        }
    }

    private boolean isQueueEmpty() {
        return topOfQueue == -1;
    }

    private void initializeStartOfArray() {
        if (beginningOfQueue == -1) {
            beginningOfQueue = 0;
        }
    }

    public void enQueue(int value) {
        if (isQueueFull()) {
            System.out.println("\nQueue overflow error!!");
        } else {
            initializeStartOfArray();
            if (topOfQueue == queue.length - 1) { //if top is already at last cell of array, then reset it to first cell
                topOfQueue = 0;
            } else {
                topOfQueue++;
            }
            queue[topOfQueue] = value;
            System.out.println("\nSuccessfully inserted " + value + " in the queue");
        }
    }

    public void deQueue() {
        if (isQueueEmpty()) {
            System.out.println("Queue underflow error!!");
        } else {
            System.out.println("\nDequeing value from Queue...");
            System.out.println("Dequeued: " + queue[beginningOfQueue] + " from queue");
            queue[beginningOfQueue] = 0; //initialize the unused cell to 0
            if (beginningOfQueue == topOfQueue) { //if there is only 1 element in Queue
                beginningOfQueue = topOfQueue = -1;
            } else if (beginningOfQueue == queue.length - 1) { //if start has reached end of array, then start again from 0
                beginningOfQueue = 0;
            } else {
                beginningOfQueue++;
            }
        }
    }

    public void peekOperation() {
        //if stack is not empty, return the value on top of stack
        if (!isQueueEmpty()) {
            System.out.println("\nPeeking value from queue...");
            System.out.println(queue[beginningOfQueue]);
        } else {
            System.out.println("The queue is empty!!");
        }
    }

    public void deleteStack() {
        queue = null;
        System.out.println("Queue is successfully deleted !");
    }

}
