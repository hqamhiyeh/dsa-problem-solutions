/*

 * Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.
 */

class Solution {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxCount = 0;
        int minCount = 0;
        for (int a : A) {
            if (a >= 1 && a <= N) {
                int X = a - 1;

                if (counters[X] < minCount)
                    counters[X] = minCount + 1;
                else
                    counters[X]++;

                if (counters[X] > maxCount)
                    maxCount++;
            } else {
                minCount = maxCount;
            }
        }

        for (int i = 0; i < N; i++) {
            if (counters[i] < minCount)
                counters[i] = minCount;
        }

        return counters;
    }
}