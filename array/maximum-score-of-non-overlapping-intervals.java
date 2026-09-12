import java.util.*;

class Solution {
    static class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    static class State {
        long weight;
        List<Integer> selected;

        State(long weight, List<Integer> selected) {
            this.weight = weight;
            this.selected = selected;
        }
    }

    private List<Interval> a;
    private State[][] memo;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> x = intervals.get(i);
            a.add(new Interval(x.get(0), x.get(1), x.get(2), i));
        }

        a.sort((x, y) -> {
            if (x.l != y.l) return Integer.compare(x.l, y.l);
            if (x.r != y.r) return Integer.compare(x.r, y.r);
            return Integer.compare(x.idx, y.idx);
        });

        memo = new State[n][5];

        List<Integer> result = dp(0, 4).selected;

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private State dp(int i, int k) {
        if (i == a.size() || k == 0) {
            return new State(0, new ArrayList<>());
        }

        if (memo[i][k] != null) {
            return memo[i][k];
        }

        State skip = dp(i + 1, k);

        int next = findNext(i, a.get(i).r);
        State rest = dp(next, k - 1);

        List<Integer> selected = new ArrayList<>(rest.selected);
        selected.add(a.get(i).idx);
        Collections.sort(selected);

        State take = new State(
            a.get(i).w + rest.weight,
            selected
        );

        State result;

        if (take.weight > skip.weight) {
            result = take;
        } else if (take.weight < skip.weight) {
            result = skip;
        } else {
            result = compare(take.selected, skip.selected) < 0 ? take : skip;
        }

        memo[i][k] = result;
        return result;
    }

    private int findNext(int i, int right) {
        int lo = i + 1;
        int hi = a.size();

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (a.get(mid).l > right) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private int compare(List<Integer> x, List<Integer> y) {
        int n = Math.min(x.size(), y.size());

        for (int i = 0; i < n; i++) {
            if (!x.get(i).equals(y.get(i))) {
                return Integer.compare(x.get(i), y.get(i));
            }
        }

        return Integer.compare(x.size(), y.size());
    }
}