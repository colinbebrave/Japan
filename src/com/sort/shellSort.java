package com.sort;

public class shellSort {
    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(int[] arr)
    {
        if (arr == null || arr.length <= 1) return;
        for (int gap = arr.length / 2; gap >0; gap /= 2)
        {
            for (int i = 1; i < arr.length; i++)
            {
                int p = i;
                while (p - gap >= 0 && arr[p - gap] > arr[p])
                {
                    swap(arr, p, p - gap);
                    p -= gap;
                }
            }
        }
    }
    public static void main(String[] args)
    {
        int[] arr = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        sort(arr);
        for(int i: arr)
            System.out.println(i);
    }
}
