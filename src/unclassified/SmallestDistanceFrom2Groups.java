package unclassified;

import java.util.*;
import java.util.stream.Collectors;


/**
 * As described in solution of 18.5 in Ctci
 */
public class SmallestDistanceFrom2Groups {
    public static void main(String[] args) {
        System.out.println(smallerDistance(new int[]{1, 2, 9, 15,25}, new int[]{4, 10, 19}));
    }

    ;

    public static class Wrapper implements Comparable<Wrapper> {
        final int data;
        final int list;

        public Wrapper(int a, int list) {
            this.data = a;
            this.list = list;
        }

        @Override
        public int compareTo(Wrapper o) {
            return this.data - o.data;
        }
    }

    public static int smallerDistance(int[] a, int[] b) {
        List<Wrapper> c = Arrays.stream(a).mapToObj(item -> new Wrapper(item, 0)).collect(Collectors.toList());
        for (int i = 0; i < b.length; i++) {
            c.add(new Wrapper(b[i], 1));
        }
        Collections.sort(c);

        int curMin = Integer.MAX_VALUE;
        for (int i = 1; i < c.size(); i++) {
            if (c.get(i).list != c.get(i - 1).list && Math.abs(c.get(i).data - c.get(i - 1).data) < curMin) {
                curMin = Math.abs(c.get(i).data - c.get(i - 1).data);
            }
        }

        return curMin;
    }
}
