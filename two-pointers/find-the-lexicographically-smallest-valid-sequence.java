 class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();

        // suffixMatch[i] =
        // maximum number of characters from the END of word2
        // that can be matched using word1[i...]
        int[] suffixMatch = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {

            suffixMatch[i] = suffixMatch[i + 1];

            if (j >= 0 && a[i] == b[j]) {
                suffixMatch[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int i = 0;
        j = 0;

        boolean changed = false;

        while (i < n && j < m) {

            // Exact match: always take earliest possible index
            if (a[i] == b[j]) {
                ans[j] = i;
                i++;
                j++;
            }

            // Use our one allowed modification
            else if (!changed &&
                    suffixMatch[i + 1] >= m - j - 1) {

                ans[j] = i;

                changed = true;

                i++;
                j++;
            }

            else {
                i++;
            }
        }

        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}