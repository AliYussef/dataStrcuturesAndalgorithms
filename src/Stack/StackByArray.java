package Stack;

public class StackByArray {
    private int[] stack;
    private int topOfStack;

    public StackByArray(int sizeOfStack) {
        stack = new int[sizeOfStack];
        topOfStack = -1;
    }

    private boolean isStackFull() {
        return topOfStack == stack.length - 1;
    }

    private boolean isStackEmpty() {
        return topOfStack == -1;
    }

    /* Add value to top of the stack */
    public void push(int value) {
        if (isStackFull()) {
            System.out.println("Stack is full");
        } else {
            stack[topOfStack + 1] = value;
            topOfStack++;
        }
    }

    /* Delete top element and return it back */
    public int pop() {
        if (isStackEmpty()) {
            System.out.println("Stack is empty");
            return 0;
        } else {
            int value = stack[topOfStack];
            topOfStack--;
            return value;
        }
    }

    /* return the value of the top of stack */
    public int peek() {
        if (isStackEmpty()) {
            System.out.println("Stack is empty");
            return 0;
        } else {
            return stack[topOfStack];
        }
    }

    /* delete the stack */
    public void deleteStack() {
        stack = null;
        System.out.println("Stack is successfully deleted");
    }

}
