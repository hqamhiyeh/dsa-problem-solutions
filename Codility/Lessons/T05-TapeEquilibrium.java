/*

 * Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
 */

class Solution {
    public int solution(int[] A) {
        int total = 0;
        for (int a : A) {
            total += a;
        }

        int rollingSum = 0;
        int minimalDiff = diff(A[0], total);
        for (int i = 0; i < (A.length - 1); i++) {
            rollingSum += A[i];
            int diff = diff(rollingSum, total);
            if (diff < minimalDiff)
                minimalDiff = diff;
        }

        return minimalDiff;
    }

    public int diff(int rollingSum, int total) {
        int sum1 = rollingSum;
        int sum2 = total - rollingSum;
        return Math.abs(sum1 - sum2);
    }
}