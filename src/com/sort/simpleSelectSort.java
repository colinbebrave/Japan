package com.sort;

public class simpleSelectSort {
    public static void sort(int[] arr)
    {
        if(arr == null || arr.length <= 1)
            return;
        for(int i = 0; i < arr.length; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {49, 38, 65, 97, 76, 13, 27};
        sort(arr);
        for(int i: arr)
            System.out.println(i);
    }
}
