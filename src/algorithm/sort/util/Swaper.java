package algorithm.sort.util;

/**
 * 数组元素交换方法
 * @Author yuc
 */
public class Swaper {

    /**
     * 常规交换数组中的两项
     * @param arr
     * @param i
     * @param j
     */
    public static void nor(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 使用异或的特性优化交换的空间复杂度（牺牲时间复杂度）
     * @param arr
     * @param i
     * @param j
     */
    public static void xor(int[] arr,int i,int j){
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

}
