package binarysearch;
import java.util.*;
/**
 * Created by omega on 11/18/18.
 */
public class RandomGenerator {
    public static void main(String[] args) {
        char[] s = new char[]{'a', 'b', 'c', 'd'};
        int[] w = new int[]{40, 30, 20, 10};
        RandomGenerator test = new RandomGenerator(s, w);
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        for (int i = 0; i < 100; i++) {
            char c = test.getSymbols();
            if (c == 'a') {
                aCount++;
            } else if (c == 'b') {
                bCount++;
            } else if (c == 'c') {
                cCount++;
            } else if (c == 'd') {
                dCount++;
            }
        }
        System.out.println(aCount);
        System.out.println(bCount);
        System.out.println(cCount);
        System.out.println(dCount);
    }

    public Random random;
    public int[] ranges;
    public int rangeSum;
    public char[] symbols;

    public RandomGenerator(char[] symbols, int[] weights) {
        // input validation

        random = new Random();
        ranges = new int[weights.length];
        rangeSum = initialize(ranges, weights);
        this.symbols = symbols;
    }

    public int initialize(int[] ranges, int[] weights) {
        int prefixSum = 0;
        for (int i = 0; i < ranges.length; i++) {
           prefixSum += weights[i];
           ranges[i] = prefixSum;
        }  // [40, 70, 90, 100]
        return prefixSum;
    }
    public char getSymbols() {
        int target = random.nextInt(rangeSum);
        System.out.println(target);
        // binary serach for the smallest larger than
        // TODO: find smallest larger than element in the ranges array
        int left = 0;
        int right = ranges.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (ranges[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(symbols[left]);
        return symbols[left];

    }
}
