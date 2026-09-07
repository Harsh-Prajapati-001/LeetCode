class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;

        long total = 1;
        long[] last = new long[26];

        for (char c : s.toCharArray()) {
            int idx = c - 'a';

            long previous = total;
            total = (2 * total - last[idx] + MOD) % MOD;

            last[idx] = previous;
        }

        return (int) ((total - 1 + MOD) % MOD);
    }
}