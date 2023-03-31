package Interviews.nvpy;

/**
 * How to find all pairs of integers whose sum is equal to a given number.
 * For example if input integer array is {2, 6, 3, 9, 11} and given sum is 9, output should be {6,3}.
 */
public class _2
{
	public static void main(String[] args) throws Exception
	{
		int nums[] = new int[] {2, 6, 3, 9, 11};
		int desiredSum = 9;
		int size = nums.length;
		for(int i = 0; i < size; i++)
		{
			for(int j = i + 1; j < size; j++)
			{
				if(desiredSum == nums[i] + nums[j])
				{
					System.out.println(nums[i] + "," + nums[j]);
				}
			}
		}

	}
}
