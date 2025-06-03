/*

 * Find the missing element in a given permutation.
 */

import java.util.*;

class Solution {
    public int solution(int[] A) {
        HashSet<Integer> aSet = new HashSet<Integer>();
        for (int a : A) {
            aSet.add(a);
        }

        int result = 0;
        for (int n = 1; n <= (A.length + 1); n++) {
            if (!aSet.contains(n)) {
                result = n;
                break;
            }
        }

        return result;
    }
}