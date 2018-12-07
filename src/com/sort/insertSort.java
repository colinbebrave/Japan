package com.sort;

public class insertSort {
    public static void sort(int[] arr)
    {
        if(arr == null || arr.length <= 1)
            return;
        for (int i = 1; i < arr.length; i++)
        {
            int p = i;
            int temp = arr[p];
            while (p > 0 && arr[p - 1] > temp)
            {
                arr[p] = arr[p - 1];
                p--;
            }
            arr[p] = temp;
        }
    }

    public static void main(String[] args)
    {
        int[] a = {5, 4, 3, 2, 1};
        sort(a);
        for(int i: a)
            System.out.print(i);
    }
}
