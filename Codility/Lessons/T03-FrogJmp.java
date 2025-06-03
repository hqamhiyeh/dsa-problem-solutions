/*

 * Count minimal number of jumps from position X to Y.
 */

class Solution {
    public int solution(int X, int Y, int D) {
        int roadWidth = Y - X;
        int jumps = (roadWidth % D) == 0 ? roadWidth / D : (roadWidth / D) + 1;

        return jumps;
    }
}