/*

 * N voracious fish are moving along a river. Calculate how many fish are alive.
 */

import java.util.*;

class Solution {
    final int Upstream = 0;
    final int Downstream = 1;

    public int solution(int[] A, int[] B) {
        Stack<Integer> river = new Stack<Integer>();
        for (int fish = 0; fish < A.length; fish++) {
            int alive_fish = fish;
            while (B[alive_fish] == Upstream && !river.empty() && B[river.peek()] == Downstream) {
                int another_fish = river.pop();
                alive_fish = A[alive_fish] > A[another_fish] ? alive_fish : another_fish;
            }
            river.push(alive_fish);
        }
        return river.size();
    }
}