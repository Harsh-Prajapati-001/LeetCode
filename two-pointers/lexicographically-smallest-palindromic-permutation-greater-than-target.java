class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int odd = 0;
        int mid = -1;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) != 0) {
                odd++;
                mid = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        for (int i = 0; i < 26; i++) {
            freq[i] /= 2;
        }

        char[] ans = new char[n];
        int half = n / 2;

        for (int i = 0; i < half; i++) {
            ans[i] = target.charAt(i);
        }

        int pos = 0;

        while (pos < half) {
            int c = target.charAt(pos) - 'a';

            if (freq[c] == 0) {
                break;
            }

            freq[c]--;
            pos++;
        }

        if (pos == half) {
            build(ans, freq, mid, half);

            if (new String(ans).compareTo(target) > 0) {
                return new String(ans);
            }
        }

        while (pos >= 0) {
            if (pos < half) {
                int current = target.charAt(pos) - 'a';

                for (int c = current + 1; c < 26; c++) {
                    if (freq[c] > 0) {
                        ans[pos] = (char) ('a' + c);
                        freq[c]--;

                        int index = pos + 1;

                        for (int j = 0; j < 26; j++) {
                            while (freq[j] > 0) {
                                ans[index++] = (char) ('a' + j);
                                freq[j]--;
                            }
                        }

                        build(ans, freq, mid, half);

                        return new String(ans);
                    }
                }
            }

            if (pos == 0) {
                return "";
            }

            pos--;

            int c = target.charAt(pos) - 'a';
            freq[c]++;
            ans[pos] = target.charAt(pos);
        }

        return "";
    }

    private void build(char[] ans, int[] freq, int mid, int half) {
        int n = ans.length;

        if (mid != -1) {
            ans[half] = (char) ('a' + mid);
        }

        for (int i = 0; i < half; i++) {
            ans[n - 1 - i] = ans[i];
        }
    }
}