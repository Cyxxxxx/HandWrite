package algorithm.sort;

import algorithm.sort.util.Tester;


/**
 * 归并排序
 * 时间复杂度：O(n*logn)
 *
 * @Author yuc
 */
public class Merge {

    /**
     * 排序入口
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 将数组递归分治
     *
     * @param arr
     * @param L
     * @param R
     */
    private static void sort(int[] arr, int L, int R) {
        if (L < R) {
            int mid = L + ((R - L) >> 1);
            sort(arr, L, mid);
            sort(arr, mid + 1, R);
            merge(arr, L, mid, R);
        }
    }

    /**
     * 归并方法
     *
     * @param arr
     * @param L
     * @param mid
     * @param R
     */
    private static void merge(int[] arr, int L, int mid, int R) {
        int[] tmpArr = new int[R - L + 1];
        int idx = 0;
        int i = L, j = mid + 1;
        // 同时遍历arr数组中[L, mid]和[mid+1, R]两个区间，将较小值放入tmpArr临时数组中
        while (i <= mid && j <= R) {
            tmpArr[idx++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }
        while (i <= mid) tmpArr[idx++] = arr[i++];
        while (j <= R) tmpArr[idx++] = arr[j++];
        // 将tmpArr数组中排序完毕的值放回原数组中
        for (int val : tmpArr) {
            arr[L++] = val;
        }
    }

    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 1_000_000;
        int[] arr = Tester.randomArr(n);
        System.out.println("对有" + n + "个元素的随机数组进行排序：");
//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("归并排序结束，耗时" + (end - start) + "ms");
//        System.out.println(Arrays.toString(arr));
    }
}
