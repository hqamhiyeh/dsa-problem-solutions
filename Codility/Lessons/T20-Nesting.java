/*

 * Determine whether a given string of parentheses (single type) is properly nested. 
 */

class Solution {
    public int solution(String S) {
        final int N = S.length();

        if (N > 0 && N % 2 == 1)
            return 0;

        int count = 0;
        for (int i = 0; i < N; i++) {
            count = S.charAt(i) == '(' ? count + 1 : count - 1;
            if (count < 0)
                return 0;
        }

        return (count == 0) ? 1 : 0;
    }
}