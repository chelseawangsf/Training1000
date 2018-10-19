package binarysearch;

/**
 * Created by omega on 10/19/18.
   tc1: [1,1,2,3,3,3,4,5]  find 3, 3 appear 3 times > lengtg == 8
 */
public class SearchTargetQuarter {
    public static void main(String[] args) {
        SearchTargetQuarter test = new SearchTargetQuarter();
        int[] tc1 = new int[]{1,1,2,3,3,4,5,5,5,5};
        System.out.println(test.searchTargetQuarter(tc1));
    }
    public int searchTargetQuarter(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        // tc1: n = 8;
        // look array[n * 1/4]
        //      array[n * 1/2]
        //      array[n * 3 /4]
        int[] candidates = new int[3];
        candidates[0] = array[array.length * 1/4];
        candidates[1] = array[array.length * 1/2];
        candidates[2] = array[array.length * 3/4];

        for (int candidate : candidates) {
            int occurence  = findOccurence(array, candidate);
            if (occurence > array.length * 1/4) {
                return candidate;
            }
        }
        return -1;
    }

    // find first index and last index, return last index - first index + 1
    public int findOccurence(int[] array, int target) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int firstIndex = findFirstIndex(array, target);
        int lastIndex = findLastIndex(array, target);
        return lastIndex - firstIndex + 1;
    }
    public int findFirstIndex(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return array[left] == target ? left : -1;
    }
    public int findLastIndex(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                left = mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (array[right] == target) {
            return right;
        } else if (array[left] == target) {
            return left;
        }
        return -1;
    }
}
