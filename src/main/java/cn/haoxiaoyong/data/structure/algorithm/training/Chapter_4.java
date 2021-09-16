package cn.haoxiaoyong.data.structure.algorithm.training;

import java.util.LinkedList;

/**
 * @author haoxiaoyong
 * @date created at 上午10:10 on 2021/9/16
 * @github https://github.com/haoxiaoyong1014
 * @blog www.haoxiaoyong.cn
 */
public class Chapter_4 {

    private int v;
    private LinkedList<Integer> adj[];

    public Chapter_4(int v) {
        this.v = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; ++i) {

            adj[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {

        Chapter_4 chapter_4 = new Chapter_4(8);
        System.out.println(chapter_4);
    }
}
