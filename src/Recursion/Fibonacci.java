package Recursion;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(findFibonacci(5));
    }

    public static int findFibonacci(int number) {
        if (number < 1) {
            return 0;
        } else if (number == 1 || number == 2) {
            return number - 1;
        } else {
            return findFibonacci(number - 1) + findFibonacci(number - 2);
        }
    }
}
