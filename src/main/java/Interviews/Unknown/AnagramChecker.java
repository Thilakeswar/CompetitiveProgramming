package Interviews.Unknown;

import java.util.*;

public class AnagramChecker
{
    public static void main(String[] args) throws Exception
    {
        checkAnagram("silent", "listen");
        checkAnagram("spar", "rasp");
        checkAnagram("john", "kenndy");
        checkAnagram("rough", "tough");
    }

    public static boolean checkAnagram(String str1, String str2) throws Exception
    {
        boolean isSuccess = true;
        try
        {
            System.out.println("\nProcessing Strings : ");
            System.out.println("String 1 : " + str1);
            System.out.println("String 2 : " + str2);
            if(str1.length() != str2.length())
            {
                isSuccess = false;
                log(isSuccess, "Given two string are not of same length!!!");
                return isSuccess;
            }
            if(str1.equalsIgnoreCase(str2))
            {
                log(isSuccess);
                return isSuccess;
            }
            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();
            String errorMessage = null;
            int len = str1.length();
            Map<Character, Integer> characterVsCount = new HashMap<>();
            for(int i = 0; i < len; i++)
            {
                int count = 1;
                if(characterVsCount.containsKey(str1.charAt(i)))
                {
                    count += characterVsCount.get(str1.charAt(i));
                }
                characterVsCount.put(str1.charAt(i), count);
            }
            for(int i = 0; i < len; i++)
            {
                int count;
                if(characterVsCount.containsKey(str2.charAt(i)))
                {
                    count = characterVsCount.get(str1.charAt(i)) - 1;
                }
                else
                {
                    isSuccess = false;
                    errorMessage = "String 2 has a character " + str2.charAt(i) + " that is not present in String 1";
                    break;
                }
                characterVsCount.put(str1.charAt(i), count);
            }
            for(Map.Entry<Character, Integer> entry : characterVsCount.entrySet())
            {
                if(characterVsCount.get(entry.getKey()) != 0)
                {
                    isSuccess = false;
                    errorMessage = "One (or) more character mismatch";
                    break;
                }
            }
            log(isSuccess, errorMessage);
        }
        catch(Exception e)
        {
            System.out.println("Anagram checker failed to " + e);
        }
        return isSuccess;
    }

    public static void log(boolean isSuccess)
    {
        log(isSuccess, null);
    }

    public static void log(boolean isSuccess, String reason)
    {
        System.out.println("Result : " + isSuccess);
        if(!isSuccess)
        {
            System.out.println("Reason : " + reason);
        }
    }
}
