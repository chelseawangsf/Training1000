package sort;

/**
 * Created by omega on 10/19/18.
 * tc1 = {-1, -3, 4, 7}  => {-3, -1, 4, 7}
 */
public class SelectionSort {
    public int[] selectionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int i, j, curMin;
        for (i = 0; i < array.length - 1; i++) {
            curMin = i;
            for (j = i + 1; j < array.length; j++) {
                if (array[j] < array[curMin]) {
                    curMin = j;
                }
            }
            swap(array, i, curMin);
        }
        return array;
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        SelectionSort test = new SelectionSort();
        int[] tc1 = new int[]{-1, -3, 4, 7};
        int[] result = test.selectionSort(tc1);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
