package Array;

import sun.lwawt.macosx.CSystemTray;

public class SingleDimensionalArray {
    int[] arr;

    public SingleDimensionalArray(int sizeOfArray) {
        arr = new int[sizeOfArray];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
    }

    //display array
    public void traverseArray() {
        try {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i] + " ");
            }
        } catch (Exception ex) {
            System.out.println("Array no longer exists!");
        }
    }

    public void insert(int position, int valueToBeInserted) {
        try {
            if (arr[position] == Integer.MIN_VALUE) {
                arr[position] = valueToBeInserted;
                System.out.println("Successfully inserted!");
            } else {
                System.out.println("This cell is already occupied by another value");
            }
        } catch (Exception ex) {
            System.out.println("Invalid index!");
        }
    }

    public void accessCell(int position) {
        try {
            System.out.println(arr[position]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Index out of range!!");
        }
    }

    public void searchInArray(int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                System.out.println("Value found!");
                return;
            }
        }
        System.out.println("Value not there!");
    }

    public void deleteValueFromArray(int position) {
        try {
            arr[position] = Integer.MIN_VALUE;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Index out of range!");
        }
    }


}
