/*

 * Compute number of distinct values in an array.
 */

import java.util.*;

class Solution {
    public int solution(int[] A) {
        HashSet<Integer> aSet = new HashSet<Integer>();
        for (int a : A)
            if (!aSet.contains(a))
                aSet.add(a);

        return aSet.size();
    }
}