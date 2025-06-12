/*

 * Cover "Manhattan skyline" using the minimum number of rectangles.
 */

/*

 * The idea:
 * Every time we go up in height, add a rectangle.
 * If we stay the same height, add nothing.
 * But as we're going down in height, we have to check for a condition:
 *      If the new height is at the same level of a previous part of the wall,
 *      and the heights in-between are all higher than this height,
 *      then we don't add anything because this height is already accounted for.
 *      Otherwise we add a rectangle.
 */
import java.util.*;

class Solution {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        for (int i = 0; i < H.length; i++) {
            while (!stack.empty() && stack.peek() > H[i])
                stack.pop();

            if (!stack.empty() && stack.peek() == H[i])
                continue;

            stack.push(H[i]);
            count++;
        }

        return count;
    }
}