/*
 *PID: 6169881
 */

import java.util.Random;

public class SearchingAlgorithms
{
    private static int list[];

    public static int[] getList()
    {
        return list;
    }

    public static void setList(int length)
    {
        list = new int[length];
    }

    public static void fillArray(int[] list)
    {
        Random random = new Random();
        for (int i = 0; i < list.length; i++)
        {
            list[i] = random.nextInt();
        }
    }

    public static void printArray(int[] list)
    {
        for (int i : list)
            System.out.print(i + ", ");
    }

    public static boolean sequentialSearch(int[] list, int x)
    {
        for (int i : list)
        {
            if(i == x)
                return true;
        }
        return false;
    }

    /*Sorted search is a linear search, but since the list has to be sorted the
    * condition i > x will return false, since i cannot never be greater than x
    * in a sorted array*/
    public static boolean sortedSearch(int[] list, int x)
    {
        for (int i : list)
        {
            if(i == x)
                return true;
            else if(i > x)
                return false;
        }
        return false;
    }

    public static boolean binarySearch(int[] list, int x)
    {
        int first = 0;
        int last = list.length - 1;
        int mid;

        while(first <= last)
        {
            mid = ((first + last) / 2);

            if (x == list[mid])
                return true;
            else if (x < list[mid])
                last = mid - 1;
            else if(x > list[mid])
                first = mid + 1;
        }

        return false;
    }

    /****************************************************************************************/
    /****************************METHODS GIVEN BY PROF. ANTONIO HERNANDEZ********************/
    /**
     *  Recursive quicksort algorithm*  @author Prof. A. Hernandez
     */
    public static void quicksort()
    {
        quicksort(0, list.length - 1);
    }

    private static void quicksort(int begin, int end)
    {
        int temp;
        int pivot = findPivotLocation(begin, end);

        // swap list[pivot] and list[end]
        temp = list[pivot];
        list[pivot] = list[end];
        list[end] = temp;
        pivot = end;

        int i = begin, j = end - 1;
        boolean iterationCompleted = false;
        while (!iterationCompleted)
        {
            while (list[i] < list[pivot])
                i++;
            while ((j >= 0) && (list[pivot] < list[j]))
                j--;
            if (i < j)
            {
                //swap list[i] and list[j]
                temp = list[i];
                list[i] = list[j];
                list[j] = temp;i++;j--;
            } else
                iterationCompleted = true;
        }

        //swap list[i] and list[pivot]
        temp = list[i];
        list[i] = list[pivot];
        list[pivot] = temp;

        if (begin < i - 1) quicksort(begin, i - 1);
        if (i + 1 < end) quicksort(i + 1, end);
    }

    /*
     * Computes the pivot
     */
    private static int findPivotLocation(int b, int e)
    {
        return (b + e) / 2;
    }





}
