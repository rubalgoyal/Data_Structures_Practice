import java.util.Scanner;

public class toh {
    public static void towerOfHanoi(int n, int  source, int aux, int dest){
        if(n ==1) {
            System.out.println("Move disk from" + source + "to" + dest);
            return;
        }
        towerOfHanoi(n-1, source, dest, aux);
        System.out.println("Move disk from" +source +"to" +dest);
        towerOfHanoi(n -1, aux,source,dest);


    }
    public static void main(String[]args){
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of disk");
        n = scanner.nextInt();
        towerOfHanoi(n,1,3,2);
    }


}
