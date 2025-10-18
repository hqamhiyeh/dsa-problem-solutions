// 3. Longest Substring Without Repeating Characters

public class Solution {
    public int LengthOfLongestSubstring(string s) {
        var answer = 0;
        var dict = new Dictionary<char,int>();
        for(int i = 0; i < s.Length; i++)
        {   
            char c = s[i];
            if(dict.ContainsKey(c))
            {
                int start = i - dict.Count;
                int end = dict[c] + 1;
                foreach(char x in s[start..end])
                    dict.Remove(x);
            }
            dict[c] = i;

            if(dict.Count > answer)
                answer = dict.Count;
        }
        return answer;
    }
}
