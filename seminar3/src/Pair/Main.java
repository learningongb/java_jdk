package S3.Pair;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(1, "Two");
        System.out.println(pair1.getFirst());
        System.out.println(pair1.getSecond());
        System.out.println(pair1);

        Pair<List<String >, Double> pair2 = new Pair<>(new ArrayList<>(), 2.0);
        System.out.println(pair2.getFirst());
        System.out.println(pair2.getSecond());
        System.out.println(pair2);
    }
}
