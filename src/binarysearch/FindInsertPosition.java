package binarysearch;

public class FindInsertPosition {
    // input: an array of integers

    public int findInsertPosition(int[] array, int target) {
        // sanity check
        if (array == null || array.length == 0) {
            return 0;
        }
        // find smallest larger and equal
        // or find largest small than + 1
        int left = 0;
        int right = array.length - 1;
        while (left  + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
               right = mid;
            }
        }

        // post-processing, only left 2 element, base case
        if (array[left] >= target) {
            return left;
        } else if (array[right] >= target) {
            return right;
        }
        return right + 1;
    }

    public static void main(String[] args) {
        FindInsertPosition test = new FindInsertPosition();
        int[] tc1 = new int[0];
        int[] tc2 = new int[]{1, 4};

        System.out.println(test.findInsertPosition(tc2, 19));
    }
}
/*
   insert 19
  [1, 4] =>
  l   r
  m


 */