/*

 * Given a log of stock prices compute the maximum possible earning.
 */

class Solution {
    public int solution(int[] A) {
        int result = 0;
        for (int P = 0, Q = 1; Q < A.length; Q++) {
            int net = Math.max(0, A[Q] - A[P]);
            result = Math.max(result, net);
            
            if (net == 0)
                P = Q;
        }

        return result;
    }
}