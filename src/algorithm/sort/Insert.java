package algorithm.sort;

import algorithm.sort.util.Swaper;
import algorithm.sort.util.Tester;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度 O(n^2)
 *
 * @Author yuc
 */
public class Insert {

    /**
     * 直接插入排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            // 每趟插入排序前，数组区间[0,i]经过上一趟插入排序处理后，是有序的
            // 当遍历时遇到相对有序，直接进行下一趟排序
            for (int j = i + 1; j > 0 && arr[j - 1] > arr[j]; --j) {
                Swaper.exec(arr, j - 1, j);
            }
        }
    }

    /**
     * 二分查找插入排序
     *
     * @param arr
     */
    public static void optSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            int j = i + 1;
            // 二分查找找到合适的插入位置
            int insertIdx = binarySearch(arr, 0, i, arr[j]);
            // 存储需要插入的元素
            int tmp = arr[j];
            // 将数组区间(insertIdx,j)中的元素往后移一位
            for (; j > insertIdx; --j) {
                arr[j] = arr[j - 1];
            }
            // 为指定下标赋值
            arr[insertIdx] = tmp;
        }
    }

    private static int binarySearch(int[] arr, int start, int end, int key) {
        if (key <= arr[start]) {
            return start;
        } else if (key >= arr[end]) {
            return end + 1;
        } else {
            int mid = start + (end - start) / 2;
            if (key > arr[mid]) {
                return binarySearch(arr, mid + 1, end, key);
            } else {
                return binarySearch(arr, start, mid, key);
            }
        }
    }

    public static void main(String[] args) {
        int n = 100_000;
        int[] tmp = Tester.randomArr(n);
        int[] arr = tmp.clone();
        System.out.println("对有" + n + "个元素的随机数组进行排序：");
//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("插入排序结束，耗时" + (end - start) + "ms");

        arr = tmp.clone();
        start = System.currentTimeMillis();
        optSort(arr);
        end = System.currentTimeMillis();
        System.out.println("二分插入排序结束，耗时" + (end - start) + "ms");
//        System.out.println(Arrays.toString(arr));
    }
}
