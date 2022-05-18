package PracticeProjects.HashMapImplementation;

import java.util.HashMap;
import java.util.TreeSet;

public class HashMapTest {
    public static void main(String[] args) {
        THashMap<Integer, Integer> map = new THashMap<Integer, Integer>();
        // HashMap<Integer, Integer> mapOff = new HashMap<Integer, Integer>();
        TreeSet<Integer> l = new TreeSet<Integer>();
        TreeSet<Integer> s = new TreeSet<Integer>();
        int length = 250;

        for (int i = 0; i < length; i++) {
            map.put(i, i);
        }

        /*
         * for (int i = 0; i < 10000; i++) {
         * mapOff.put(i, i);
         * 
         * }
         */

        /*
         * for (Integer integer : map) {
         * l.add(integer);
         * }
         */

        long t1 = System.nanoTime();
        for (int i = 0; i < length; i++) {
            l.add(map.get(i));
        }
        System.out.println((System.nanoTime() - t1) / 10000);

        /*
         * long t2 = System.nanoTime();
         * for (int i = 0; i < 10000; i++) {
         * s.add(mapOff.get(i));
         * }
         * System.out.println((System.nanoTime() - t2) / 10000);
         */

        // System.out.println(l);
        System.out.println(l.size());
        System.out.println(s.size());
    }
}
