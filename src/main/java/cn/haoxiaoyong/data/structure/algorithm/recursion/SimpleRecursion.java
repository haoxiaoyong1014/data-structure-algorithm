package cn.haoxiaoyong.data.structure.algorithm.recursion;

/**
 * @author haoxiaoyong
 * @date created at 下午1:15 on 2021/6/17
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 */
public class SimpleRecursion {


    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4};
        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);

            for (int j = arr.length - 1; j > 0; j--) {
                String str = arr[j] + "" + arr[i];
            }
        }


        // System.out.println(f(5));
    }


    static String fo(String val) {


        return "";

    }

    static int f(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        int j = f(n - 1);
        int k = f(n - 2);
        return j + k;

    }
}
