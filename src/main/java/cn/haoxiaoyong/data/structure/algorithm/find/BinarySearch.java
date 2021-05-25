package cn.haoxiaoyong.data.structure.algorithm.find;

/**
 * @author haoxiaoyong
 * @date created at 下午6:12 on 2021/5/25
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 * 二分查找
 */
public class BinarySearch {


    /**
     * 二分查找，返回指定值对应的索引
     * @param arr
     * @param value
     * @return
     */
    static int binarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        //注意这里是小于等于，不然当查询临界值8的时候会出现错误
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {

                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {8, 11, 19, 23, 27, 33, 45, 55, 67, 98};

        System.out.println(binarySearch(arr, 8));
    }
}
