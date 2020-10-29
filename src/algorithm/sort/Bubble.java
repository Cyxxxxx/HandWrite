package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度：O(n)
 */
public class Bubble {

    /**
     * 交换数组中的两项
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 异或交换
     * @param arr
     * @param i
     * @param j
     */
    private static void optSwap(int[] arr,int i,int j){
        // 使用异或的特性优化交换
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    public static void holyShitSort(int[] arr){
        for(int i=0;i<arr.length;++i){
            System.out.println("第"+(i+1)+"趟排序开始时，数组为："+Arrays.toString(arr));
            for(int j=0;j<arr.length-1;++j){
                if(arr[j]>arr[j+1]){
                    optSwap(arr,j,j+1);
                }
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            // 每一趟排序都会把数组[i,j]范围中最小的项移到 i的位置
            // 再让i自增，减少下一趟排序需要遍历的数组大小
            System.out.println("第"+(i+1)+"趟排序开始时，数组为："+Arrays.toString(arr));
            System.out.println("需要遍历的数组大小为"+(arr.length-i));
            for (int j = arr.length - 1; j > i; --j) {
                if (arr[j - 1] > arr[j]) {
                    optSwap(arr, j - 1, j);
                }
            }
        }
//         或
//        for (int i = arr.length - 1; i > 0; --i) {
//            // 每一趟排序都会把数组[i,j]范围中最大的项移到 i的位置
//            // 再让 i自减，减少下一趟排序需要遍历的数组大小
//            for (int j = 0; j < i; ++j) {
//                if (arr[j] > arr[j + 1]) {
//                    swap(arr, j, j + 1);
//                }
//            }
//        }
    }

    /**
     * 改良冒泡排序
     * @param arr
     */
    public static void optSort(int[] arr) {
        //  确认当前数组是否为顺序的标志位
        boolean isSeq;
        for (int i = 0; i < arr.length - 1; ++i) {
            // 每一趟排序开始前，默认这一趟排序是顺序的，直到遇见需要交换的地方
            isSeq = true;
            System.out.println("第"+(i+1)+"趟排序开始时，数组为："+Arrays.toString(arr));
            for (int j = arr.length - 1; j > i; --j) {
                if (arr[j - 1] > arr[j]) {
                    optSwap(arr, j - 1, j);
                    isSeq = false;
                }
            }
            // 若遍历一趟下来，确认数组是顺序的，则无需进行下一次遍历
            if (isSeq) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] tmp = Tester.randomArr(1000);
        int[] arr = tmp.clone();
        long start = System.currentTimeMillis();
        optSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("优化冒泡2排序结束，耗时"+(end-start)+"ms");

        arr = tmp.clone();
        start = System.currentTimeMillis();
        sort(arr);
        end = System.currentTimeMillis();
        System.out.println("优化冒泡1排序结束，耗时"+(end-start)+"ms");

        arr = tmp.clone();
        start = System.currentTimeMillis();
        holyShitSort(arr);
        end = System.currentTimeMillis();
        System.out.println("不优化冒泡排序结束，耗时"+(end-start)+"ms");
    }

}
