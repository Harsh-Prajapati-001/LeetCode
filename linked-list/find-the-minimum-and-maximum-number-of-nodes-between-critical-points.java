class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int last = -1;
        int minDist = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        while (curr.next != null) {
            int a = prev.val;
            int b = curr.val;
            int c = curr.next.val;

            if ((b > a && b > c) || (b < a && b < c)) {
                if (first == -1) {
                    first = index;
                } else {
                    minDist = Math.min(minDist, index - last);
                }

                last = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        if (first == last) {
            return new int[] {-1, -1};
        }

        return new int[] {minDist, last - first};
    }
}