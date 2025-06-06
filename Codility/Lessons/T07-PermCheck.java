/*

 * Check whether array A is a permutation.
 */

import java.util.*;

class Solution {
    public int solution(int[] A) {
        HashSet<Integer> aSet = new HashSet<Integer>();

        for (int a : A) {
            if (a > A.length)
                return 0;

            if (aSet.contains(a))
                return 0;

            aSet.add(a);
        }

        return 1;
    }
}