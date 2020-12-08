package cn.haoxiaoyong.data.structure.algorithm.array;

/**
 * @author haoxiaoyong
 * @date created at 上午10:32 on 2020/12/8
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * 数组反转
 * 空间复杂度O(1)/O(n)
 * 时间复杂度O(n)/O(2n)
 */
public class ReverseArray {

    //方式一
    //空间复杂度O(1),时间复杂度O(n) （不考虑初始化数组大小）

    public static void reverse(int n) {
        //初始化数组
        int[] arrs = initArr(n);

        int j = 0;
        for (; j < n; ++j) {
            int temp;
            temp = arrs[j];
            arrs[j] = arrs[n - 1 - j];
            arrs[n - 1 - j] = temp;
        }
    }

    //方式二
    //空间复杂度为O(n),时间复杂度O(2n) （不考虑初始化数组大小）
    public static void reverse() {
        int n = 100;
        //初始化数组
        int[] arrs = initArr(n);
        int[] ints = new int[n];

        int i = 0;
        for (; i < n; ++i) {
            ints[i] = arrs[n - 1 - i];
        }
        int j = 0;
        for (; j < n; ++j) {
            arrs[j] = ints[j];
        }

    }

    private static int[] initArr(int n) {
        int[] arr = new int[n];

        int i = 0;
        for (; i < n; ++i) {
            arr[i] = i;
        }
        return arr;
    }

    public static void main(String[] args) {
        //reverse(100);
        reverse();
    }

}
