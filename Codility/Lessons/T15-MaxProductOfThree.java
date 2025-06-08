/*

 * Maximize A[P] * A[Q] * A[R] for any triplet (P, Q, R).
 */

import java.util.*;

class Solution {
    public int solution(int[] A) {
        int N = A.length;
        if (N == 3)
            return A[0] * A[1] * A[2];

        Arrays.sort(A);
        return Math.max(A[N - 1] * A[N - 2] * A[N - 3], A[0] * A[1] * A[N - 1]);
    }
}