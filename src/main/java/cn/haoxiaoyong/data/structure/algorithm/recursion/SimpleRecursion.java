package cn.haoxiaoyong.data.structure.algorithm.recursion;

/**
 * @author haoxiaoyong
 * @date created at 下午1:15 on 2021/6/17
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 */
public class SimpleRecursion {


    public static void main(String[] args) {

        System.out.println(f(5));
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
