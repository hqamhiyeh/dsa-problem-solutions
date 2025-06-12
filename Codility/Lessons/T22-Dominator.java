/*

 * Find an index of an array such that its value occurs at more than half of indices in the array.
 */

/*

 * Using O(n) solution idea from https://codility.com/media/train/6-Leader.pdf
 */
class Solution {
    public int solution(int[] A) {
        int index = -1;
        int stackSize = 0;
        for (int j = 0; j < A.length; j++) {
            if (stackSize == 0) {
                index = j;
                stackSize++;
                continue;
            }

            if (A[j] == A[index]) {
                stackSize++;
                continue;
            }

            stackSize--;
        }

        int candidate = -1;
        if (stackSize > 0)
            candidate = index;

        int count = 0;
        if (candidate > -1)
            for (int a : A)
                if (a == A[candidate])
                    count++;

        int dominator = -1;
        if (count > A.length / 2)
            dominator = candidate;

        return dominator;
    }
}