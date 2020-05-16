package algorithm_practice.leetcode.code0100;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class M0179_最大数 {

    int[] nums;

    boolean cmp(StringBuilder s1, StringBuilder s2) {
        StringBuilder a = new StringBuilder().append(s1).append(s2);
        StringBuilder b = new StringBuilder().append(s2).append(s1);
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > b.charAt(i))
                return true;
            else if (a.charAt(i) < b.charAt(i))
                return false;
        }
        return true;
    }

    private StringBuilder merge(StringBuilder s1, StringBuilder s2) {
        if (cmp(s1, s2)) {
            return new StringBuilder().append(s1).append(s2);
        } else {
            return new StringBuilder().append(s2).append(s1);
        }
    }

    private StringBuilder mergeNum(int start, int end) {
        if (end <= start)
            return new StringBuilder().append(nums[start]);
        int mid = start + (end - start) / 2;
        return merge(mergeNum(start, mid), mergeNum(mid + 1, end));
    }

    public String largestNumberMergeWrong(int[] nums) {
        this.nums = nums;
        return mergeNum(0, nums.length - 1).toString();
    }

    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String a = o1 + o2;
            String b = o2 + o1;
            //32 321
            //32 329
            return b.compareTo(a);
        }
    }

    public String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs, new LargerNumberComparator());

        if (asStrs[0] == "0")
            return "0";
        StringBuilder ans = new StringBuilder();
        for (String k : asStrs) {
            ans.append(k);
        }

        return ans.toString();
    }

    @Test
    public void test() {
        System.out.println(largestNumber(new int[]{10, 2, 3}));
        System.out.println(String.valueOf(new char[]{'0', '0'}));
    }


}
