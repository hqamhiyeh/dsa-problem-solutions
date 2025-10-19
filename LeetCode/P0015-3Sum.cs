// 15. 3Sum

public class Solution
{
    public IList<IList<int>> ThreeSum(int[] nums)
    {
        var solution = new Dictionary<string,int[]>();
        for(int i = 0; i < nums.Length; i++)
        {
            int target = 0 - nums[i];
            var set = new HashSet<int>();
            for(int j = i + 1; j < nums.Length; j++)
            {
                int num = nums[j];
                int remainder = target - num;
                if(set.Contains(remainder))
                {
                    var triplet = new int[] {nums[i], num, remainder};
                    Array.Sort(triplet);
                    var tripletKey = $"{triplet[0]}#{triplet[1]}#{triplet[2]}";
                    if(!solution.ContainsKey(tripletKey))
                        solution[tripletKey] = triplet;
                }
                set.Add(num);
            }
        }
        return solution.Values.Select(arr => (IList<int>)arr.ToList()).ToList();
    }
}
