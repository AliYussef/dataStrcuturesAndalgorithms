package Array;

public class TwoDimensionalArray {
    int[][] arr;

    public TwoDimensionalArray(int row, int column) {
        arr = new int[row][column];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public void traverseArray() {
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.println(arr[i][j] + " ");
                }
                System.out.println();
            }
        } catch (Exception ex) {
            System.out.println("Array not found!");
        }
    }

    public void insert(int row, int column, int valueToBeInserted) {
        try {
            if (arr[row][column] == Integer.MIN_VALUE) {
                arr[row][column] = valueToBeInserted;
                System.out.println("Successfully inserted!");
            } else {
                System.out.println("This cell is already occupied by another value");
            }
        } catch (Exception ex) {
            System.out.println("Invalid index!");
        }
    }

    public void accessCell(int row, int column) {
        try {
            System.out.println(arr[row][column]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Index out of range!!");
        }
    }

    public void searchInArray(int value) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == value) {
                    System.out.println("Value found!");
                    return;
                }
            }
        }
        System.out.println("Value not there!");
    }

    public void deleteValueFromArray(int row, int column) {
        try {
            arr[row][column] = Integer.MIN_VALUE;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Index out of range!");
        }
    }

}
