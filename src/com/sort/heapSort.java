package com.sort;

import java.util.Random;

public class heapSort
{
    private static void adjustHeap(int[] arr, int i, int length)
    {
        int temp = arr[i];
        for (int k = i*2 + 1; k < length; k = k * 2 + 1)
        {
            if (k + 1 < length && arr[k] < arr[k + 1])
                k++;
            if (temp < arr[k])
            {
                arr[i] = arr[k];
                i = k;
            }
            else
            {
                break;
            }
        }
        arr[i] = temp;//put temp to the final position
    }

    private static void sort(int[] arr)
    {
        //1.build the max-heap
        for (int i = arr.length /2 - 1; i >= 0; i--)
        {
            adjustHeap(arr, i , arr.length);
        }
        //2.adjust heap and swap the arr[0] with arr[j]
        for (int j = arr.length - 1; j > 0; j--)
        {
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
    }

    private static void swap(int[] arr, int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args)
    {
        Random ran = new Random();
        int n = 10;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = ran.nextInt();
        for (int i: arr)
            System.out.print(i + "  ");
        long startTime_3 = System.nanoTime();
        sort(arr);
        long endTime_3 = System.nanoTime();
        long duration_3 = (endTime_3 - startTime_3) / 1000000;
        System.out.println("running time of quickSort is: " + duration_3);
        for (int i: arr)
            System.out.print(i+ " ");
    }
}