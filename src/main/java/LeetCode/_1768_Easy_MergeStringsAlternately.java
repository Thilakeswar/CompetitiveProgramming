package LeetCode;

/**
 * https://leetcode.com/problems/merge-strings-alternately/
 * <p>
 * 1768. Merge Strings Alternately
 * Easy
 * 1.9K
 * 33
 * Companies
 * <p>
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 * <p>
 * Return the merged string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * <p>
 * Example 2:
 * <p>
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 * <p>
 * Example 3:
 * <p>
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= word1.length, word2.length <= 100
 * word1 and word2 consist of lowercase English letters.
 */
public class _1768_Easy_MergeStringsAlternately
{
	public static void main(String[] args) throws Exception
	{
		System.out.println(mergeAlternately("abc", "pqr"));
		System.out.println(mergeAlternately("ab", "pqrs"));
		System.out.println(mergeAlternately("abcd", "pq"));
	}

	public static String mergeAlternately(String word1, String word2) throws Exception
	{
		StringBuilder result = new StringBuilder();
		int ptr = 0, word1Len = word1.length(), word2Len = word2.length();
		while(ptr < word1Len || ptr < word2Len)
		{
			if(ptr >= word1Len && ptr < word2Len)
			{
				result.append(word2.substring(ptr, word2Len));
				break;
			}
			if(ptr >= word2Len && ptr < word1Len)
			{
				result.append(word1.substring(ptr, word1Len));
				break;
			}
			if(ptr < word1Len)
			{
				result.append(word1.charAt(ptr));
			}
			if(ptr < word2Len)
			{
				result.append(word2.charAt(ptr));
			}
			ptr++;
		}
		return result.toString();
	}
}
