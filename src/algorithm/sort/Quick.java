package algorithm.sort;

import algorithm.sort.util.Swaper;
import algorithm.sort.util.Tester;

import java.util.Arrays;

/**
 * 快速排序
 * 时间复杂度：O(n*logn)~O(n^2)
 *
 * @Author yuc
 */
public class Quick {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int L, int R) {
        if (L >= R) return;
        int i = L, j = R;
        int key = arr[L];
        while (i < j) {
            // 从右边开始，找到第一个小于key的数
            while (i < j && arr[j] >= key) --j;
            // 再从左边开始，找到第一个大于key的数
            while (i < j && arr[i] <= key) ++i;
            Swaper.exec(arr, i, j);
        }
        Swaper.exec(arr, L, i);
        sort(arr, L, i);
        sort(arr, i + 1, R);
    }

    public static void main(String[] args) {
        int n = 1_000_000;
        int[] arr = Tester.randomArr(n);
        System.out.println("对有" + n + "个元素的随机数组进行排序：");
//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("快速排序结束，耗时" + (end - start) + "ms");
//        System.out.println(Arrays.toString(arr));
    }


}
