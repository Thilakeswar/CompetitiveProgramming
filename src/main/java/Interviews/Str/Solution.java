package Interviews.Str;

import org.apache.commons.lang3.StringUtils;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
		/*
		System.out.println(computePenalty("Y Y N Y", 0));;// should return 3
		System.out.println(computePenalty("N Y N Y", 2));// should return 2
		System.out.println(computePenalty("Y Y N Y", 4));// should return 1
		System.out.println(computePenalty("Y Y N Y", 5));// should return 1
		 */
        System.out.println(findBestClosingTime("Y Y N N"));//should return 2
        System.out.println(findBestClosingTime("Y Y N Y"));//should return 2
        System.out.println(findBestClosingTime("Y N N Y"));//should return 1
        System.out.println(findBestClosingTime("N N N Y"));//should return 0
        System.out.println(findBestClosingTime("Y Y Y Y"));//should return 4
        System.out.println(findBestClosingTime("Y Y Y N"));//should return 3
    }

    public static int computePenalty(String log, int closingTime)
    {
        int penalty = 0;
        String logArr[] = StringUtils.split(log, " ");
        int logSize = logArr.length;
        int iterator = 0;
        while(iterator < closingTime && iterator < logSize)
        {
            if("N".equalsIgnoreCase(logArr[iterator++]))
            {
                penalty++;
            }
        }
        while(iterator < logSize && iterator < logSize)
        {
            if("Y".equalsIgnoreCase(logArr[iterator++]))
            {
                penalty++;
            }
        }
        return penalty;
    }

    public static int findBestClosingTime(String log) throws Exception
    {
        String logArr[] = StringUtils.split(log, " ");
        int logSize = logArr.length;

        int leastPenalty = computePenalty(log, 0);
        int bestClosingTime = 0;

        int closingTime = 1;
        //boolean hasAnyIdleHour = "N".equalsIgnoreCase(logArr[0]);
        while(closingTime <= logSize)
        {
            int currentPenalty = computePenalty(log, closingTime);
            if(currentPenalty < leastPenalty)
            {
                leastPenalty = currentPenalty;
                bestClosingTime = closingTime;
            }
            //hasAnyIdleHour = hasAnyIdleHour || "N".equalsIgnoreCase(logArr[closingTime]);
            closingTime++;
        }
        return bestClosingTime ;
    }
}
