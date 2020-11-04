package algorithm.sort;

import algorithm.sort.util.Tester;

import java.util.*;

/**
 * 基数排序
 * 时间复杂度：O(n*digit)
 * 空间复杂度：O(n)
 *
 * @Author yuc
 */
public class Radix {

    /**
     * 简易版基数排序，好理解，建议先看
     *
     * @param arr
     */
    public static void easyVersionSort(int[] arr) {
        int digit = getMaxDigit(arr);
        int mod = 10, base = 1, idx;
        // 数组嵌套队列，简化基数排序的流程，性能较差
        List<Queue<Integer>> tmp = new ArrayList<>(mod);
        for (int i = 0; i < mod; ++i) {
            tmp.add(new LinkedList<>());
        }
        while (digit-- > 0) {
            for (int i = 0; i < arr.length; ++i) {
                tmp.get(arr[i] / base % mod).offer(arr[i]);
            }
            idx = 0;
            for (int i = 0; i < mod; ++i) {
                while (!tmp.get(i).isEmpty()) {
                    arr[idx++] = tmp.get(i).poll();
                }
            }
            base *= mod;
        }
    }

    /**
     * 基数排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        int digit = getMaxDigit(arr);
        int mod = 10;
        int[] count;
        int[] tmp = new int[arr.length];
        int base = 1;
        while (digit-- > 0) {
            count = new int[mod];
            for (int i = 0; i < arr.length; ++i) {
                ++count[arr[i] / base % mod];
            }
            // 索引偏移
            for (int i = 1; i < mod; ++i) {
                count[i] += count[i - 1];
            }
            // 根据位数和索引将一趟基数排序后的arr存入tmp数组
            for (int i = arr.length - 1; i >= 0; --i) {
                int d = arr[i] / base % mod;
                --count[d];
                tmp[count[d]] = arr[i];
            }
            // 将tmp数组赋予arr
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = tmp[i];
            }
            base *= mod;
        }
    }

    /**
     * 获取数组中最大的位数
     *
     * @param arr
     * @return
     */
    private static int getMaxDigit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            max = Math.max(max, val);
        }
        int digit = 1;
        while ((max /= 10) > 0) {
            ++digit;
        }
        return digit;
    }

    public static void main(String[] args) {
        int n = 1_000_000;
        int[] arr = Tester.randomArr(n);
        System.out.println("对有" + n + "个元素的随机数组进行排序：");
//        int[] arr = new int[]{100000000,1};
//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        easyVersionSort(arr);
//        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("基数排序结束，耗时" + (end - start) + "ms");
//        System.out.println(Arrays.toString(arr));
    }

}
