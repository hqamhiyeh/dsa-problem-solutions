/*

 * Count the number of passing cars on the road.
 */

class Solution {
    public int solution(int[] A) {
        final int N = A.length;
        final int threshold = 1000000000;

        int[] goingWest = new int[N];
        for (int i = (N - 1), n = 0; i >= 0; i--)
            goingWest[i] = (A[i] == 1) ? ++n : n;

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (result > threshold)
                return -1;

            if (A[i] == 0)
                result += goingWest[i];
        }

        return result;
    }
}