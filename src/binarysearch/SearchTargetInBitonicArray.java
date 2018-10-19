package binarysearch;

/**
 * Created by omega on 10/19/18.
 * no duplciate
 */
public class SearchTargetInBitonicArray {

    /**
     * tc1: null
     * tc2: []
     * tc3: [1,9,78, 56, 23, 12]  find 23
     * @param array
     * @param target
     * @return
     */
    public int searchTarget(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        // step 1:find peak element
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[mid + 1]){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int peak = left;
        int leftResult = binarySearch(array, 0, peak, target);
        int rightResult = binarySearch(array, peak+ 1, array.length - 1, target);
        if (leftResult != -1) {
            return leftResult;
        } else if (rightResult != -1) {
            return rightResult;
        }
        return -1;
    }

    public int binarySearch(int[] array, int left, int right, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] tc1 =  new int[]{1,9,78, 56, 23, 12};
        SearchTargetInBitonicArray test = new SearchTargetInBitonicArray();
        System.out.println(test.searchTarget(tc1, 78));
    }
}
