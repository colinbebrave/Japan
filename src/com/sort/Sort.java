package com.sort;
import java.util.Random;

public class Sort {
    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void swap(int[] a, int i, int j)
    {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static int partition(int[] arr, int start, int end)
    {
        int pivot = arr[start];
        int pi = start;

        while (start < end)
        {
            while (start < end && arr[end] >= pivot)
                end--;
            while (start < end && arr[start] <= pivot)
                start++;
            swap(arr, start, end);
        }
        swap(arr, pi, start);
        return start;
    }

    private static void quickSort(int[] arr, int start, int end)
    {
        if (start > end) return;
        int pi = partition(arr, start, end);
        quickSort(arr,start, pi - 1);
        quickSort(arr, pi + 1, end);
    }

    private static void sort(int[] arr)
    {
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1);
    }


    public static void bubbleSort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length - i; j++)
            {
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static void shellSort(Comparable[] arr)
    {
        if (arr == null || arr.length <= 1) return;
        int gap = arr.length / 2;
        while (gap > 0)
        {
            for (int i = 1; i < arr.length; i++)
            {
                Comparable temp = arr[i];
                int p = i;
                while (p >= gap && less(temp, arr[p - gap]))
                {
                    arr[p] = arr[p - gap];
                    p -= gap;
                }
                arr[p] = temp;
            }
            gap /= 2;
        }
    }

    public static void main(String[] args)
    {
        Random ran = new Random();
        int n = 20;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = ran.nextInt(n);
//        int[] arr_1 = {29, 31, 57, 83, 29, 30, 41, 57, 29, 28, 59, 30, 29, 10, 50, 41, 51,91, 85, 74, 3, 93};
//        int[] arr_2 = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
//        int[] arr = { 54, 31, 89, 33, 66, 12, 68, 20 };
        System.out.println("the array before sorting: ");
//        for (int i: arr)
//            System.out.println(i + " ");


        //System.out.println("---------------Comparing running time for: "+n+"--------------");

//        long startTime_1 = System.nanoTime();
//        bubbleSort(arr);
//        long endTime_1 = System.nanoTime();
//        long duration_1 = (endTime_1 - startTime_1) / 1000000;
//        System.out.println("running time of bubbleSort is: " + duration_1);

        long startTime_3 = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long endTime_3 = System.nanoTime();
        long duration_3 = (endTime_3 - startTime_3) / 1000000;
        System.out.println("running time of quickSort is: " + duration_3);
        for(Comparable i: arr)
            System.out.print(i+" ");

//        Comparable[] arr_2 = new Comparable[n];
//        for (int i = 0; i < n; i++)
//            arr_2[i] = ran.nextInt(n);
//
//        long startTime_5 = System.nanoTime();
//        shellSort(arr_2);
//        long endTime_5 = System.nanoTime();
//        long duration_5 = (endTime_5 - startTime_5) / 1000000;
//        System.out.println("running time of shellSort is: " + duration_5);


//
//        System.out.println();
//        System.out.println("the array after sorting: ");
//        for (int i: arr)
//            System.out.print(i + " ");
    }
}
