/*

 * Compute the number of intersections in a sequence of discs.
 */

/*
 * The idea: Imagine going on the number line from left to right.
 * If we "Enter" any discs then the number of pairs will be:
 *      the previous amount of pairs we had
 *      + the new amount of discs entered * previous amount of discs we were in
 *      + n(n-1)/2 where n is the new amount of discs entered
 *
 * "the new amount of discs entered * previous amount of discs we were in" is the new number
 *  of unordered pairs that are added due to the intersection of the new discs entered with
 *  the previously tracked discs.
 * 
 * "n(n-1)/2" is the amount of unordered pairs that can be made from n intersecting discs.
 *  So this is the number of unordered pairs added from the new discs intersecting each other.
 *  https://en.wikipedia.org/wiki/1_%2B_2_%2B_3_%2B_4_%2B_%E2%8B%AF
 * 
 * We have to keep track of the amount of discs we're "entering" and "leaving" at every point
 *  on the number line.
 * 
 * A disc's left most point is where we enter a disc. A disc's right most point is where we
 *  leave a disc.
 * 
 * We have to store both the "enter" no of discs and "leave" no of discs separately for cases
 *  where we're "entering" and "leaving" discs simultaneously at a single point.
 * 
 * We have to keep track of the number of discs we're in as we're going along the number line.
 */
class Solution {
    public int solution(int[] A) {
        int N = A.length;
        if (N < 2)
            return 0;

        int[] enter = new int[N + 1];
        int[] leave = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int radius = A[i];
            int left = i - radius < 0 ? 0 : i - radius;
            int right = (long) i + (long) radius > (long) N ? N : i + radius;
            enter[left]++;
            leave[right]++;
        }

        int discCount = 0;
        int pairsCount = 0;
        final int threshold = 10000000;
        for (int i = 0; i <= N; i++) {
            pairsCount = pairsCount + (enter[i] * discCount) + ((enter[i] * (enter[i] - 1)) / 2);

            if (pairsCount > threshold)
                return -1;

            discCount += enter[i];
            discCount -= leave[i];
        }

        return pairsCount;
    }
}