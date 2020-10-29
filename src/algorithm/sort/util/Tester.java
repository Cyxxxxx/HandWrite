package algorithm.sort.util;

/**
 * 排序算法 - 测试用例生成
 */
public class Tester {

    /**
     * 随机数组生成
     * @param n 生成的数组大小
     * @return
     */
    public static int[] randomArr(int n){
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int random = (int) (n * Math.random());
            int temp = result[i];
            result[i] = result[random];
            result[random] = temp;
        }
        return result;
    }
}
