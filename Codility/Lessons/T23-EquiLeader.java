/*

 * Find the number of indexes S such that the leaders of the sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N - 1] are the same.
 */

/*

 * The idea for this solution is based on the following:
 * If the array has a leader, then there's at least one pair of sequences having the
 *  same leader, and these sequences' leader values will be equal to the global leader.
 * If the list has no leader, then there is no equi leader to be found either.
 */
class Solution {
    public int solution(int[] A) {
        int[] leader_data = findLeaderData(A);

        int leader_index = leader_data[0];
        int leader_count = leader_data[1];

        if (leader_index == -1)
            return 0;

        int result = 0;
        int leader_value = A[leader_index];
        int seq1_leader_count = 0;
        int seq2_leader_count = leader_count;
        for (int i = 0; i < A.length - 1; i++) {
            boolean seq1_leader_exists = false;
            boolean seq2_leader_exists = false;

            if (A[i] == leader_value) {
                seq1_leader_count++;
                seq2_leader_count--;
            }

            if (seq1_leader_count > (i + 1) / 2)
                seq1_leader_exists = true;

            if (seq2_leader_count > (A.length - i - 1) / 2) {
                seq2_leader_exists = true;
            }

            if (seq1_leader_exists && seq2_leader_exists)
                result++;
        }

        return result;
    }

    private int[] findLeaderData(int[] array) {
        if (array.length < 1)
            throw new IllegalArgumentException();

        int stack_size = 0;
        int index = -1;
        for (int j = 0; j < array.length; j++) {
            if (stack_size == 0) {
                index = j;
                stack_size++;
                continue;
            }

            if (array[j] == array[index]) {
                stack_size++;
                continue;
            }

            stack_size--;
        }

        int candidate = -1;
        if (stack_size > 0)
            candidate = index;

        int count = -1;
        if (candidate > -1) {
            count++;
            for (int a : array) {
                if (a == array[index]) {
                    count++;
                }
            }
        }

        int leader = -1;
        if (count > array.length / 2) {
            leader = candidate;
        }

        return new int[] { leader, count };
    }
}