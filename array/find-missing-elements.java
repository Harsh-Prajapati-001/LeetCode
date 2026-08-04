import java.util.*;
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        Set<Integer> present = new HashSet<>();

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            present.add(num);
        }

        List<Integer> result = new ArrayList<>();

        for (int num = min; num <= max; num++) {
            if (!present.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }
}
