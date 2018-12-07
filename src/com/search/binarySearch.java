package com.search;

public class binarySearch {
    /**
     * 分别使用递归和迭代两种方式实现
     * @param arr 有序数组
     * @param key 待查找的关键字
     * @return 找到的位置
     */

    private static int recursivelyBinarySearch(int[] arr, int key, int start ,int end)
    {
        if (key < arr[start] || key > arr[end] || start > end)
            return -1;
        int middle = (start + end) / 2;
        if (arr[middle] > key)
            return recursivelyBinarySearch(arr, key, start, middle - 1);
        else if (arr[middle] < key)
            return recursivelyBinarySearch(arr, key, middle + 1, end);
        else
            return middle;
    }

    private static int iterativelyBinarySearch(int[] arr, int key, int start, int end)
    {
        if (key < arr[start] || key > arr[end] || start > end)
            return -1;
        int middle;
        while (start <= end)
        {
            middle = (start + end) / 2;
            if (arr[middle] < key)
            {
                start = middle + 1;
            }
            else if (arr[middle] > key)
                end = middle - 1;
            else
            {
                return middle;
            }
        }
        return -1;
    }
}
