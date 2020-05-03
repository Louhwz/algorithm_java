package algorithm_practice.competition.singles_4_18;

import org.junit.Test;

import java.util.Arrays;

public class 剧情触发时间 {
    private boolean[] visited;
    private int[][] requirements;

    private boolean greater(int[] ability, int k) {
        for (int i = 0; i < ability.length; i++) {
            if (ability[i] < requirements[k][i])
                return false;
        }
        return true;
    }

    //increase[0].length = requirements[0].length
    public int[] getTriggerTimeViolence(int[][] increase, int[][] requirements) {
        int[] ability = new int[increase[0].length];
        visited = new boolean[requirements.length];
        this.requirements = requirements;
        int[] ans = new int[requirements.length];
        Arrays.fill(ans, -1);
        int day = 0;
        for (int i = 0; i < requirements.length; i++) {
            if (greater(ability, i)) {
                ans[i] = day;
                visited[i] = true;
            }
        }
        day++;
        for (int i = 0; i < increase.length; i++) {
            for (int j = 0; j < increase[0].length; j++) {
                ability[j] += increase[i][j];
            }
            for (int j = 0; j < requirements.length; j++) {
                if (!visited[j] && greater(ability, j)) {
                    ans[j] = day;
                    visited[j] = true;
                }
            }
            day++;
        }
        return ans;
    }

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        for (int i = 1; i < increase.length; i++) {
            increase[i][0] += increase[i - 1][0];
            increase[i][1] += increase[i - 1][1];
            increase[i][2] += increase[i - 1][2];
        }
        int[] ans = new int[requirements.length];
        for (int i = 0; i < requirements.length; i++) {
            if (requirements[i][0] == 0 && requirements[i][1] == 0 && requirements[i][2] == 0) {
                ans[i] = 0;
                continue;
            }
            int left = 0, right = increase.length;
            while (left < right) {
                int middle = (left + right) >> 1;
                if (increase[middle][0] >= requirements[i][0] && increase[middle][1] >= requirements[i][1] && increase[middle][2] >= requirements[i][2]) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
            }
            ans[i] = (left == increase.length) ? -1 : left;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(16 >> 2);
    }
}
