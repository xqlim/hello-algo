/**
 * File: binary_search_recur.java
 * Created Time: 2023-07-17
 * Author: krahets (krahets@163.com)
 */

package chapter_divide_and_conquer;

import utils.ListNode;

import java.util.Arrays;

public class binary_search_recur {
    /* 二分查找：问题 f(i, j) */
    static int dfs(int[] nums, int target, int i, int j) {
        // 若区间为空，代表无目标元素，则返回 -1
        if (i > j) {
            return -1;
        }
        // 计算中点索引 m
        int m = (i + j) / 2;
        if (nums[m] < target) {
            // 递归子问题 f(m+1, j)
            return dfs(nums, target, m + 1, j);
        } else if (nums[m] > target) {
            // 递归子问题 f(i, m-1)
            return dfs(nums, target, i, m - 1);
        } else {
            // 找到目标元素，返回其索引
            return m;
        }
    }

    /* 二分查找 */
    static int binarySearch(int[] nums, int target) {
        int n = nums.length;
        // 求解问题 f(0, n-1)
        return dfs(nums, target, 0, n - 1);
    }

    public static void main(String[] args) {
//        int target = 6;
//        int[] nums = { 1, 3, 6, 8, 12, 15, 23, 26, 31, 35 };
//
//        // 二分查找（双闭区间）
//        int index = binarySearch(nums, target);
//        System.out.println("目标元素 6 的索引 = " + index);
//        System.out.println((1<<3));
//        System.out.println(divide(2, 2));
//        int[] ints = twoSum(new int[] {2, 7, 11, 15}, 9);
//        int[] ints1 = twoSum(new int[] {3,3}, 6);
//        System.out.println(Arrays.toString(ints));
//        System.out.println(Arrays.toString(ints1));

//        int i = 5 * 2;
//        ListNode listNode = new ListNode();

        System.out.println(replaceStr(new StringBuffer("we are friends")));
    }



    // 字符串替换
    public static String replaceStr(StringBuffer str){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(" ")){
                sb.append("20%");
            }else {
                sb.append(str.charAt(i));
            }

        }
        return sb.toString();
    }


    public static int[]  twoSum(int[] nums,int target){

        int[] index = new int[2];
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (sub == nums[j]) {
                    index[0] = i;
                    index[1] = j;
                }
            }


        }

        return index;
    }

    public static int divide(int a, int b) {
        int sign = 1;
        if ((a < 0) != (b < 0)) {
            sign = -1;
        }
        long x = abs(a);
        long y = abs(b);
        long tot = 0;
        while (x >= y) {
            int cnt = 0;
            while (x >= (y << (cnt + 1))) {
                cnt++;
            }
            tot += 1L << cnt;
            x -= y << cnt;
        }
        long ans = sign * tot;
        if (ans >= Integer.MIN_VALUE && ans <= Integer.MAX_VALUE) {
            return (int) ans;
        }
        return Integer.MAX_VALUE;
    }

    private static long abs(long a) {
        if (a < 0) {
            return -a;
        }
        return a;
    }


}
