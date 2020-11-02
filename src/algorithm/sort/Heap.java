package algorithm.sort;

import algorithm.sort.util.Swaper;
import algorithm.sort.util.Tester;

import java.util.Arrays;

/**
 * 堆排序
 * 时间复杂度：O(n*logn)
 *
 * @Author yuc
 */
public class Heap {

    public static void sort(int[] arr) {
        int len = arr.length;
        // 1. 构建大顶堆
        for (int i = len / 2 - 1; i >= 0; --i) {
            // 从第一个非叶子结点从下至上，从右至左调整结构
            heapAdjust(arr, i, len);
        }

        // 2. 排序
        for (int j = len - 1; j > 0; --j) {
            Swaper.exec(arr, 0, j);
            heapAdjust(arr, 0, j);
        }
    }

    private static void heapAdjust(int[] heap, int i, int len) {
        int tmp = heap[i];
        // 从i节点的左子节点开始，即i*2+1
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
            // 当左子节点小于右子节点，则让父节点与右子节点相比
            if (k + 1 < len && heap[k] < heap[k + 1]) {
                ++k;
            }
            if (heap[k] > tmp) {
                heap[i] = heap[k];
                i = k;
            } else {
                break;
            }
        }
        // tmp值放在最终的位置
        heap[i] = tmp;
    }


    public static void main(String[] args) {
        int n = 1_000_000;
        int[] arr = Tester.randomArr(n);
        System.out.println("对有" + n + "个元素的随机数组进行排序：");
//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("堆排序结束，耗时" + (end - start) + "ms");
//        System.out.println(Arrays.toString(arr));
    }
}
