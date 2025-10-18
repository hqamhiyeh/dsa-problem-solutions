// 347. Top K Frequent Elements

public class Solution
{
    public int[] TopKFrequent(int[] nums, int k)
    {
        var freqMap = new Dictionary<int, int>();
        foreach (var num in nums)
        {
            if (!freqMap.ContainsKey(num))
                freqMap[num] = 0;
            freqMap[num]++;
        }

        List<int>[] buckets = new List<int>[nums.Length + 1];
        foreach (var kvp in freqMap)
        {
            int freq = kvp.Value;
            if (buckets[freq] is null)
                buckets[freq] = new List<int>();
            buckets[freq].Add(kvp.Key);
        }

        var answer = new int[k];
        for (int i = nums.Length, count = 0; i >= 0; i--)
            if (buckets[i] is not null && buckets[i].Count > 0)
                foreach (var num in buckets[i])
                {
                    answer[count++] = num;
                    if (count == k)
                        return answer;
                }

        throw new InvalidOperationException("No solution exists");
    }
}
