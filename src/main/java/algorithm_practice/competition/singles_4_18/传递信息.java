package algorithm_practice.competition.singles_4_18;

import java.util.*;

public class 传递信息 {


    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < relation.length; i++) {
            int key = relation[i][0];
            if (map.containsKey(key)) {
                Set<Integer> temp = map.get(key);
                temp.add(relation[i][1]);
                map.put(key, temp);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(relation[i][1]);
                map.put(key, set);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        for (int i = 0; i < k; i++) {
            Queue<Integer> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                int r0 = queue.poll();
                if (map.containsKey(r0)) {
                    Set<Integer> r1set = map.get(r0);
                    for (Integer integer : r1set) {
                        temp.add(integer);
                    }
                }
            }
            queue = temp;
        }
        int ans = 0;
        for (Integer integer : queue) {
            if (integer == n - 1)
                ans++;
        }
        return ans;
    }

}
