/*

 * Determine whether a given string of parentheses (multiple types) is properly nested.
 */

import java.util.*;

class Solution {
    public int solution(String S) {
        int N = S.length();
        if (N == 0)
            return 1;
        if (N == 1)
            return 0;

        Stack<Character> bracketStack = new Stack<Character>();
        for (int i = 0; i < N; i++) {
            char bracket = S.charAt(i);
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                bracketStack.push(bracket);
                continue;
            }

            if (!bracketStack.empty() && bracket == getClosingBracket(bracketStack.peek())) {
                bracketStack.pop();
                continue;
            }

            return 0;
        }

        if (!bracketStack.empty())
            return 0;

        return 1;
    }

    private Character getClosingBracket(Character openingBracket) {
        switch (openingBracket) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
        }
        return null;
    }
}