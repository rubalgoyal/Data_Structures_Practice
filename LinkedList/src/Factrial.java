import java.util.Scanner;

public class Factrial {
    public static int factorial(int n ){
        if(n == 0)
            return 1;
        int fact = n * factorial(n-1);

      //  int bigProblem = n * smallerProblem;
        return fact;

    }

    public static void main(String[]args){
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n");
        n = scanner.nextInt();
        int result = factorial(n);
        System.out.println(result);





    }
}
