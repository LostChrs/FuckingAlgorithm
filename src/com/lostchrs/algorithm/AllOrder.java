package com.lostchrs.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列问题
 * 我们在高中的时候就做过排列组合的数学题，我们也知道 n 个不重复的数，全排列共有 n! 个。
 */
public class AllOrder {
    public void run() {
        solve(Arrays.asList(1, 2, 3, 4));
    }

    private void solve(List<Integer> list) {
        trackback(list, new LinkedList<>());
    }

    private void trackback(List<Integer> list, List<Integer> res) {
        if (res.size() >= list.size()) {
            //出结果
            System.out.println(res.toString());
            return;
        }

        //做选择
        for (int i = 0; i < list.size(); i++) {
            int data = list.get(i);
            if (!res.contains(data)) {
                res.add(data);
                trackback(list, res);
                res.remove(res.size() - 1);
            }
        }
    }
}
