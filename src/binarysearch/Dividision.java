package binarysearch;

/**
 * Created by omega on 11/19/18.
 */
public class Dividision {
    public static void main(String[] args) {
        System.out.println(divide(-51, 51));
    }

    // assumption divisor and dividend are integers, and results are integer
    // using bit operation to do division
    // divisor = 16, dividend = 3, result = 5;
    public static int divide(int a, int b) {
        // Write your solution here
        if (b == 0) {
            return Integer.MAX_VALUE;
        }
        if (a == 0) {
            return 0;
        }
        int sign = 1;
        if( (a > 0 && b < 0) || (a < 0 && b > 0)) {
            sign = -1;
        }
        a = Math.abs(a);
        b = Math.abs(b);
        if (a < b) {
            return 0;
        }
        if (a == b) {
            return 1;
        }
        int shift = findHighestOne(a, b);
        int mask = 1 << shift;
        int result = 0;
        while (b <= a) {
            if (mask * b < a) {
                result |= mask;
                a -= mask * b;
            }
            mask >>>= 1;
        }
        return sign * result;

    }

    public  static int findHighestOne(int a, int b) {
        int coefficient = b;
        int result = 0;
        while (coefficient <= a) {
            coefficient <<= 1;
            result = result + 1;
        }
        return result - 1;
    }
}
