package algorithm.sort;

import algorithm.sort.util.Tester;

import java.util.Arrays;

/**
 * 箱排序
 * 时间复杂度：O(n)
 * 空间复杂度：O(arr.maxValue-arr.minValue)
 * 注意：箱排序是有缺陷的，当数组元素过大或过小（如Integer.MAX_VALUE等，则会造成OOM或NegativeArraySizeException）
 *
 * @Author yuc
 */
public class Bin {

    public static void sort(int[] arr) {
        // 1. 获取待排序数组中的最大值、最小值
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        for (int val : arr) {
            max = Math.max(max, val);
            min = Math.min(min, val);
        }
        long N = max-min+1;

        // 2. 依据最大值、最小值来构建bin数组
        int[] bin = new int[(int)N];

        // 3. 将待排序数组中出现过的值，以数组中的最小值作为偏移量，在bin的对应索引处统计
        for (int val : arr) {
            ++bin[val-(int)min];
        }
        // 4. 遍历bin数组，获得顺序数组
        int idx = 0;
        for (int j = 0; j < bin.length; ++j) {
            while (bin[j]-- > 0) {
                // 偏移量修正
                arr[idx++] = j+(int)min;
            }
        }
    }

    private static void sort(int[] arr, int max, int min) {

    }

    public static void main(String[] args) {
        int n = 1_00;
        int[] arr = Tester.randomArr(n);
//        int[] arr = new int[]{Integer.MIN_VALUE,0}; // 出现 NegativeArraySizeException
        System.out.println("对有" + n + "个元素的随机数组进行排序：");
        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("箱排序结束，耗时" + (end - start) + "ms");
        System.out.println(Arrays.toString(arr));
    }
}
