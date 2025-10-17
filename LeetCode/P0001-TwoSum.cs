// 1. Two Sum

public class Solution
{
    public int[] TwoSum(int[] nums, int target)
    {
        var dict = new Dictionary<int, int>();
        for (int i = 0; i < nums.Length; i++)
        {
            var num = nums[i];
            var remainder = target - num;
            if (dict.ContainsKey(remainder))
                return new int[] { dict[remainder], i };

            dict.TryAdd(num, i);
        }
        throw new InvalidOperationException("No solution exists");
    }
}
