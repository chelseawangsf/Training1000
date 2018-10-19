package binarysearch;

/**
 * Created by omega on 10/19/18.
   tc1: null
   tc2: []
   tc3: [2]
   tc4: [3,4,5,6,1,2]  find 6
   tc5: [1,2,3,4,]  find 3
 */


public class SearchTargetInRotatedArray {
    public static void main(String[] args) {
        SearchTargetInRotatedArray test = new SearchTargetInRotatedArray();
        int[] tc1 = new int[]{3, 4, 5, 6, 12};
       System.out.println(test.searchTarget(tc1, 6));
        System.out.println(test.searchTarget(null, 8));
        System.out.println(test.searchTarget(null, 8));
    }

  public int searchTarget(int[] array, int target) {
      if (array == null || array.length == 0) {
        return -1;
      }
      int left = 0;
      int right = array.length - 1;
      while (left <= right) {
          int mid = left + (right - left) / 2;
          if (array[mid] == target) {
              return mid;
          }
          if (array[mid] > array[right]) {
              if (target >= array[mid] || target <= array[right]) {
                  left = mid + 1;
              } else {
                  right = mid - 1;
              }
          } else {
              if (target >= array[mid] && target <= array[right]) {
                  left = mid + 1;
              } else {
                  right = mid - 1;
              }
          }
      }
      return -1;
  }

}
