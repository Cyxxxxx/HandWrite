package algorithm.sort;

import java.util.Arrays;

public class HeapSort {

    public static void topN(int[] arr, int N) {
        for (int i = 1 + arr.length / 2; i >= 0; --i) {
            adjust(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0 && N-- > 0; --i) {
            System.out.println(arr[0]);
            swap(arr, 0, i);
            adjust(arr, 0, i);
        }
    }

    public static void sort(int[] arr) {
        for (int i = 1 + arr.length / 2; i >= 0; --i) {
            adjust(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; --i) {
            System.out.println(arr[0]);
            swap(arr, 0, i);
            adjust(arr, 0, i);
        }
    }

    private static void adjust(int[] arr, int start, int len) {
        int tmp = arr[start];
        for(int i = start*2+1;i<len;i = i*2+1){
            if(i+1 < len && arr[i]<arr[i+1]){
                ++i;
            }
            if(arr[i]>tmp){
                arr[start] = arr[i];
                start = i;
            } else break;
        }
        arr[start] = tmp;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 1, 3, 5, 4, 6};
//        sort(arr);
//        System.out.println(Arrays.toString(arr));
        topN(arr, 5);
    }
}
