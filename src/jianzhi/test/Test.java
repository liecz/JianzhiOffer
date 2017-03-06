package jianzhi.test;

import java.util.BitSet;
import java.util.Random;

/**
 * Created by liec on 2017-03-05.
 */
public class Test {

    private static final int MAX = 100_000_000;

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        BitSet set = new BitSet(MAX);
        int count = 0;
        Random r = new Random();
        while (++count <= MAX / 10) {
            set.set(r.nextInt(MAX));
        }
        for (int i = 0; i < count; i++) {
//            System.out.print(set.get(i)?i:"");
//            System.out.print(" ");
        }
        long b = System.currentTimeMillis();
        System.out.println("b = " + (b - a));
    }

}
