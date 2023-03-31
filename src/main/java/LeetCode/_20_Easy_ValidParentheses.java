package LeetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * 20. Valid Parentheses
 * Easy
 * 18.7K
 * 1.1K
 * Companies
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "()"
 * Output: true
 * 
 * Example 2:
 * 
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Example 3:
 * 
 * Input: s = "(]"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class _20_Easy_ValidParentheses
{
	public static void main(String[] args) throws Exception
	{
		String exp = "()";
		System.out.println("Exp : " + exp + " IsValid : " + isValid(exp));
		exp = "()[]{}";
		System.out.println("Exp : " + exp + " IsValid : " + isValid(exp));
		exp = "(]";
		System.out.println("Exp : " + exp + " IsValid : " + isValid(exp));
	}

	public static boolean isValid(String s)
	{
		Stack<Character> stack = new Stack<>();

		int length = s.length();
		for(int i = 0; i < length; i++)
		{
			char ch = s.charAt(i);
			char topCh = stack.size() > 0 ? stack.peek() : ' ';
			switch(ch)
			{
				case '(':
				case '{':
				case '[':
					stack.push(ch);
					break;
				case ')':
					if(topCh != '(')
						return false;
					stack.pop();
					break;
				case '}':
					if(topCh != '{')
						return false;
					stack.pop();
					break;
				case ']':
					if(topCh != '[')
						return false;
					stack.pop();
					break;
			}
		}
		return stack.size() == 0;
	}
}
