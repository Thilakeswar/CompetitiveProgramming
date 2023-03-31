package Interviews.nvpy;

/**
 * Find the first unique number from an array of integers
 */
public class _1
{
	public static void main(String[] args) throws Exception
	{
		int nums[] = new int[] {1, 2, 3, 4, 2, 1, 3, 5};
		int size = nums.length;
		int firstUniqueElement = -1;
		//Brute-Force approach
		for(int i = 0; i < size; i++)
		{
			firstUniqueElement = nums[i];
			for(int j = i + 1; j < size; j++)
			{
				if(nums[i] == nums[j])
				{
					firstUniqueElement = -1;
					break;
				}
			}
			if(firstUniqueElement != -1)
			{
				break;
			}
		}
		System.out.println(firstUniqueElement);
	}
}
