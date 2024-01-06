import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String champion = "";
        int count = 1;

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if(StdRandom.bernoulli(1.0 / count))
                champion = word;
            count++;

        }

        System.out.println(champion);
    }
}
