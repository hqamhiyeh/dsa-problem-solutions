// 242. Valid Anagram

public class Solution {
    public bool IsAnagram(string s, string t) {
        if(s.Length != t.Length)
            return false;

        var dict = new Dictionary<char,int>();
        foreach(char c in s)
        {
            if(!dict.ContainsKey(c))
                dict[c] = 0;
            dict[c]++;
        }
        
        foreach(char c in t)
            if(!dict.ContainsKey(c) || --dict[c] < 0)
                return false;

        return true;
    }
}
