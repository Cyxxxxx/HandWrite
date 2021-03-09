package algorithm.string;

import java.util.Arrays;

public class KMP {

    public static int idxOf(String s1, String s2) {
        int i = 1, j = 1;
        int[] next = new int[s2.length() + 1];
        getNext(s2, next);
        System.out.println(Arrays.toString(next));
        while (i <= s1.length() && j <= s2.length()) {
            /**
             * 逐个比对字符：
             *   当字符相等时继续比对
             *   当字符不相等的时候，让 j 回退到 next[j] 继续比对
             */
            if (j == 0 || s1.charAt(i-1) == s2.charAt(j-1)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        /**
         * ++j 最后会大于s2的长度
         * 用i的位置 - 1（因为 i 初始化为1）- s2长度即得模式串首次出现的索引
         */
        if(j>s2.length()){
            return i-s2.length()-1;
        }else {
            return -1;
        }
    }

    public static void getNext(String s, int[] next) {
        int len = s.length();
        int i = 1, j = 0;
        while (i < len) {
            /** 用 i 遍历字符串
             *  i = 2 时，取 s 的第一个字符，无前缀后缀，前缀/后缀数 = 0，next[2] = 0 + 1 = 1;
             *  i = 3 时，取 s 的前两个字符，若s[0]!=s[1]，前缀/后缀数 = 0，next[3] = 0 + 1 = 1,
             *  若s[0] = s[1]，前缀/后缀数 = 1，next[3] = 1 + 1 = 2;
             *  i = 4 时，取 s 的前三个字符，由于s[0]和s[1]比较过，将s[0]与s[2]比较，得到next[4]
             *  以此类推
             **/
            if (j == 0 || s.charAt(i - 1) == s.charAt(j - 1)) {
                ++i;
                next[i] = ++j;
            } else {
                j = next[j];
            }
        }
    }

    /**
     * String类中的indexOf
     * 朴素模式匹配
     *
     * @param source
     * @param target
     * @return
     */
    public static int indexOf(char[] source, char[] target) {
        int sourceCount = source.length;
        int targetCount = target.length;
        char first = target[0];
        int max = sourceCount - targetCount;

        for (int i = 0; i <= max; i++) {
            /* 快速匹配 target[0] 在 source 串中的位置 */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            /* 对齐了第一个字符后, 对余下字符进行匹配 */
            if (i <= max) {
                int j = i + 1;
                int end = i + targetCount;
                for (int k = 1; j < end && source[j] == target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "googogooglegooglo";
        String s2 = "google";
        System.out.println(idxOf(s1, s2));
//        System.out.println(indexOf(s1.toCharArray(), s2.toCharArray()));
    }

}
