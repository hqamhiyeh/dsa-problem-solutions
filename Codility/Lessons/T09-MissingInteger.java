/*

 * Find the smallest positive integer that does not occur in a given sequence. 
 */

import java.util.*;

class Solution {
    public int solution(int[] A) {
        HashSet<Integer> nSet = new HashSet<Integer>();
        
        for (int n=1; n<=A.length; n++)
            nSet.add(n);

        for (int a : A)
            if (nSet.contains(a))
                nSet.remove(a);
        
        int result = A.length + 1;
        for (int n : nSet)
            if (n < result)
                result = n;

        return result;
    }
}