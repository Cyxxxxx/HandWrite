package algorithm.sort;

import algorithm.sort.util.Swaper;
import algorithm.sort.util.Tester;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度O(n^2)
 *
 * @Author yuc
 */
public class Selection {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            int minIdx = i;
            // 在数组区间[i+1,j]中找出一个最小（比arr[i]还小的）的，记录其下标为minIdx
            for (int j = arr.length - 1; j > i; --j) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // 当minIdx发生变动，证明数组区间[i+1,j]中有比arr[i]小的值，进行交换
            if (minIdx != i) {
                Swaper.exec(arr, i, minIdx);
            }
        }
    }

    public static void main(String[] args) {
        int[] tmp = Tester.randomArr(10000);
        int[] arr = tmp.clone();
        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("选择排序结束，耗时" + (end - start) + "ms");
        System.out.println(Arrays.toString(arr));
    }
}
