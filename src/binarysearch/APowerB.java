package binarysearch;

public class APowerB {
    public double aPowerB(double a, int b) {
        // corner case
        if (b == 0) {
            return 1;
        }
        if (b < 0) {
            return 1.0 / helper(a, Math.abs(b));
        }
        return helper(a, b);

    }

    public double helper(double a, int b) {
        if (b == 0) {
            return 1;
        }
        double half = helper(a, b / 2);
        return b % 2 == 0 ? half * half : half * half * a;
    }

    public static void main(String[] args) {
        APowerB test = new APowerB();
        System.out.println(test.aPowerB(2.0, 4));
    }
}
