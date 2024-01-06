import java.util.Arrays;

public class BinaryString {
    int[] A;

    public BinaryString(int n) {
        A = new int[n];
    }

    public void binary(int n) {
        if (n < 1) {
            System.out.println(Arrays.toString(A));
            return;
        }

        A[n - 1] = 0;
        binary(n - 1);
        A[n - 1] = 1;
        binary(n - 1);
    }

    public static void main(String[] args) {
        int n = 2;
        BinaryString i = new BinaryString(n);
        i.binary(n);
    }
}
