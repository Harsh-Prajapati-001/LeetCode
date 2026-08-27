import java.util.*;

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        // Try to construct the smallest permutation > target
        StringBuilder ans = new StringBuilder();

        boolean[] used = new boolean[chars.length];

        if (backtrack(chars, target, ans, used, 0)) {
            return ans.toString();
        }

        return "";
    }

    private boolean backtrack(char[] chars, String target,
                              StringBuilder ans, boolean[] used, int pos) {

        if (pos == chars.length) {
            return ans.toString().compareTo(target) > 0;
        }

        char previous = 0;

        for (int i = 0; i < chars.length; i++) {
            if (used[i] || chars[i] == previous) {
                continue;
            }

            previous = chars[i];

            ans.append(chars[i]);
            used[i] = true;

            if (backtrack(chars, target, ans, used, pos + 1)) {
                return true;
            }

            used[i] = false;
            ans.deleteCharAt(ans.length() - 1);
        }

        return false;
    }
}