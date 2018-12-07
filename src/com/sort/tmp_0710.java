package com.sort;

import java.util.Random;

public class tmp_0710
{
    private static void insertSort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            int pivot = arr[i];
            int p = i;
            while (p > 0 && pivot < arr[p - 1])
            {
                arr[p] = arr[p - 1];
                p--;
            }
            arr[p] = pivot;
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {5, 2, 4 ,6, 1, 3};
        insertSort(arr);
        for(int i: arr)
            System.out.println(i);
    }
}