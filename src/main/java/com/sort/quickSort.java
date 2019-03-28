package com.sort;
import java.util.Random;

public class quickSort {
    private static void swap(int[] arr, int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    private static int partition(int[] arr, int left, int right)
    {
        int pivot = arr[left];
        int p = left;
        while (left < right)
        {
            while (left < right && arr[right] >= pivot) right--;
            while (left < right && arr[left] <= pivot) left ++;
            swap(arr, left, right);
        }
        swap(arr, left, p);
        return left;
    }

    private static void quickSort(int[] arr, int left, int right)
    {
        if (left > right || arr.length == 0) return;
        int pi = partition(arr, left, right);
        quickSort(arr, left, pi - 1);
        quickSort(arr, pi + 1, right);
    }

    private static void quickSort(int[] arr)
    {
        if (arr.length == 0) return;
        int left = 0;
        int right = arr.length - 1;
        quickSort(arr, left, right);
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
        quickSort(arr);
        long endTime_3 = System.nanoTime();
        long duration_3 = (endTime_3 - startTime_3) / 1000000;
        System.out.println("running time of quickSort is: " + duration_3);
        System.out.println("sorted array is: ");
        for(int j: arr)
            System.out.println(j);
    }
}
