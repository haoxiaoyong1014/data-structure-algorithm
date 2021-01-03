package cn.haoxiaoyong.data.structure.algorithm.sort;

/**
 * @author haoxiaoyong
 * @date created at 下午1:24 on 2020/12/22
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 */
public class BubbleSor {

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

            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        for (int k = 0; k < arr.length; k++)
            System.out.print(arr[k]);
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        //bubbleSort(arr);
        optimizationBubbleSort(arr, arr.length);
    }


}
