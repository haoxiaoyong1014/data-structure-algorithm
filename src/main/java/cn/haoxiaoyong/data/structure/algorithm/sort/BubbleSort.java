package cn.haoxiaoyong.data.structure.algorithm.sort;

import java.util.Arrays;

/**
 * @author haoxiaoyong
 * @date created at 下午1:24 on 2020/12/22
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int k = 0; k < arr.length; k++)
            System.out.print(arr[k]);
    }


    //优化冒泡排序，arr 表示数组，n表示数组大小

    public static void optimizationBubbleSort(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true; // 表示有数据交换
                }
            }
            if (!flag) {
                break;  // 没有数据交换，提前退出
            }
        }

        System.out.print(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        //bubbleSort(arr);
        //optimizationBubbleSort(arr, arr.length);
        //bubbleSort2(arr);
        bubbleSortSuperior(arr);
    }


    /**
     * 20210416
     * 冒泡排序_2刷
     */

    public static void bubbleSort2(int[] arr) {

        int n = arr.length;
        //外层表示循环的总次数
        for (int i = 0; i < n; ++i) {
            //n-i 表示已经循环了多少次，也就是已经有多少个有序的元素了，
            // -1表示不能到最头，也就是倒数第二个元素和倒数第一个元素去比较就可以了
            for (int j = 0; j < n - i - 1; ++j) {
                //就行交换
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    /**
     *  20210416
     * 优化 冒泡排序_2刷
     */

    public static void bubbleSortSuperior(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; ++i) {

            //这个标志主要是为了所有的已经有序了之后就不需要在此进行循环了；
            boolean flag = false;

            for (int j = 0; j < n - i - 1; ++j) {

                //比较交换
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];

                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
