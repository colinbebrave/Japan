package com.sort;

public class medianSelect {
    //find the median
    private static <T> Comparable<T> findMedium(Comparable<T>[] a)
    {
        return select1(a, a.length / 2);
    }

    //find the kth element, irrecursively
    private static <T> Comparable<T> select1(Comparable<T>[] a, int k)
    {
        int lo = 0, hi = a.length - 1;
        while (hi > lo)
        {
            int j = partition(a, lo, hi);
            if (j == k)
                return a[j];
            else if (j > k)
                hi = j - 1;
            else if (j < k)
                lo = j + 1;
        }
        return a[k];
    }

    private static <T> Comparable<T> select2(Comparable<T>[] a, int k, int lo, int hi)
    {
        int j = partition(a, lo, hi);
        if (j == k)
            return a[k];
        else if (j > k)
            return select2(a, k, lo, j - 1);
        else
            return select2(a, k, j + 1, hi);
    }

//    public static <T> Comparable<T>[] select3(Comparable<T>[] a, int lo, int hi)
//    {
//        int pivot = partition(a, lo, hi);
//        while (lo < hi)
//        {
//            select3(a, lo, pivot + 1);
//            select3(a, pivot - 1, hi);
//        }
//        return a;
//    }

    private static <T> int partition(Comparable<T>[] a, int lo, int hi)
    {
        int i = lo;
        Comparable<T> v = a[lo];//the first element is the pivot
        while(lo < hi)
        {
            while (lo < hi && less(v, a[hi]))//scan to the right
            //i capture the elements that are bigger than v
                hi--;
            while (lo < hi && less(a[lo], v))//scan to the left
            //j capture the elements that are smaller than v
                lo++;
            exch(a, lo, hi);
        }
        exch(a, lo, i);
        return lo;
    }

    private static <T> boolean less(Comparable<T> v, Comparable<T> w)
    {
        return v.compareTo((T) w) <= 0;
    }
    private static <T> void exch(Comparable<T>[] a, int i, int j)
    {
        Comparable<T> t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args)
    {
        String[] a = "qwertyuiopasdfghjklzxcvbnm".split("");
        System.out.println("The length of the array is: " + a.length);
        System.out.println("Max: "+ select1(a, 2));
        //System.out.println("Min: "+ select2(a, 25, 0, a.length - 1));
        //System.out.println("Medium: " + findMedium(a));
    }
}
