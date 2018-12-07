package com.sort;

public class binaryInsertSort {
    public static void sort(int[] arr)
    {
        if(arr == null || arr.length <= 1) return;
        for (int i = 1; i < arr.length; i++)
        {
            int temp = arr[i];
            int start = 0, end = i;
            while (start < end)
            {
                int mid = start + (end - start) / 2;
                if(arr[mid] <= temp)
                    start = mid + 1;
                else
                    end = mid;
            }
            int p = i;
            while (p > end)
            {
                arr[p] = arr[p - 1];
                --p;
            }
            arr[p] = temp;
        }
    }

    public static void main(String[] args)
    {
        int[] a = {5, 4, 3, 2, 1};
        //sort(a);
        for(int i: a)
            System.out.println(i);
        System.out.println(1 /2);
        System.out.println(a[1]);
    }
}
