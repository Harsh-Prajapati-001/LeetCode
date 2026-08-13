class Solution {
    class Node {
        int len;
        int pref;
        int suff;
        int best;
        char leftChar;
        char rightChar;
    }

    private Node[] tree;
    private char[] arr;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree[1].best;
        }

        return ans;
    }

    private void build(int idx, int l, int r) {
        tree[idx] = new Node();

        if (l == r) {
            Node node = tree[idx];
            node.len = 1;
            node.pref = 1;
            node.suff = 1;
            node.best = 1;
            node.leftChar = arr[l];
            node.rightChar = arr[l];
            return;
        }

        int mid = (l + r) / 2;
        build(idx * 2, l, mid);
        build(idx * 2 + 1, mid + 1, r);
        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    private void update(int idx, int l, int r, int pos, char c) {
        if (l == r) {
            arr[pos] = c;
            Node node = tree[idx];
            node.leftChar = c;
            node.rightChar = c;
            node.pref = 1;
            node.suff = 1;
            node.best = 1;
            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid) {
            update(idx * 2, l, mid, pos, c);
        } else {
            update(idx * 2 + 1, mid + 1, r, pos, c);
        }

        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    private Node merge(Node left, Node right) {
        Node res = new Node();

        res.len = left.len + right.len;
        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;

        res.pref = left.pref;
        if (left.pref == left.len && left.rightChar == right.leftChar) {
            res.pref = left.len + right.pref;
        }

        res.suff = right.suff;
        if (right.suff == right.len && left.rightChar == right.leftChar) {
            res.suff = right.len + left.suff;
        }

        res.best = Math.max(left.best, right.best);

        if (left.rightChar == right.leftChar) {
            res.best = Math.max(res.best, left.suff + right.pref);
        }

        return res;
    }
}