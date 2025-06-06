/*

 * Compute number of integers divisible by k in range [a..b].
 */

class Solution {
    public int solution(int A, int B, int K) {
        int a = (int) Math.ceil((double) A / (double) K) * K;
        int b = (int) Math.floor((double) B / (double) K) * K;

        return (b - a) / K + 1;
    }
}