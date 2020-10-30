package algorithm.sort;

import algorithm.sort.util.Swaper;
import algorithm.sort.util.Tester;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @Author yuc
 */
public class Shell {

    public static void sort(int[] arr) {
        int len = arr.length;
        int incr = len;
        while(incr>1){
            // 每趟希尔排序，都让增量的值折半
            incr/=2;
            /**
             * 分组：如增量incr为3，则一个大小为10的数组可以分为
             * arr[0], arr[3], arr[6], arr[9]
             * arr[1], arr[4], arr[7]
             * arr[2], arr[5], arr[8]
             * 然后相当于分别对每组使用直接插入排序
             */
            for(int i=incr;i<len;++i){
                if(arr[i]<arr[i-incr]){
                    for(int j=i;j>=incr && arr[j]<arr[j-incr];j-=incr){
                        Swaper.exec(arr,j,j-incr);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 100;
        int[] tmp = Tester.randomArr(n);
        int[] arr = tmp.clone();
        System.out.println("对有" + n + "个元素的随机数组进行排序：");
        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("插入排序结束，耗时" + (end - start) + "ms");

        System.out.println(Arrays.toString(arr));
    }

}
