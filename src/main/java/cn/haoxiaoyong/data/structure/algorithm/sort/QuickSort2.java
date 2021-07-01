package cn.haoxiaoyong.data.structure.algorithm.sort;

import java.util.Arrays;

/**
 * @author haoxiaoyong on 2021/6/20 下午 10:33
 * e-mail: hxyHelloWorld@163.com
 * github: https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 * <p>
 * 快排在刷
 */
public class QuickSort2 {

    public static void main(String[] args) {

        int a[] = {3, 7, 9, 5, 4, 1, 6};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    static void quickSort(int a[], int p, int r) {

        if (p >= r) {
            return;
        }

        int q = selectBenchmark(a, p, r);

        quickSort(a, p, q-1);
        quickSort(a, q + 1, r);

    }

    static int selectBenchmark(int arr[], int p, int r) {

        int i = p;
        int pivot = arr[r];

        for (int j = p; j < r; j++) {

            if (arr[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                    i++;
                }
            }
        }

        int tmp = arr[r];
        arr[r] = arr[i];
        arr[i] = tmp;
        return i;
    }
}
