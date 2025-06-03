/*

 * Rotate an array to the right by a given number of steps.
 */

class Solution {
    public int[] solution(int[] A, int K) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int N = A.length;
            int j = K % N + i;
            j = (j < N) ? j : j - A.length;
            result[j] = A[i];
        }

        return result;
    }
}