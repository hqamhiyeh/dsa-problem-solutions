/*

 * Find longest sequence of zeros in binary representation of an integer.
 */

class Solution {
    public int solution(int N) {
        String binaryN = Integer.toBinaryString(N);

        int tmpGap = 0;
        int maxGap = 0;
        for (int i = 0; i < binaryN.length(); i++) {
            char bit = binaryN.charAt(i);
            if (bit == '1') {
                if (tmpGap > maxGap)
                    maxGap = tmpGap;

                tmpGap = 0;
            } else // bit == '0'
            {
                tmpGap++;
            }
        }
        
        return maxGap;
    }
}