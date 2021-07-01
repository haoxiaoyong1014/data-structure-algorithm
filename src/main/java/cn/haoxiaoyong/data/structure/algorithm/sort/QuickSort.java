package cn.haoxiaoyong.data.structure.algorithm.sort;

import java.util.Arrays;

/**
 * @author haoxiaoyong on 2021/1/17 下午 4:35
 * e-mail: hxyHelloWorld@163.com
 * github: https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 * 快速排序
 */
public class QuickSort {

    /**
     * 把一个数组切分成两个子数组的基本思想：
     * 1.找一个基准值，用两个指针分别指向数组的头部和尾部；
     * 2.先从尾部向头部开始搜索一个比基准值小的元素，搜索到即停止，并记录指针的位置；
     * 3.再从头部向尾部开始搜索一个比基准值大的元素，搜索到即停止，并记录指针的位置；
     * 4.交换当前左边指针位置和右边指针位置的元素；
     * 5.重复2,3,4步骤，直到左边指针的值大于右边指针的值停止。
     */
    private static void quickSort(int[] arr, int n) {

        //用两个指针分别指向数组的头部和尾部
        int head = 0;
        int tail = n - 1;
        sort(arr, head, tail);

    }

    private static void sort(int[] arr, int head, int tail) {
        if (head >= tail) {
            return;
        }

        //定义2个指针，一个是左指针，一个是右指针

        int key = arr[head];
        int left = head;
        int right = tail + 1;
        //定义一个基准数
        while (true) {
            //1: 从右开始向左移动，移动right指针，找到比基准值小的
            while (/*less(key, arr[--right])*/key < arr[--right]) {
                //从最右边移动到了最左边还是没有找到就跳出循环
                if (right == head) {
                    break;
                }
            }

            //2:从左开始向右移动，移动left指针，找到比基准值大的
            while (/*less(arr[++left], key)*/key > arr[++left]) {
                //从最左边移动到了最右边还是没有找到就跳出循环
                if (left == tail) {
                    break;
                }
            }
            //3:判断 left>=right,如果是，则证明元素扫描完毕，结束循环，如果不是，则交换元素即可
            if (left >= right) {
                break;
            } else {
                int tmp = arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;
                //exch(arr, left, right);
            }
        }


        //4:最后将基准值进行移动
        int tmp = arr[head];
        arr[head] = arr[right];
        arr[right] = tmp;
        //交换分界值
        //exch(arr, head, left);

        //以基准值把一个数组切分成2个数组。然后分别对两个数组按照相同的规则进行切分
        //左子组
        sort(arr, head, right - 1);
        //右子组
        sort(arr, right + 1, tail);
    }

    public static void main(String[] args) {
        int a[] = {6, 1, 2, 7, 9, 3, 4, 5, 8};
        //int a[] = {6, 1, 2, 7, 3, 5};
        //quickSort(a, a.length);
        //quickSort(a, 0, a.length - 1);
        quickSort_3(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /*
     比较v元素是否小于w元素
  */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    /**
     * 快速排序_2刷
     */

    public static void quickSort(int[] arr, int start, int end) {
        //递归终止条件
        if (start < end) {
            //首先找到一个基准值，一般都是数组的第一个
            int standard = arr[start];

            int low = start;

            int high = end;

            while (low < high) {

                //然后从右边开始遍历，找到比基准值小的值
                while (low < high && standard <= arr[high]) {
                    high--;
                }

                arr[low] = arr[high];
                //从左边开始遍历，找到一个比基准值大的值
                while (low < high && standard >= arr[low]) {
                    low++;
                }
                arr[high] = arr[low];

            }

            arr[low] = standard;

            quickSort(arr, start, low);

            quickSort(arr, low + 1, end);

        }

    }

    /**
     * 再刷
     * <p>
     * p 表示头元素下标
     * <p>
     * r 表示数组长度
     *
     * @param arr
     */

    public static void quickSort_3(int arr[], int p, int r) {
        if (p >= r) return;
        // 找到一个基准值
        int q = partition(arr, p, r);

        quickSort_3(arr, p, q - 1);
        quickSort_3(arr, q + 1, r);

    }

    static int partition(int arr[], int p, int r) {

        //首先取最后一个值当基准值
        int pivot = arr[r];

        //定义两个指针 i j;

        int i = p;
        for (int j = p; j < r; ++j) {
            if (arr[j] < pivot) {
                // arr[i] 和arr[j]进行交换
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                ++i;
            }

        }

        int tmp = arr[r];
        arr[r] = arr[i];
        arr[i] = tmp;
        return i;
    }
}
