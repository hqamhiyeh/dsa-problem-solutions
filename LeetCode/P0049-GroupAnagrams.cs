// 49. Group Anagrams

public class Solution
{
    public IList<IList<string>> GroupAnagrams(string[] strs)
    {
        var dict = new Dictionary<string, IList<string>>();
        foreach (string str in strs)
        {
            var charArray = str.ToCharArray();
            Array.Sort(charArray);
            var key = new String(charArray);
            if (!dict.ContainsKey(key))
            {
                var newList = new List<string>();
                dict.Add(key, newList);
            }
            dict[key].Add(str);
        }
        return dict.Values.ToList();
    }
}
