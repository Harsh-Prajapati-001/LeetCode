class Solution {

    private static final int[][] FACTOR = {
        {0,0,0,0}, // 0
        {0,0,0,0}, // 1
        {1,0,0,0}, // 2
        {0,1,0,0}, // 3
        {2,0,0,0}, // 4
        {0,0,1,0}, // 5
        {1,1,0,0}, // 6
        {0,0,0,1}, // 7
        {3,0,0,0}, // 8
        {0,2,0,0}  // 9
    };

    public String smallestNumber(String num, long t) {

        int[] need = new int[4];

        long x = t;

        int[] primes = {2, 3, 5, 7};

        // Factorize t
        for (int i = 0; i < 4; i++) {
            while (x % primes[i] == 0) {
                need[i]++;
                x /= primes[i];
            }
        }

        // t contains a prime other than 2,3,5,7
        if (x != 1) {
            return "-1";
        }

        int n = num.length();

        // factors available in prefix
        int[] prefix = new int[4];

        int firstZero = n;

        for (int i = 0; i < n; i++) {

            int digit = num.charAt(i) - '0';

            if (digit == 0 && firstZero == n) {
                firstZero = i;
            }

            if (digit != 0) {
                add(prefix, FACTOR[digit]);
            }
        }

        // num itself already works
        if (firstZero == n && enough(prefix, need)) {
            return num;
        }

        /*
         * Remove digits from right to left.
         * At each position, try replacing the current digit
         * with the smallest larger digit.
         */
        for (int i = n - 1; i >= 0; i--) {

            int current = num.charAt(i) - '0';

            if (current != 0) {
                subtract(prefix, FACTOR[current]);
            }

            // We cannot modify positions after an earlier zero,
            // because that zero must eventually be removed.
            if (i > firstZero) {
                continue;
            }

            int start = Math.max(1, current + 1);

            for (int digit = start; digit <= 9; digit++) {

                int[] have = prefix.clone();
                add(have, FACTOR[digit]);

                int[] remaining = remaining(need, have);

                String suffix = buildSmallest(remaining);

                int available = n - i - 1;

                if (suffix.length() <= available) {

                    StringBuilder ans = new StringBuilder();

                    ans.append(num, 0, i);
                    ans.append(digit);

                    // fill unused positions with 1
                    int ones = available - suffix.length();

                    for (int k = 0; k < ones; k++) {
                        ans.append('1');
                    }

                    ans.append(suffix);

                    return ans.toString();
                }
            }
        }

        /*
         * No answer with same number of digits.
         * Construct a longer number.
         */
        String suffix = buildSmallest(need);

        int length = Math.max(n + 1, suffix.length());

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < length - suffix.length(); i++) {
            ans.append('1');
        }

        ans.append(suffix);

        return ans.toString();
    }


    // ------------------------------------------------
    // Build smallest digits satisfying required factors
    // ------------------------------------------------

    private String buildSmallest(int[] need) {

        int a = need[0]; // 2
        int b = need[1]; // 3
        int c = need[2]; // 5
        int d = need[3]; // 7

        int[] count = new int[10];

        // 5 and 7 can only come from digits 5 and 7
        count[5] = c;
        count[7] = d;

        /*
         * Use digit 8 for three factors of 2
         */
        count[8] = a / 3;
        a %= 3;

        /*
         * Use digit 9 for two factors of 3
         */
        count[9] = b / 2;
        b %= 2;

        /*
         * Combine remaining 2 and 3 into digit 6
         */
        if (a > 0 && b > 0) {
            count[6]++;
            a--;
            b--;
        }

        /*
         * Remaining powers of 2
         */
        if (a == 2) {
            count[4]++;
        } else if (a == 1) {
            count[2]++;
        }

        /*
         * Remaining power of 3
         */
        if (b == 1) {
            count[3]++;
        }

        StringBuilder result = new StringBuilder();

        // ascending order gives smallest number
        for (int digit = 2; digit <= 9; digit++) {
            for (int k = 0; k < count[digit]; k++) {
                result.append(digit);
            }
        }

        return result.toString();
    }


    private int[] remaining(int[] need, int[] have) {

        int[] result = new int[4];

        for (int i = 0; i < 4; i++) {
            result[i] = Math.max(0, need[i] - have[i]);
        }

        return result;
    }


    private boolean enough(int[] have, int[] need) {

        for (int i = 0; i < 4; i++) {
            if (have[i] < need[i]) {
                return false;
            }
        }

        return true;
    }


    private void add(int[] a, int[] b) {
        for (int i = 0; i < 4; i++) {
            a[i] += b[i];
        }
    }


    private void subtract(int[] a, int[] b) {
        for (int i = 0; i < 4; i++) {
            a[i] -= b[i];
        }
    }
}  
