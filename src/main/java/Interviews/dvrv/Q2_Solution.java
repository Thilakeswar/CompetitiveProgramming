package Interviews.dvrv;

public class Q2_Solution
{
	public static void main(String[] args) throws Exception
	{
		findNumberOfWaysToSplitString("xzxzx");
	}

	public static void findNumberOfWaysToSplitString(String str) throws Exception
	{
		int totalWaysToSplitStringIntoThree = 0;
		int strLength = str.length();
		for(int i = 1; i < strLength; i++)
		{
			for(int j = i + 1; j < strLength; j++)
			{
				String a = str.substring(0, i);
				String b = str.substring(i, j);
				String c = str.substring(j, strLength);
				System.out.println("a : " + a);
				System.out.println("b : " + b);
				System.out.println("c : " + c);
				String aConcatb = a.concat(b);
				String bConcatc = b.concat(c);
				String cConcata = c.concat(a);
				System.out.println("aConcatb : " + aConcatb);
				System.out.println("bConcatc : " + bConcatc);
				System.out.println("cConcata : " + cConcata);
				if(aConcatb.equals(bConcatc) || bConcatc.equals(cConcata) || cConcata.equals(aConcatb))
				{
					System.out.println("a+b, b+c, c+a has a unique combination. Hence skipping!!!");
					continue;
				}
				System.out.println("a+b, b+c, c+a are all different");
				totalWaysToSplitStringIntoThree++;
			}
		}
		System.out.println(totalWaysToSplitStringIntoThree);
	}
}
