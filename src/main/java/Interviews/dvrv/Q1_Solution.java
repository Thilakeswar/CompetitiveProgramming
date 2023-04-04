package Interviews.dvrv;

import java.util.Arrays;

public class Q1_Solution
{
    public static void main(String[] args) throws Exception
    {
        findGoodTuples(new int[]{1, 1, 1, 2, 1, 3, 4});
        findGoodTuples(new int[]{1, 1, 2, 1, 2, 1, 1});
    }

    public static void findGoodTuples(int[] array) throws Exception
    {
        System.out.println("Finding good tuples for the array - " + Arrays.toString(array));
        int goodTupleCount = 0;
        for (int i = 0; i < array.length - 2; i++)
        {
            if(array[i] == array[i+1] && array[i+1] == array[i+2])
            {
                continue;
            }
            if (array[i] == array[i + 1] || array[i + 1] == array[i + 2] || array[i] == array[i + 2])
            {
                goodTupleCount++;
                System.out.println("A good tuple : " + array[i] + " , " + array[i + 1] + " , " + array[i + 2]);
            }
        }
        System.out.println("Total good tuples count : " + goodTupleCount);
    }
}
