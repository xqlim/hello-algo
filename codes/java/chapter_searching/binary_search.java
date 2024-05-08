/**
 * File: binary_search.java
 * Created Time: 2022-11-25
 * Author: krahets (krahets@163.com)
 */

package chapter_searching;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class binary_search {
    /* 二分查找（双闭区间） */
    static int binarySearch(int[] nums, int target) {
        // 初始化双闭区间 [0, n-1] ，即 i, j 分别指向数组首元素、尾元素
        int i = 0, j = nums.length - 1;
        // 循环，当搜索区间为空时跳出（当 i > j 时为空）
        while (i <= j) {
            int m = i + (j - i) / 2; // 计算中点索引 m
            if (nums[m] < target) // 此情况说明 target 在区间 [m+1, j] 中
                i = m + 1;
            else if (nums[m] > target) // 此情况说明 target 在区间 [i, m-1] 中
                j = m - 1;
            else // 找到目标元素，返回其索引
                return m;
        }
        // 未找到目标元素，返回 -1
        return -1;
    }

    /* 二分查找（左闭右开区间） */
    static int binarySearchLCRO(int[] nums, int target) {
        // 初始化左闭右开区间 [0, n) ，即 i, j 分别指向数组首元素、尾元素+1
        int i = 0, j = nums.length;
        // 循环，当搜索区间为空时跳出（当 i = j 时为空）
        while (i < j) {
            int m = i + (j - i) / 2; // 计算中点索引 m
            if (nums[m] < target) // 此情况说明 target 在区间 [m+1, j) 中
                i = m + 1;
            else if (nums[m] > target) // 此情况说明 target 在区间 [i, m) 中
                j = m;
            else // 找到目标元素，返回其索引
                return m;
        }
        // 未找到目标元素，返回 -1
        return -1;
    }

    /** 升序数组*/
    static int binarySearchAsc(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while (right >= left){
            int mod = (right - left) / 2;
            if (nums[mod] == target){
                return mod;
            } else if (nums[mod] < target){
                left = mod + 1;
            } else if (nums[mod] > target){
                right = mod - 1;
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        int target = 6;
        int[] nums = { 1, 3, 6, 8, 12, 15, 23, 26, 31, 35 };

        /* 二分查找（双闭区间） */
//        int index = binarySearch(nums, target);
//        System.out.println("目标元素 6 的索引 = " + index);

        /* 二分查找（左闭右开区间） */
        int index = removeVal(nums, target);
        int worldLength = worldLength("   fly me   to   the moon  ");
        System.out.println(worldLength);
        //
//        int i = strStr("hello", "ll");
//        System.out.println(i);
        //bootstrap
        String pathBoot = System.getProperty("sun.boot.class.path");
        System.out.println(pathBoot.replaceAll(";",System.lineSeparator()));
        //extension
        String pathExt = System.getProperty("java.ext.dirs");
        System.out.println("-------------------------------------");
        System.out.println(pathExt.replaceAll(";",System.lineSeparator()));
        //AppClassLoad
        String pathApp = System.getProperty("java.class.path");
        System.out.println("-------------------------------------");
        System.out.println(pathApp.replaceAll(";",System.lineSeparator()));

        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("giscus.json");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream);
        byte[] buffer = new byte[1024];
        int bytesRead;

        try {
            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                System.out.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {

            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 28. 找出字符串中第一个匹配项的下标
     * 简单
     * 相关标签
     * 相关企业
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：haystack = "sadbutsad", needle = "sad"
     * 输出：0
     * 解释："sad" 在下标 0 和 6 处匹配。
     * 第一个匹配项的下标是 0 ，所以返回 0 。
     * 示例 2：
     *
     * 输入：haystack = "leetcode", needle = "leeto"
     * 输出：-1
     * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
     *
     */
    public static int strStr(String haystack, String needle) {

        char[] charArray = haystack.toCharArray();
        if (haystack.contains(needle)){
//            for (int i = 0; i < charArray.length; i++) {
//
//                char[] charArray1 = needle.toCharArray();
//                for (int j = 0; j < charArray1.length; j++) {
//                    if (charArray[i] == charArray1[j]){
//                        return j;
//                    }
//                }
//            }
            int i = haystack.indexOf(needle)-needle.length();
            return i;
        }

        return -1;


    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     *
     *
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2]
     * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
     */
    /* 双指针*/
    public static int removeVal(int[] nums, int val) {

        int slow = 0; // 慢指针，用于记录不等于val的元素的位置
        int fast = 0; // 快指针，用于遍历数组

        while (fast < nums.length) {
            if (nums[fast] != val) { //不等于val
                nums[slow++] = nums[fast]; // 记录不等于val的元素
            }
            fast++;
        }
        System.out.printf("新元素:%s%n", Arrays.toString(nums));
        System.out.println("新元素的长度:"+slow);

        return slow; // 返回新数组的长度

    }

    /**
     * 58. 最后一个单词的长度
     * 简单
     * 相关标签
     * 相关企业
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     *
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     */
    static int worldLength(String s) {

        // 去除字符串末尾的空格
        while (s.charAt(s.length() - 1) == ' ') {
            s = s.substring(0, s.length() - 1);
        }

        // 寻找最后一个单词的起始位置
        int start = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                start = i;
                break;
            }
        }

        // 计算最后一个单词的长度
        int length = start + 1;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                break;
            }
            length++;
        }

        return length;

    }

}
