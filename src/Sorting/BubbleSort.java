package Sorting;

public class BubbleSort {
    public void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) //run from first cell to last cell
            for (int j = 0; j < n - i - 1; j++) //run from first cell to "last cell - iteration"
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }//end of method


    /* Prints the array */
    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
