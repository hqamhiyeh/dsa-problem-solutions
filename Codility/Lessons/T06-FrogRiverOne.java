/*

 * Find the earliest time when a frog can jump to the other side of a river.
 */

import java.util.*;

class Solution {
    public int solution(int X, int[] A) {
        HashSet<Integer> aSet = new HashSet<Integer>();
        int result = -1;
        for (int K = 0; K < A.length; K++) {
            if (!aSet.contains(A[K]))
                aSet.add(A[K]);

            if (aSet.size() == X) {
                result = K;
                break;
            }
        }

        return result;
    }
}