package algorithm.sort;

import algorithm.sort.util.Swaper;
import algorithm.sort.util.Tester;

/**
 * 插入排序
 * 时间复杂度：O(n^2)
 * @Author yuc
 */
public class Insert {

    public static void sort(int[] arr){
        for(int i=0;i<arr.length-1;++i){
            for(int j=i+1;j>0;--j){
                if(arr[j-1]>arr[j]){
                    Swaper.exec(arr,j-1,j);
                }else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] tmp = Tester.randomArr(100000);
        int[] arr = tmp.clone();
//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("插入排序结束，耗时" + (end - start) + "ms");
//        System.out.println(Arrays.toString(arr));
    }
}
