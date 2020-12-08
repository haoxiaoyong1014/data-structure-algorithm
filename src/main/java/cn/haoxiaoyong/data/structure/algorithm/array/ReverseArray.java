package cn.haoxiaoyong.data.structure.algorithm.array;

/**
 * @author haoxiaoyong
 * @date created at 上午10:32 on 2020/12/8
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * 数组反转 空间复杂度O(1)
 */
public class ReverseArray {

    public static void reverse(int n) {

        int[] arr = new int[n];

        int i = 0;
        for (; i < n; ++i) {
            arr[i] = i;
        }
        int j = 0;
        for (; j < n; ++j) {
            int temp;
            temp = arr[j];
            arr[j] = arr[n - 1 - j];
            arr[n - 1 - j] = temp;
        }
    }

    public static void main(String[] args) {
        reverse(100);

    }

}
