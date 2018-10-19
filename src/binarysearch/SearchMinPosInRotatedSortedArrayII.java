package binarysearch;

/**
 * Created by omega on 10/19/18.
 * II: with duplicate
 */
public class SearchMinPosInRotatedSortedArrayII {
    public int searchMin(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left  = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                right = mid;
            } else {
                right = right - 1;
            }
        }
        // post-processing: left 1 elements
        return left;
    }
    public static void main(String[] args) {
        int[] tc1 = new int[]{2,3,3,1,2,3};
        SearchMinPosInRotatedSortedArrayII test = new SearchMinPosInRotatedSortedArrayII();
        System.out.println(test.searchMin((tc1)));
    }
}

/**
 * tc1: null  return -1
 * tc2: []   return -1
 * tc3: [1,2,3,3,3,3,3]
 * tc4: [2,3,3,1,2,3]
 * tc5: [4,5,6,1,2]  array[mid] > array[right]
 */
