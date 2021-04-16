package cn.haoxiaoyong.data.structure.algorithm.sort;

import java.util.Arrays;

/**
 * @author haoxiaoyong
 * @date created at 下午3:58 on 2020/12/22
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * 插入排序
 */
public class InsertionSort {


    //个人觉得这个空间复杂度会高，而optimizationInsertionSort方法 没有用中间变量
    public static void insertionSort(int arr[], int n) {

        for (int i = 1; i < n; i++) {
            int value = arr[i];
            for (int j = i; j > 0; j--) { //有序的
                if (value < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = value;
                    arr[j] = temp;

                } else {
                    break;
                }
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    // 插入排序，a表示数组，n表示数组大小
    public static void optimizationInsertionSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 1; i < n; ++i) { //无序的
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {  //有序的，拿无序的和有序的进行比较,满足就进行交换
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
        System.out.println(Arrays.toString(a));
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 3, 2};
        //insertionSort(arr, arr.length);
        //optimizationInsertionSort(arr, arr.length);
        //insertionSort2(arr);
        insertionSortSuperior(arr);

    }


    /**
     * 20210416
     * 插入排序_2刷
     * 1.分为已排序区和未排序区
     * 2.初始默认第一个元素为已排序区，第一个元素之后的元素为未排序区
     * 3，拿未排序的区域和已经排序的区域进行比较
     */

    public static void insertionSort2(int[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; ++i) {

            for (int j = i - 1; j >= 0; --j) {

                if (arr[j] > arr[j + 1]) {

                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 20210416
     * 优化插入排序_2刷
     * <p>
     * 整体分成2个步骤，
     * 1： 移动数据
     * 2： 交换数据
     */

    public static void insertionSortSuperior(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; ++i) {

            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; --j) {

                if (arr[j] > value) {
                    //移动数据
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            //插入数据
            arr[j + 1] = value;
        }
        System.out.println(Arrays.toString(arr));
    }
}
