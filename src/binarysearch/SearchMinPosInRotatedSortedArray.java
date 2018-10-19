package binarysearch;

/**
 * Created by omega on 10/18/18.
 */
public class SearchMinPosInRotatedSortedArray {

    // parameter: an array of integers
    // return : index of minimum element
    // assumption: no duplicate
    public int searchMin(int[] array) {
        // sanity check
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < array[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // only left 1 element
        return left;
    }
    public static void main(String[] args) {
        SearchMinPosInRotatedSortedArray tc = new SearchMinPosInRotatedSortedArray();
        int[] test = new int[]{3,4,5,1,2};
        System.out.println(tc.searchMin(test));
    }
}


/**
 *
 * test case: [1,2,3,4,5]
 * test case: null
 * test case : [1]
 * test case: [3,4,5,1,2]
 */
