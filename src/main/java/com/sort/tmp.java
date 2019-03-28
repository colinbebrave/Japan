package com.sort;

import java.util.Random;

public class tmp {
    private static void swap(int[] arr, int left, int right)
    {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
    private static int partition(int[] arr, int left, int right)
    {
        int pivot = arr[left];
        int p = left;
        while (left < right)
        {
            while (left < right && arr[right] >= pivot) right--;
            while (left < right && arr[left] <= pivot) left++;
            swap(arr, left, right);
        }
        swap(arr, p, left);
        return left;
    }

    private static int select_kth(int[] arr, int k, int length)
    {
        int left = 0, right = length - 1;
        while (left <= right)
        {
            int pi = partition(arr, left, right);
            if (pi > k) right = pi - 1;
            else if (pi < k) left = pi + 1;
            else
                return arr[pi];
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Random ran = new Random();
        int n = 10;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = ran.nextInt();
        System.out.println("Original array is : ");
        for (int i: arr)
            System.out.println(i);
        long startTime_3 = System.nanoTime();
        int length = arr.length;
        int a = select_kth(arr, 1, length);
        long endTime_3 = System.nanoTime();
        long duration_3 = (endTime_3 - startTime_3) / 1000000;
        System.out.println("running time of heapSort is: " + a);
        System.out.println("sorted array is: ");
        for(int j: arr)
            System.out.println(j);
    }
}
