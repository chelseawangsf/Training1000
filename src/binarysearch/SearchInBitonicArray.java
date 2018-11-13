package binarysearch;

/**
 * Created by omega on 11/4/18.
 */
public class SearchInBitonicArray {
    public static void main(String[] args) {
        int result = search(new int[]{9, 5, 3, 2, -4, -5}, 5);
        System.out.println(result);
    }

    public static int search(int[] array, int target) {
        // Write your solution here.
        // step 1: find maximum element
        // step 2: do 2 binary search in increasing part and decreasing part
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int maxIdx = searchMax(array);
        // return maximum element's index
        int leftResult = binarySearch(array, 0, maxIdx, target);
        int rightResult = binarySearch(array, maxIdx + 1, right, target);
        if (leftResult != -1) {
            return leftResult;
        }
        if (rightResult != -1) {
            return rightResult;
        }
        return -1;
    }

    public static int binarySearch(int[] array, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static  int searchMax(int[] array) {
        int left = 0;
        int right = array.length -  1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < array[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}