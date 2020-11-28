package Recursion;

public class BiggestNumber {
    static int highest = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 6, 4, 2, 34, 55, 22, 35, 2323, 545, 33, 5, 6, 6, 666, 7};
        System.out.println(findBiggestNumber(numbers, numbers.length -1));
    }

    public static int findBiggestNumber(int[] numbers, int sizeOfArray) {
        if (sizeOfArray == -1) {
            return highest;
        } else {
            if (numbers[sizeOfArray] > highest) {
                highest = numbers[sizeOfArray];
            }
            return findBiggestNumber(numbers, sizeOfArray - 1);
        }
    }
}
