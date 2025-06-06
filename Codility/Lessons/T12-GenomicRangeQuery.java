/*

 * Find the minimal nucleotide from a range of sequence DNA.
 */

class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        final int dnaSize = S.length();
        int[] dnaA = new int[dnaSize + 1]; // A impact factor = 1
        int[] dnaC = new int[dnaSize + 1]; // C impact factor = 2
        int[] dnaG = new int[dnaSize + 1]; // G impact factor = 3

        for (int i = 0; i < dnaSize; i++) {
            switch (S.charAt(i)) {
                case 'A':
                    dnaA[i + 1] = dnaA[i] + 1;
                    dnaC[i + 1] = dnaC[i];
                    dnaG[i + 1] = dnaG[i];
                    break;
                case 'C':
                    dnaA[i + 1] = dnaA[i];
                    dnaC[i + 1] = dnaC[i] + 1;
                    dnaG[i + 1] = dnaG[i];
                    break;
                case 'G':
                    dnaA[i + 1] = dnaA[i];
                    dnaC[i + 1] = dnaC[i];
                    dnaG[i + 1] = dnaG[i] + 1;
                    break;
                default:
                    dnaA[i + 1] = dnaA[i];
                    dnaC[i + 1] = dnaC[i];
                    dnaG[i + 1] = dnaG[i];
                    break;
            }
        }

        int M = P.length;
        int[] queryAnswers = new int[M];
        for (int i = 0; i < M; i++) {
            int posP = P[i];
            int posQ = Q[i] + 1; // because dnaA,dnaC,dnaG arrays are sized +1

            if (dnaA[posQ] - dnaA[posP] > 0)
                queryAnswers[i] = 1;
            else if (dnaC[posQ] - dnaC[posP] > 0)
                queryAnswers[i] = 2;
            else if (dnaG[posQ] - dnaG[posP] > 0)
                queryAnswers[i] = 3;
            else
                queryAnswers[i] = 4;
        }

        return queryAnswers;
    }
}