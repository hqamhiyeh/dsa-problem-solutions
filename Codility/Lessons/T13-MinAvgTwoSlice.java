/*

 * Find the minimal average of any slice containing at least two elements.
 */

class Solution {
    public int solution(int[] A) {
        double minAvg = (double) (A[0] + A[1]) / 2.0;
        int minAvgIndex = 0;
        for (int i = 2; i < A.length; i++) {
            double avg2 = (double) (A[i] + A[i - 1]) / 2.0;
            double avg3 = (double) (A[i] + A[i - 1] + A[i - 2]) / 3.0;

            double currentMinAvg = Math.min(avg2, avg3);
            
            if (currentMinAvg < minAvg) {
                minAvg = currentMinAvg;
                minAvgIndex = (currentMinAvg == avg3 ? i - 2 : i - 1);
            }
        }

        return minAvgIndex;
    }
}