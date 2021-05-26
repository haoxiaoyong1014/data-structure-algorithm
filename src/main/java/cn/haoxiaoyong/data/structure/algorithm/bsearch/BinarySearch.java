package cn.haoxiaoyong.data.structure.algorithm.bsearch;

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
     *
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


    /**
     * 查找第一个值等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    static int firstBinarySearch(int[] arr, int value) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }


    /**
     * 查询最后一个值等于给定值的元素下标位置
     *
     * @param arr
     * @param value
     */
    static int lastBinarySearch(int[] arr, int value) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    static int firstGrOrEqBinarySearch(int[] arr, int value) {

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= value) {
                if (mid == 0 || arr[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (arr[mid] <= value) {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    static int lastLessThanOrEqBinarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] <= value) {

                if (mid == arr.length - 1 || arr[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        //简单查找
        /*int arr[] = {8, 11, 19, 23, 27, 33, 45, 55, 67, 98};
        System.out.println(binarySearch(arr, 8));*/


        //查找第一个值等于给定值的元素
        /*int firstArr[] = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        System.out.println(firstBinarySearch(firstArr, 8));*/

        //查找最后一个值等于给定值的元素
      /*  int lastArr[] = {1, 3, 4, 5, 6, 8, 8, 8, 8, 8, 18, 20};
        System.out.println(lastBinarySearch(lastArr, 8));*/

        //查找第一个大于等于给定值的元素
        /*int firstGrOrEqArr[] = {1, 3, 4, 5, 7, 9, 11};
        System.out.println(firstGrOrEqBinarySearch(firstGrOrEqArr, 10));*/

        //查找最后一个小于等于给定的元素
        int lastLessThanOrEqArr[] = {1, 3, 4, 5, 5, 7, 9, 9, 11, 12};
        System.out.println(lastLessThanOrEqBinarySearch(lastLessThanOrEqArr, 5));

    }
}
