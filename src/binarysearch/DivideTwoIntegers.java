package binarysearch;

/**
 * Created by omega on 11/4/18.
 */
public class DivideTwoIntegers {
    // assumption: a >= 0 , b >= 0
    // using bit operation and shift bit to implement divide
    public static void main(String[] args) {
        int result =  divide(16, 3);
        System.out.println(result);

    }

    public static int divide(int a, int b) {
        if (a < b) {
            return 0;
        }
        int largestOne = getHighestOne(a, b);
        int result = 0;
        int mask = 1 << (largestOne - 1);   // 这里要少移一次
        while (b <= a) {
            if (mask * b < a) {
                result |= mask;
                a -= mask * b;
            }
            mask >>>= 1;
        }
        return result;
    }

    public static int getHighestOne(int a, int b) {
        int result = 0;
        int coefficient = b;
        while (coefficient <= a) {
            coefficient <<= 1;
            result += 1;

        }
        return result;   // a = 16, b  = 3  ==> result = 3
    }
}
