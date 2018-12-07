package com.sort;
/*
https://www.cnblogs.com/chengxiao/p/6194356.html
*/
import java.util.Random;

public class mergeSort {

    private static void sort(int[] arr)
    {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right)
    {
        if (left < right)
        {
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left ,mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right)
    {
        int[] temp = new int[arr.length];
        int i = left;//pointer for left array
        int j = mid + 1;//pointer for right array
        int t = 0;//pointer for temporary array
        while (i <= mid && j <= right)
        {
            if (arr[i] <= arr[j])
                temp[t++] = arr[i++];
            else
                temp[t++] = arr[j++];
        }
        while (i <= mid)
            temp[t++] = arr[i++];
        while (j <= right)
            temp[t++] = arr[j++];

        t = 0;
        while (left <= right)
            arr[left++] = temp[t++];
    }

    public static void main(String[] args)
    {
        Random ran = new Random();
        int n = 20;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = ran.nextInt();
        sort(arr);
        for(int j: arr)
            System.out.println(j);
    }
}
