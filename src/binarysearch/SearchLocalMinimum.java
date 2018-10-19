package binarysearch;

/**
 * Created by omega on 10/19/18.
   tc1: [1,3,2,4,5]
   local minimum: 1, 2
   find any
 */
public class SearchLocalMinimum {
    public int searchLocalMin(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < array[mid + 1]) {
                right = mid;
            } else if (array[mid] > array[mid + 1]) {
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        SearchLocalMinimum test = new SearchLocalMinimum();
        int[] tc1 = new int[]{1,3,2,4,5};
        System.out.println(test.searchLocalMin(tc1));

    }

}
