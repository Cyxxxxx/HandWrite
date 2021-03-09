package algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int start = l;
        int end = r;
        int key = arr[start];
        while (l < r) {
            while (l < r && arr[r] >= key) --r;
            while (l < r && arr[l] <= key) ++l;
            swap(arr, l, r);
        }
        swap(arr, start, l);
        sort(arr, start, l);
        sort(arr, r + 1, end);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 1, 3, 5, 4, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
