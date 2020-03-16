package algorithm_practice.leetcode.code0100;

public class E0121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        if (prices.length <= 1) {
            return ans;
        }
        int minToI = prices[0];
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - minToI);
            minToI = Math.min(minToI, prices[i]);
        }
        return ans;
    }
}
