class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int half = n / 2;

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int odd = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if ((count[i] & 1) != 0) {
                odd++;
                middle = i;
            }
            count[i] /= 2;
        }

        if (odd > 1) {
            return "";
        }

        int[] remaining = count.clone();

        int matched = 0;

        while (matched < half) {
            int x = target.charAt(matched) - 'a';

            if (remaining[x] == 0) {
                break;
            }

            remaining[x]--;
            matched++;
        }

        if (matched == half) {
            String left = target.substring(0, half);

            StringBuilder ans = new StringBuilder(left);

            if (middle != -1) {
                ans.append((char) ('a' + middle));
            }

            ans.append(new StringBuilder(left).reverse());

            if (ans.toString().compareTo(target) > 0) {
                return ans.toString();
            }
        }

        int i = matched == half ? half - 1 : matched;

        while (i >= 0) {
            int x = target.charAt(i) - 'a';

            remaining[x]++;

            for (int c = x + 1; c < 26; c++) {
                if (remaining[c] == 0) {
                    continue;
                }

                StringBuilder left = new StringBuilder();

                left.append(target, 0, i);
                left.append((char) ('a' + c));

                remaining[c]--;

                for (int j = 0; j < 26; j++) {
                    while (remaining[j] > 0) {
                        left.append((char) ('a' + j));
                        remaining[j]--;
                    }
                }

                StringBuilder ans = new StringBuilder(left);

                if (middle != -1) {
                    ans.append((char) ('a' + middle));
                }

                ans.append(new StringBuilder(left).reverse());

                return ans.toString();
            }

            i--;
        }

        return "";
    }
}