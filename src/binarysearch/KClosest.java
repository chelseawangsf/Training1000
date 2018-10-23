package binarysearch;

public class KClosest {

    public class Solution {
        public int[] kClosest(int[] array, int target, int k) {
            // Write your solution here
            if (array == null || array.length == 0) {
                return new int[0];
            }
            int[] result = new int[k];
            // first closest 2 elements to target
            // assumption k <= array.length
            int left =  findLargestSamllerEqual(array, target);
            int right = left + 1;
            // left 2 elements
            for (int i= 0; i < k; i++) {
                if (right >= array.length || (left >= 0 && (Math.abs(target - array[left]) < Math.abs(target - array[right])))) {
                    result[i] =  array[left--];
                } else {
                    result[i] = array[right++];
                }
            }
            return result;
        }

        public int findLargestSamllerEqual(int[] array, int target) {
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
                    left = mid;
                } else {
                    right = mid;
                }
            }
            // left 2 elements
            if (array[right] <= target) {
                return right;
            }
            if (array[left] <= target) {
                return left;
            }
            return -1;
        }
    }

}
