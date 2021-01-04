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


    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a, int n) {
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

    //个人觉得这个空间复杂度会高，而insertionSort方法 没有用中间变量
    public static void insertion(int arr[], int n) {

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

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 3, 2};
        insertionSort(arr, arr.length);
        //insertion(arr,arr.length);
    }
}
