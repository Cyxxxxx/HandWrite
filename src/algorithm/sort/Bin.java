package algorithm.sort;

import algorithm.sort.util.Tester;

import java.util.Arrays;

/**
 * 箱排序
 * 时间复杂度：O(n)
 * 空间复杂度：O(arr.maxValue)
 *
 * @Author yuc
 */
public class Bin {

    public static void sort(int[] arr) {
        // 1. 获取待排序数组中的最大值N
        int N = Integer.MIN_VALUE;
        for (int val : arr) {
            N = Math.max(N, val);
        }
        // 2. 依据N来构建bin数组
        int[] bin = new int[++N];

        // 3. 将待排序数组中出现过的值在bin的对应索引处统计
        for (int val : arr) {
            ++bin[val];
        }
        // 4. 遍历bin数组，获得顺序数组
        int idx = 0;
        for (int j = 0; j < N; ++j) {
            if (bin[j]-- > 0) {
                arr[idx++] = j;
            }
        }
    }

    public static void main(String[] args) {
        int n = 1_000_000;
        int[] arr = Tester.randomArr(n);
        System.out.println("对有" + n + "个元素的随机数组进行排序：");
//        int[] arr = new int[]{100000000,1};
//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("箱排序结束，耗时" + (end - start) + "ms");
//        System.out.println(Arrays.toString(arr));
    }
}
