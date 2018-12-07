package com.sort;

public class bubbleSort {
    public static void sort_1(int[] arr)
    {
        for (int end = arr.length - 1; end > 0; end--)
        {
            System.out.println("end: "+end);
            boolean changed = false;
            for(int index = 0; index < end; index++)
            {

                if(arr[index] > arr[index + 1])
                {
                    int t = arr[index + 1];
                    arr[index + 1] = arr[index];
                    arr[index] = t;
                    changed = true;
                }
            }
            if(!changed) return;
        }
    }

    public static void sort(int[] arr)
    {
        for (int end = 0; end < arr.length; end++)
        {
            System.out.println("end: "+end);
            for(int index = end + 1; index < arr.length; index++)
            {

                if(arr[index] < arr[end])
                {
                    int t = arr[index];
                    arr[index] = arr[end];
                    arr[end] = t;
                }
            }
        }
    }


    public static void main(String[] args)
    {
        int[] arr = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        sort(arr);
        System.out.println("end of sorting");
        for (int i: arr)
            System.out.println(i);
    }
}
