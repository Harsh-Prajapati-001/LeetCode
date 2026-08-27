class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            int x = target.charAt(i) - 'a';

            if (cnt[x] == 0) {
                for (int c = x + 1; c < 26; c++) {
                    if (cnt[c] > 0) {
                        return build(cnt, target, i, c);
                    }
                }

                return backtrack(cnt, target, i - 1);
            }

            cnt[x]--;
        }

        return backtrack(cnt, target, n - 1);
    }

    private String backtrack(int[] cnt, String target, int pos) {
        for (int i = pos; i >= 0; i--) {
            int x = target.charAt(i) - 'a';
            cnt[x]++;

            for (int c = x + 1; c < 26; c++) {
                if (cnt[c] > 0) {
                    return build(cnt, target, i, c);
                }
            }
        }

        return "";
    }

    private String build(int[] cnt, String target, int pos, int c) {
        StringBuilder ans = new StringBuilder();

        ans.append(target, 0, pos);
        ans.append((char) ('a' + c));

        cnt[c]--;

        for (int i = 0; i < 26; i++) {
            while (cnt[i] > 0) {
                ans.append((char) ('a' + i));
                cnt[i]--;
            }
        }

        return ans.toString();
    }
}