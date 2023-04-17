package Interviews.dvrv;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q3_Solution
{
	public static void main(String[] args) throws Exception
	{
		alterFileNames(new String[]{"doc", "doc", "image", "doc(1)", "doc"});
		alterFileNames(new String[]{"a(1)","a(4)","a(5)","a(6)","a","a","a","a","a","a","a","a","a","a","a(6)","a(4)","a(2)"});
		alterFileNames(new String[]{"dd", "dd(1)", "dd(2)", "dd", "dd(1)", "dd(1)(2)", "dd(1)(1)", "dd", "dd(1)"});
	}

	public static void alterFileNames(String[] names) throws Exception
	{
		System.out.println("Input Received : "+ Arrays.toString(names));
		Map<String, Integer> nameVsCount = new HashMap<>();
		for(int i =0 ;i<names.length; i++)
		{
			String originalFileName = names[i];
			int count = 1;
			if(nameVsCount.containsKey(originalFileName))
			{
				count = nameVsCount.get(originalFileName);
				String alteredFileName = originalFileName.concat("(").concat(String.valueOf(count)).concat(")");
				while(nameVsCount.containsKey(alteredFileName))
				{
					count++;
					alteredFileName = originalFileName.concat("(").concat(String.valueOf(count)).concat(")");
				}
				nameVsCount.put(alteredFileName, 1);
				names[i] = alteredFileName;
				count++;
			}
			nameVsCount.put(originalFileName, count);
		}
		System.out.println("Input Received : "+ Arrays.toString(names));
	}
}