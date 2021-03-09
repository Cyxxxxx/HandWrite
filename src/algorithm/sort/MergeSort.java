package algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, r);
    }

    private static void merge(int[] arr, int l, int r) {
        int[] tmp = new int[r - l + 1];
        int mid = l + (r - l) / 2;
        int i = l, j = mid + 1;
        int tmpIdx = 0;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[tmpIdx] = arr[i++];
            } else {
                tmp[tmpIdx] = arr[j++];
            }
            ++tmpIdx;
        }
        while(i <= mid) tmp[tmpIdx++] = arr[i++];
        while(j <= r) tmp[tmpIdx++] = arr[j++];
        System.out.println(Arrays.toString(tmp));
        for (int k = l; k <= r; ++k) {
            arr[k] = tmp[k - l];
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 1, 3, 5, 4, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
