package algorithm.sort;

public abstract class ArraySort {

    /**
     * 数组元素排序方法
     *
     * @param arr
     */
    public static void sort(int[] arr) {};

    /**
     * 数组元素交换方法
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
