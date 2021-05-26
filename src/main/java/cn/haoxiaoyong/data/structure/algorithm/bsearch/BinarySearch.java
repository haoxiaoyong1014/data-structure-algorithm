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

    static int spinBinarySearch(int[] arr, int value) {

        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (arr[mid] > value) {
                low = mid + 1;
            } else if (arr[mid] < value) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        if (arr[mid] > value) {
            int low2 = 0;
            int highNew = mid;
            Integer mid2 = getMid(arr, value, low2, highNew);
            if (mid2 != null) return mid2;
        } else {
            int low2 = mid;
            int highNew = arr.length - 1;
            Integer mid2 = getMid(arr, value, low2, highNew);
            if (mid2 != null) return mid2;
        }

        return -1;
    }

    static int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return -1;
        int left = 0, right = len - 1;
        // 1. 首先明白，旋转数组后，从中间划分，一定有一边是有序的。
        // 2. 由于一定有一边是有序的，所以根据有序的两个边界值来判断目标值在有序一边还是无序一边
        // 3. 这题找目标值，遇到目标值即返回
        // 4. 注意：由于有序的一边的边界值可能等于目标值，所以判断目标值是否在有序的那边时应该加个等号(在二分查找某个具体值得时候如果把握不好边界值，可以再每次查找前判断下边界值，也就是while循环里面的两个if注释)
        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            // 右边有序
            if (nums[mid] < nums[right]) {
                // 目标值在右边
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                    // 目标值在左边
                } else {
                    right = mid - 1;
                }
                // 左边有序
            } else {
                // 目标值在左边
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                    // 目标值在右边
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    private static Integer getMid(int[] arr, int value, int low2, int highNew) {
        while (low2 <= highNew) {
            int mid2 = (low2 + highNew) / 2;

            if (arr[mid2] > value) {
                highNew = mid2 - 1;
            } else if (arr[mid2] < value) {

                low2 = mid2 + 1;
            } else {
                return mid2;
            }
        }
        return null;
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
       /* int lastLessThanOrEqArr[] = {1, 3, 4, 5, 5, 7, 9, 9, 11, 12};
        System.out.println(lastLessThanOrEqBinarySearch(lastLessThanOrEqArr, 5));*/

        //目前是存在很大的问题
        int arr[] = {5, 6, 7, 9, 11, 12, 0, 1, 2, 4};
        System.out.println(search(arr, 4));

    }
}
