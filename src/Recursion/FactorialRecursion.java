package Recursion;

public class FactorialRecursion {

    public static void main(String[] args) {
        System.out.println(findFactorial(5));
    }

    private static int findFactorial(int number) {
        if (number == 1){
            return 1;
        }
        else {
           //int result = findFactorial(number -1);
          return number * findFactorial(number -1);
        }
    }

}
